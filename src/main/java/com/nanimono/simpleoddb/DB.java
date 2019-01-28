package com.nanimono.simpleoddb;

import com.nanimono.simpleoddb.executorhelper.ThrowingErrorListener;
import com.nanimono.simpleoddb.executorhelper.antlr4.OddlGrammarLexer;
import com.nanimono.simpleoddb.executorhelper.antlr4.OddlGrammarParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.util.Queue;

public class DB {
    private static DB _instance = new DB();
    private final Catalog _catalog;
    private final ObjectStorage _objectLists;

    private DB() {
        _catalog = new Catalog();
        _objectLists = new ObjectStorage();
    }

    static Catalog getCatalog() { return _instance._catalog; }

    static ObjectStorage getObjectStorage() { return _instance._objectLists; }

    private static String queryResultToString(Queue<String> queryResult) {
        StringBuilder builder = new StringBuilder();
        String temp;
        while ((temp = queryResult.poll()) != null) {
            builder.append("==============================\n");
            builder.append(temp);
            builder.append("\n");
        }
        return new String(builder);
    }

    public static void reset() { _instance = new DB(); }

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
            Executor executor = new Executor();
            walker.walk(executor, tree);
            return queryResultToString(executor.getQueryResults());
        } catch (ParseCancellationException e) {
            return e.getMessage();
        }
    }
}
