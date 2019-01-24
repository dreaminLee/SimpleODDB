package com.nanimono.simpleoddb.object;

import java.io.Serializable;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 对象类
 */
public class Object implements Serializable {

    private long oid;

    private int belongClassId;

    private Field[] fields;

    private int len;

    public Object() {
        this.oid = -1;
        this.belongClassId = -1;
        this.len = -1;
        this.fields = null;
    }

    public long getOid() {
        return oid;
    }

    public void setOid(long oid) {
        this.oid = oid;
    }

    public int getBelongClassId() {
        return belongClassId;
    }

    public void setBelongClassId(int belongClassId) {
        this.belongClassId = belongClassId;
    }

    public int getLen() {
        return len;
    }

    public void setLen(int len) {
        this.len = len;
    }

    private boolean isIndexValid(int i) {
        return i >= 0 && i < fields.length;
    }

    public Field getField(int i) {
        if (!isIndexValid(i)) throw new IllegalArgumentException("Index out of bound.");
        return fields[i];
    }

    public void setField(int i, Field f) {
        if (!isIndexValid(i)) throw new IllegalArgumentException("Index out of bound.");
        fields[i] = f;
    }

    public void setField(Field[] fields) {
        this.fields = fields;
    }

    public FieldIterator getFieldIterator() {
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
            if (!hasNext()) throw new NoSuchElementException();
            return fields[pos++];
        }
    }
}
