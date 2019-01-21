package com.nanimono.simpleoddb.object;

import java.io.DataOutputStream;
import java.io.IOException;
import java.lang.Object;

public class BooleanField implements Field {

    private boolean value;

    public boolean getValue() { return value; }

    public BooleanField(boolean value) { this.value = value; }

    @Override
    public String toString() { return Boolean.toString(value); }

    @Override
    public int hashCode() { return Boolean.hashCode(value); }

    @Override
    public boolean equals(Object field) { return ((BooleanField) field).value == value; }

    @Override
    public void serialize(DataOutputStream dos) throws IOException {
        dos.writeBoolean(value);
    }

    // TODO compare method

    @Override
    public TypeEnum getType() {
        return TypeEnum.BOOLEAN_TYPE;
    }

    @Override
    public int getSize() {
        return TypeEnum.BOOLEAN_TYPE.getSize();
    }
}
