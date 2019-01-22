package com.nanimono.simpleoddb.object;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class PtrField implements Field {

    private Field ptr;

    @Override
    public void serialize(DataOutputStream dos) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(dos);
        out.writeObject(ptr);
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
