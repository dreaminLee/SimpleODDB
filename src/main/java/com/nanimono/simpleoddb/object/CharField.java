package com.nanimono.simpleoddb.object;

import java.lang.Object;

public class CharField implements Field {

    private String value;
    private int len;

    public String getValue() { return value; }

    public CharField(String value) {
        this.value = value;
        this.len = value.length();
    }

    @Override
    public String toString() { return value; }

    @Override
    public int hashCode() { return value.hashCode(); }

    @Override
    public boolean equals(Object field) { return ((CharField)field).value.equals(value); }

    @Override
    public TypeEnum getType() {
        return TypeEnum.CHAR_TYPE;
    }

    @Override
    public int getSize() {
        return len;
    }
}
