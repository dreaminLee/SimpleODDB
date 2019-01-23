package com.nanimono.simpleoddb;

import com.nanimono.simpleoddb.executor.ExecutorListener;
import com.nanimono.simpleoddb.executor.ExprTreeNode;
import com.nanimono.simpleoddb.executor.antlr4.OddlGrammarLexer;
import com.nanimono.simpleoddb.executor.antlr4.OddlGrammarParser;
import com.nanimono.simpleoddb.object.Object;
import com.nanimono.simpleoddb.object.Type;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class DB {
    private static DB _instance = new DB();
    private final Catalog _catalog;
    private final ObjectStorage _objectLists;

    private DB() {
        _catalog = new Catalog();
        _objectLists = new ObjectStorage();
    }

    public static Catalog getCatalog() { return _instance._catalog; }

    public static ObjectStorage getObjectStorage() { return _instance._objectLists; }

    public static void addSourceClass(String className, String[] attrNameList, Type[] typeList) {
        getCatalog().addSourceClass(className, attrNameList, typeList);
        getObjectStorage().addObjectList(DB.getCatalog().getClassId(className));
    }

    public static void addSelectDeputyClass(String className,
                                     String sClassName,
                                     String[] switchExprs,
                                     String[] attrNameList,
                                     String deputyRule,
                                     ExprTreeNode[] exprTrees) {
        getCatalog().addSelectDeputyClass(className, sClassName, switchExprs, attrNameList, deputyRule, exprTrees);
        getObjectStorage().addObjectList(DB.getCatalog().getClassId(className));
        getObjectStorage().addBiPointerTable(DB.getCatalog().getClassId(className));
    }

    public static void dropClass(String className) {

        // TODO: 修改对象

        getCatalog().dropClass(className);
    }

    public static void insertObject(int classId, Object object) {
        getObjectStorage().insertObject(classId, object);
    }

    public static void deleteObject(int classId, String deputyRule) {
        getObjectStorage().deleteObject(classId, deputyRule);
    }

    public void reset() { _instance = new DB(); }


    public static void main(String[] args) throws IOException {
        Path path = FileSystems.getDefault().getPath("src\\test", "oddl_test.oddl");
        CharStream charStream = CharStreams.fromPath(path);
        OddlGrammarLexer lexer = new OddlGrammarLexer(charStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        OddlGrammarParser parser = new OddlGrammarParser(tokens);
        ParseTree tree = parser.root();

        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(new ExecutorListener(), tree);
    }
}
