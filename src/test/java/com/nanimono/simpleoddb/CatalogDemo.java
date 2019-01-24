package com.nanimono.simpleoddb;

import java.io.IOException;

public class CatalogDemo {

    public static void main (String[] args) throws IOException {

        /*
        Catalog catalog = new Catalog();

        Path path = FileSystems.getDefault().getPath("src\\test", "oddl_test.oddl");
        CharStream charStream = CharStreams.fromPath(path);
        OddlGrammarLexer lexer = new OddlGrammarLexer(charStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        OddlGrammarParser parser = new OddlGrammarParser(tokens);
        ParseTree tree = parser.root();

        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(new Executor(catalog), tree);

        try {
            FileOutputStream fileOut = new FileOutputStream("D:\\TEMP\\catalog.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(catalog);
            out.close();
            fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Catalog catalog1 = null;
        try {
            FileInputStream fileIn = new FileInputStream("D:\\TEMP\\catalog.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            catalog1 = (Catalog) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }
        */
    }
}
