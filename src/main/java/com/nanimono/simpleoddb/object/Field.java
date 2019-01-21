package com.nanimono.simpleoddb.object;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.Serializable;

public interface Field extends Serializable {

    void serialize(DataOutputStream dos) throws IOException;

    // TODO: compare method

    TypeEnum getType();

    int getSize();

    @Override
    int hashCode();

    @Override
    boolean equals(java.lang.Object field);

    @Override
    String toString();
}
