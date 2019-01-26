package com.nanimono.simpleoddb.object;

import java.lang.Object;

public class BooleanField implements Field {

    private boolean value;

    public BooleanField(boolean value) { this.value = value; }

    public boolean getValue() { return value; }

    @Override
    public String toString() { return Boolean.toString(value); }

    @Override
    public int hashCode() { return Boolean.hashCode(value); }

    @Override
    public boolean equals(Object field) { return ((BooleanField) field).value == value; }

    @Override
    public TypeEnum getType() {
        return TypeEnum.BOOLEAN_TYPE;
    }

    @Override
    public int getSize() {
        return TypeEnum.BOOLEAN_TYPE.getSize();
    }
}
