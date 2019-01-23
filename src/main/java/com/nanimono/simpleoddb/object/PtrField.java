package com.nanimono.simpleoddb.object;

import java.io.DataOutputStream;
import java.io.IOException;

public class PtrField implements Field {

    private Field ptr;

    public PtrField(Field field) {
        this.ptr = field;
    }

    public java.lang.Object getValue() {
        switch (ptr.getType()) {
            case FLOAT_TYPE:
                return ((FloatField) ptr).getValue();
            case INT_TYPE:
                return ((IntField) ptr).getValue();
            case CHAR_TYPE:
                return ((CharField) ptr).getValue();
            case BOOLEAN_TYPE:
                return ((BooleanField) ptr).getValue();
            default:
                throw new IllegalStateException("Impossible to reach here.");
        }
    }

    @Override
    public void serialize(DataOutputStream dos) throws IOException {

    }

    @Override
    public TypeEnum getType() {
        return ptr.getType();
    }

    @Override
    public int getSize() {
        return ptr.getSize();
    }
}
