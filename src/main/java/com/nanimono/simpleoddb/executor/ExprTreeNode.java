package com.nanimono.simpleoddb.executor;

import com.nanimono.simpleoddb.object.TypeEnum;

public class ExprTreeNode {

    public enum ExprTreeNodeType {
        OP() {
            @Override
            public TypeEnum convertToType() {
                return null;
            }
        },
        VAR() {
            @Override
            public TypeEnum convertToType() {
                return null;
            }
        },
        CONST_CHAR() {
            @Override
            public TypeEnum convertToType() {
                return TypeEnum.CHAR_TYPE;
            }
        },
        CONST_INT() {
            @Override
            public TypeEnum convertToType() {
                return TypeEnum.INT_TYPE;
            }
        },
        CONST_FLOAT() {
            @Override
            public TypeEnum convertToType() {
                return TypeEnum.FLOAT_TYPE;
            }
        },
        CONST_BOOL() {
            @Override
            public TypeEnum convertToType() {
                return TypeEnum.BOOLEAN_TYPE;
            }
        };

        public abstract TypeEnum convertToType();
    }

    private ExprTreeNodeType type;
    private ExprTreeNode lchild;
    private ExprTreeNode rchild;
    private Object data;

    ExprTreeNode() {
        this.lchild = null;
        this.rchild = null;
    }

    public ExprTreeNodeType getType() {
        return type;
    }

    void setType(ExprTreeNodeType type) {
        this.type = type;
    }

    public ExprTreeNode getLchild() {
        return lchild;
    }

    void setLchild(ExprTreeNode lchild) {
        this.lchild = lchild;
    }

    public ExprTreeNode getRchild() {
        return rchild;
    }

    void setRchild(ExprTreeNode rchild) {
        this.rchild = rchild;
    }

    public Object getData() {
        return data;
    }

    void setData(Object data) {
        this.data = data;
    }
}
