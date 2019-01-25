package com.nanimono.simpleoddb;

import com.nanimono.simpleoddb.executorhelper.ExprTreeNode;
import com.nanimono.simpleoddb.executorhelper.ThrowingErrorListener;
import com.nanimono.simpleoddb.executorhelper.antlr4.OddlGrammarLexer;
import com.nanimono.simpleoddb.executorhelper.antlr4.OddlGrammarParser;
import com.nanimono.simpleoddb.object.Field;
import com.nanimono.simpleoddb.object.Object;
import com.nanimono.simpleoddb.object.Type;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.Queue;

public class DB {
    private static DB _instance = new DB();
    private final Catalog _catalog;
    private final ObjectStorage _objectLists;
    private Queue<String> _queryResult;

    private DB() {
        _catalog = new Catalog();
        _objectLists = new ObjectStorage();
        _queryResult = new LinkedList<>();
    }

    static Catalog getCatalog() { return _instance._catalog; }

    static ObjectStorage getObjectStorage() { return _instance._objectLists; }

    private static Queue<String> getQueryResult() {
        return _instance._queryResult;
    }

    private static String queryResultToString() {
        StringBuilder builder = new StringBuilder();
        String temp;
        while ((temp = getQueryResult().poll()) != null) {
            builder.append("==============================\n");
            builder.append(temp);
            builder.append("\n");
        }
        return new String(builder);
    }

    static void addMessage(String message) {
        getQueryResult().offer(message);
    }

    static void addSourceClass(String className, String[] attrNameList, Type[] typeList) {
        try {
            getCatalog().addSourceClass(className, attrNameList, typeList);
            getObjectStorage().addObjectList(DB.getCatalog().getClassId(className));
        } catch (IllegalArgumentException e) {
            getQueryResult().offer(e.getMessage());
        }
    }

    static void addSelectDeputyClass(String className,
                                     String sClassName,
                                     String[] switchExprs,
                                     String[] attrNameList,
                                     String deputyRule,
                                     ExprTreeNode[] exprTrees) {
        try {
            getCatalog().addSelectDeputyClass(className, sClassName, switchExprs, attrNameList, deputyRule, exprTrees);
            getObjectStorage().addObjectList(DB.getCatalog().getClassId(className));
        } catch (IllegalArgumentException e) {
            getQueryResult().offer(e.getMessage());
        }
    }

    static void dropClass(String className) {

        int classId = getCatalog().getClassId(className);
        getObjectStorage().clearObject(classId);
        getObjectStorage().removeObjectList(classId);

        getCatalog().dropClass(className);
    }

    static void insertObject(Object object) {
        getObjectStorage().insertObject(object);
    }

    static void deleteObject(int classId, String deputyRule) {
        getObjectStorage().deleteObject(classId, deputyRule);
    }

    static void updateObject(int classId, String updateRule, Field[] fields) {
        getObjectStorage().updateObject(classId, updateRule, fields);
    }

    static void simpleQuery(int classId, boolean[] isQueryList, String filter) {
         getQueryResult().offer(getObjectStorage().simpleQuery(classId, isQueryList, filter));
    }

    static void crossClassQuery(int fromClassId, int destClassId, boolean[] isQueryList, String filter) {
        getQueryResult().offer(getObjectStorage().crossClassQuery(fromClassId, destClassId, isQueryList, filter));
    }

    public static void reset() { _instance = new DB(); }

    public static String execute(InputStream is) throws IOException {
        CharStream charStream = CharStreams.fromStream(is);
        OddlGrammarLexer lexer = new OddlGrammarLexer(charStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        OddlGrammarParser parser = new OddlGrammarParser(tokens);
        parser.removeErrorListeners();
        parser.addErrorListener(new ThrowingErrorListener());
        try {
            ParseTree tree = parser.root();
            ParseTreeWalker walker = new ParseTreeWalker();
            walker.walk(new Executor(), tree);
            return queryResultToString();
        } catch (ParseCancellationException e) {

        } finally {
            return null;
        }
    }

    public static String execute(String oddlSentence) {
        CharStream charStream = CharStreams.fromString(oddlSentence);
        OddlGrammarLexer lexer = new OddlGrammarLexer(charStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        OddlGrammarParser parser = new OddlGrammarParser(tokens);
        parser.removeErrorListeners();
        parser.addErrorListener(new ThrowingErrorListener());
        try {
            ParseTree tree = parser.root();
            ParseTreeWalker walker = new ParseTreeWalker();
            walker.walk(new Executor(), tree);
            return queryResultToString();
        } catch (ParseCancellationException e) {
            getQueryResult().offer(e.getMessage());
            return queryResultToString();
        }
    }
}
