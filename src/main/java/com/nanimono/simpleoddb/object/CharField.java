package com.nanimono.simpleoddb.object;

import java.io.DataOutputStream;
import java.io.IOException;
import java.lang.Object;

public class CharField implements Field {

    private char[] value;
    private int len;

    public char[] getValue() { return value; }

    public CharField(char[] value) {
        this.value = value;
        this.len = value.length;
    }

    @Override
    public String toString() { return String.copyValueOf(value); }

    @Override
    public int hashCode() { return String.valueOf(value).hashCode(); }

    @Override
    public boolean equals(Object field) { return ((CharField) field).value == value; }

    @Override
    public void serialize(DataOutputStream dos) throws IOException {
        String s = String.valueOf(value);
        dos.writeInt(len);
        dos.writeBytes(s);
    }

    // TODO compare method

    @Override
    public TypeEnum getType() {
        return TypeEnum.CHAR_TYPE;
    }

    @Override
    public int getSize() {
        return len;
    }
}
