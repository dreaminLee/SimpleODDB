package com.nanimono.simpleoddb;

import com.nanimono.simpleoddb.executorhelper.ExprTreeNode;
import com.nanimono.simpleoddb.executorhelper.antlr4.OddlGrammarLexer;
import com.nanimono.simpleoddb.executorhelper.antlr4.OddlGrammarParser;
import com.nanimono.simpleoddb.object.Field;
import com.nanimono.simpleoddb.object.Object;
import com.nanimono.simpleoddb.object.Type;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;

public class DB {
    private static DB _instance = new DB();
    private final Catalog _catalog;
    private final ObjectStorage _objectLists;

    private DB() {
        _catalog = new Catalog();
        _objectLists = new ObjectStorage();
    }

    static Catalog getCatalog() { return _instance._catalog; }

    private static ObjectStorage getObjectStorage() { return _instance._objectLists; }

    static void addSourceClass(String className, String[] attrNameList, Type[] typeList) {
        getCatalog().addSourceClass(className, attrNameList, typeList);
        getObjectStorage().addObjectList(DB.getCatalog().getClassId(className));
    }

    static void addSelectDeputyClass(String className,
                                     String sClassName,
                                     String[] switchExprs,
                                     String[] attrNameList,
                                     String deputyRule,
                                     ExprTreeNode[] exprTrees) {
        getCatalog().addSelectDeputyClass(className, sClassName, switchExprs, attrNameList, deputyRule, exprTrees);
        getObjectStorage().addObjectList(DB.getCatalog().getClassId(className));
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
        System.out.println(getObjectStorage().simpleQuery(classId, isQueryList, filter));
    }

    static void crossClassQuery(int fromClassId, int destClassId, boolean[] isQueryList, String filter) {
        System.out.println(getObjectStorage().crossClassQuery(fromClassId, destClassId, isQueryList, filter));
    }

    public static void reset() { _instance = new DB(); }

    public static void execute(InputStream is) throws IOException {
        CharStream charStream = CharStreams.fromStream(is);
        OddlGrammarLexer lexer = new OddlGrammarLexer(charStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        OddlGrammarParser parser = new OddlGrammarParser(tokens);
        ParseTree tree = parser.root();
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(new Executor(), tree);
    }

    public static void execute(String oddlSentence) {
        CharStream charStream = CharStreams.fromString(oddlSentence);
        OddlGrammarLexer lexer = new OddlGrammarLexer(charStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        OddlGrammarParser parser = new OddlGrammarParser(tokens);
        ParseTree tree = parser.root();
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(new Executor(), tree);
    }

    public static void main(String[] args) {
        try {
            InputStream is = new FileInputStream("D:\\Codes\\ODDB\\SimpleODDB\\src\\test\\oddl_test.oddl");
            DB.execute(is);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
