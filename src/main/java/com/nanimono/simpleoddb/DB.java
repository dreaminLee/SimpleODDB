package com.nanimono.simpleoddb;

public class DB {
    private static DB _instance = new DB();
    private final Catalog _catalog;

    private DB() {
        _catalog = new Catalog();
    }

    public static Catalog getCatalog() { return _instance._catalog; }

    public void reset() { _instance = new DB(); }
}
