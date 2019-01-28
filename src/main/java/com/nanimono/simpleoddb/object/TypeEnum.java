package com.nanimono.simpleoddb.object;

import java.io.Serializable;

public enum TypeEnum implements Serializable {
    BOOLEAN_TYPE() {
        @Override
        public int getSize() {
            return 1;
        }

        @Override
        public String toString() {
            return "boolean";
        }
    },
    CHAR_TYPE() {
        @Override
        public int getSize() {
            return DEFAULT_CHAR_LEN + 4;
        }

        @Override
        public String toString() {
            return "char";
        }
    },
    INT_TYPE() {
        @Override
        public int getSize() {
            return 4;
        }

        @Override
        public String toString() {
            return "int";
        }
    },
    FLOAT_TYPE() {
        @Override
        public int getSize() {
            return 4;
        }

        @Override
        public String toString() {
            return "float";
        }
    };

    public static final int DEFAULT_CHAR_LEN = 256;

    public abstract int getSize();

    public abstract String toString();
}
