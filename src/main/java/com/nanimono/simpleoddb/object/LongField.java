package com.nanimono.simpleoddb.object;

import java.io.DataOutputStream;
import java.io.IOException;
import java.lang.Object;

public class LongField implements Field {

    private long value;

    public long getValue() { return value; }

    public LongField(long value) { this.value = value; }

    @Override
    public String toString() { return Long.toString(value); }

    @Override
    public int hashCode() { return Long.hashCode(value); }

    @Override
    public boolean equals(Object field) { return ((LongField) field).value == value; }

    @Override
    public void serialize(DataOutputStream dos) throws IOException {
        dos.writeLong(value);
    }

    // TODO compare method

    @Override
    public TypeEnum getType() {
        return TypeEnum.LONG_TYPE;
    }

    @Override
    public int getSize() {
        return TypeEnum.LONG_TYPE.getSize();
    }
}
