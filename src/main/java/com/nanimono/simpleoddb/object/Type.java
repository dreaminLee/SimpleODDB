package com.nanimono.simpleoddb.object;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;

public class Type implements Serializable {

    private TypeEnum typeEnum;
    private int size;  // usable only for CHAR_TYPE

    public int getSize() {
        return typeEnum == TypeEnum.CHAR_TYPE ? size : typeEnum.getSize();
    }

    public void setSize(int size) {
        if (typeEnum != TypeEnum.CHAR_TYPE) return;
        this.size = size;
    }

    public TypeEnum getTypeEnum() {
        return typeEnum;
    }

    public Type(TypeEnum type) {
        this.typeEnum = type;
        this.size = type.getSize();
    }

    public Type(TypeEnum type, int size) {
        this.typeEnum = type;
        this.size = type == TypeEnum.CHAR_TYPE ? size : type.getSize();
    }

    public Type(Type old) {
        this.typeEnum = old.typeEnum;
        this.size = old.size;
    }

    public Field parse(DataInputStream dis) throws ParseException {
        try {
            switch (typeEnum) {
                case BOOLEAN_TYPE:
                    return new BooleanField(dis.readBoolean());

                case INT_TYPE:
                    return new IntField(dis.readInt());

                case CHAR_TYPE:
                    int len = dis.readInt();
                    byte[] bs = new byte[len];
                    dis.read(bs);
                    String text = new String(bs);
                    return new CharField(text.toCharArray());

                case LONG_TYPE:
                    return new LongField(dis.readLong());

                case FLOAT_TYPE:
                    return new FloatField(dis.readFloat());

                    default: return null;
            }
        } catch (IOException e) {
            throw new ParseException("Couldn't parse", 0);
        }
    }

}
