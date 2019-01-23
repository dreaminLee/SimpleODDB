package com.nanimono.simpleoddb.object;

import com.nanimono.simpleoddb.Catalog;
import com.nanimono.simpleoddb.DB;

import java.io.Serializable;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 对象类
 */
public class Object implements Serializable {

    private int oid;

    private int belongClassId;

    private Field[] fields;

    private int len;

    public Object(int classId) {
        if (!DB.getCatalog().isClassExist(classId))
            throw new IllegalArgumentException("Class doesn't exist.");
        this.belongClassId = classId;
        this.fields = new Field[DB.getCatalog().getClassAttrList(belongClassId).length];
        this.len = 0;
        Iterator<Catalog.AttrTableTuple> attrIterator = DB.getCatalog().getClassAttrIterator(classId);
        while (attrIterator.hasNext()) {
            len += attrIterator.next().getSize();
        }
    }

    public Catalog.ClassType getObjectType() {
        return DB.getCatalog().getClassType(belongClassId);
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public int getBelongClassId() {
        return belongClassId;
    }

    public int getLen() {
        return len;
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
