package com.nanimono.simpleoddb.executor;

import com.nanimono.simpleoddb.Catalog;
import com.nanimono.simpleoddb.executor.antlr4.OddlGrammarLexer;
import com.nanimono.simpleoddb.executor.antlr4.OddlGrammarParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;


public class Executor {

    public static void main(String[] args) throws IOException {
        Catalog catalog = new Catalog();

        Path path = FileSystems.getDefault().getPath("src\\test", "oddl_test.oddl");
        CharStream charStream = CharStreams.fromPath(path);
        OddlGrammarLexer lexer = new OddlGrammarLexer(charStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        OddlGrammarParser parser = new OddlGrammarParser(tokens);
        ParseTree tree = parser.root();

        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(new ExecutorListener(catalog), tree);

        //System.out.println(tree.toStringTree(executor));
    }
}
