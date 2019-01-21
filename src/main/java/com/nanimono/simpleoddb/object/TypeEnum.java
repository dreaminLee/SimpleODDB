package com.nanimono.simpleoddb.object;

import java.io.Serializable;

public enum TypeEnum implements Serializable {
    BOOLEAN_TYPE() {
        @Override
        public int getSize() {
            return 1;
        }
    },
    CHAR_TYPE() {
        @Override
        public int getSize() {
            return DEFAULT_CHAR_LEN + 4;
        }
    },
    INT_TYPE() {
        @Override
        public int getSize() {
            return 4;
        }
    },
    LONG_TYPE() {
        @Override
        public int getSize() {
            return 8;
        }
    },
    FLOAT_TYPE() {
        @Override
        public int getSize() {
            return 4;
        }
    };

    public static final int DEFAULT_CHAR_LEN = 128;

    public abstract int getSize();
}
