package com.nanimono.simpleoddb.object;

import java.io.Serializable;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * ClassDesc describes the schema of a class.
 */

public class ClassDesc implements Serializable {

    /**
     *  the number of fields.
     */
    private int numFields;

    private CDItem[] cdAr;

    /**
     * A class helping to organize the information of each field
     */
    public static class CDItem implements Serializable {

        /**
         * The type of the field
         */
        Type fieldType;

        /**
         * The name of the field
         */
        String fieldName;

        public CDItem(Type type, String name) {
            this.fieldName = name;
            this.fieldType = type;
        }

        @Override
        public String toString() {
            String text = fieldName + "(" + fieldType;
            if (fieldType.getTypeEnum() == TypeEnum.CHAR_TYPE)
                text += "(" + fieldType.getSize() + ")";
            text += ")";
            return text;
        }

        @Override
        public boolean equals(java.lang.Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof CDItem) {
                CDItem another = (CDItem) obj;

                boolean nameEquals = (fieldName == null && another.fieldName == null)
                        || fieldName.equals(another.fieldName);
                boolean typeEquals = fieldType.equals(another.fieldType);
                return nameEquals && typeEquals;
            } else return false;
        }
    }

    /**
     *
     * @return An iterator which iterates over all the field CDItems
     * that are included in this ClassDesc
     */
    public Iterator<CDItem> iterator() {
        return new CDItemIterator();
    }

    private class CDItemIterator implements Iterator<CDItem> {

        private int pos = 0;

        @Override
        public boolean hasNext() {
            return cdAr.length > pos;
        }

        @Override
        public CDItem next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return cdAr[pos++];
        }
    }


    /**
     * Create a new ClassDesc using a Type array and a String array
     * @param typeAr    stores Type information; at least one entry
     * @param fieldAr   must have the same number of entries of typeAr
     */
    public ClassDesc(Type[] typeAr, String[] fieldAr) {
        if (typeAr.length == 0) {
            throw new IllegalArgumentException("Type array is empty");
        }
        if (typeAr.length != fieldAr.length) {
            throw new IllegalArgumentException("Type array and name array have different size");
        }

        numFields = typeAr.length;
        cdAr = new CDItem[numFields];

        for (int i = 0; i < numFields; i++) {
            cdAr[i] = new CDItem(typeAr[i], fieldAr[i]);
        }
    }

    /**
     * ClassDesc(typeAr, new String[typeAr.length])
     * @param typeAr
     */
    public ClassDesc(Type[] typeAr) {
        this(typeAr, new String[typeAr.length]);
    }

    private ClassDesc(CDItem[] CDItems) {
        if (CDItems == null || CDItems.length == 0) {
            throw new IllegalArgumentException("CDItems is empty");
        }
        this.cdAr = CDItems;
        this.numFields = CDItems.length;
    }

    /**
     *
     * @return the number of fields in this ClassDesc
     */
    public int getNumFields() { return numFields; }

    /**
     * get the ith field's name of this ClassDesc
     * @param i
     * @return
     * @throws NoSuchElementException
     */
    public String getFieldName(int i) throws NoSuchElementException {
        if (i < 0 || i >= numFields) {
            throw new NoSuchElementException();
        }
        return cdAr[i].fieldName;
    }

    /**
     * get the ith field's type of this ClassDesc
     * @param i
     * @return
     * @throws NoSuchElementException
     */
    public Type getFieldType(int i) throws NoSuchElementException {
        if (i < 0 || i >= numFields) {
            throw new NoSuchElementException();
        }
        return cdAr[i].fieldType;
    }

    /**
     * Find the index of the field with a given name.
     * @param name name of the field, must not be null
     * @return
     * @throws NoSuchElementException
     */
    public int fieldNameToIndex(String name) throws NoSuchElementException {
        if (name == null) {
            throw new NoSuchElementException();
        }
        String fieldName;
        for (int i = 0; i < cdAr.length; i++) {
            if ((fieldName = cdAr[i].fieldName) != null && fieldName.equals(name)) {
                return i;
            }
        }
        throw new NoSuchElementException();
    }

    /**
     * @return The size (in bytes) of tuples corresponding to this TupleDesc.
     * Note that tuples from a given TupleDesc are of a fixed size.
     */
    public int getSize() {
        int totalSize = 0;
        for (CDItem item : cdAr) {
            totalSize += item.fieldType.getSize();
        }
        return totalSize;
    }

    /**
     * Merge two ClassDescs into one, with cd1.numFields + cd2.numFields fields,
     * with the first cd1.numFields coming from cd1 and the remaining from cd2.
     *
     * @param cd1
     * @param cd2
     * @return the new ClassDesc
     */
    public static ClassDesc merge(ClassDesc cd1, ClassDesc cd2) {
        CDItem[] CDItems1 = cd1.cdAr;
        CDItem[] CDItems2 = cd2.cdAr;
        int length1 = CDItems1.length;
        int length2 = CDItems2.length;
        CDItem[] resultItems = new CDItem[length1 + length2];
        System.arraycopy(CDItems1, 0, resultItems, 0, length1);
        System.arraycopy(CDItems2, 0, resultItems, length1, length2);
        return new ClassDesc(resultItems);
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ClassDesc) {
            ClassDesc another = (ClassDesc) obj;
            if (another.getNumFields() != getNumFields()) {
                return false;
            }
            for (int i = 0; i < getNumFields(); i++) {
                if (!cdAr[i].equals(another.cdAr[i])) {
                    return false;
                }
            }
            return true;
        } else return false;
    }

    public int hasCode() {
        // TODO hashCode
        throw new UnsupportedOperationException();
    }

    public String toString() {
        StringBuffer result = new StringBuffer();
        result.append("Fields: ");
        for (CDItem item : cdAr) {
            result.append(item.toString() + ", ");
        }
        return result.toString();
    }
}
