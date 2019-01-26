package com.nanimono.simpleoddb.object;

import java.io.Serializable;

public interface Field extends Serializable {

    TypeEnum getType();

    int getSize();

    @Override
    int hashCode();

    @Override
    boolean equals(java.lang.Object field);

    @Override
    String toString();
}
