package com.nanimono.simpleoddb.object;

import java.io.Serializable;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Object implements Serializable {

    private ClassDesc classDesc;

    private Field[] fields;

    // private RecordId recordId;

    /**
     * Create a new object with the specified schema (ClassDesc).
     * @param od the schema of this object.
     */
    public Object(ClassDesc od) {
        this.classDesc = od;
        fields = new Field[od.getNumFields()];
    }

    /**
     * @return the schema of this object
     */
    public ClassDesc getClassDesc() { return classDesc; }

    private boolean isValidIndex(int index) { return index >= 0 && index < fields.length; }

    public void setField(int i, Field f) {
        if (!isValidIndex(i)) throw new IllegalArgumentException("Index out of bound");
        fields[i] = f;
    }

    public Field getField(int i) {
        if (!isValidIndex(i)) throw new IllegalArgumentException("Index out of bound");
        return fields[i];
    }

    public String toString() {
        StringBuffer rowString = new StringBuffer();
        for (int i = 0; i < fields.length; i++) {
            if (i == fields.length - 1) {
                rowString.append(fields[i].toString());
            } else {
                rowString.append(fields[i].toString() + "\t");
            }
        }
        return rowString.toString();
    }

    public Iterator<Field> fieldIterator() {
        return new FieldIterator();
    }

    private class FieldIterator implements Iterator<Field> {

        private int pos = 0;

        @Override
        public boolean hasNext() {
            return fields.length > pos;
        }

        @Override
        public Field next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return fields[pos++];
        }
    }
}
