package com.nanimono.simpleoddb.executorhelper;

import com.nanimono.simpleoddb.object.TypeEnum;

import java.io.Serializable;
import java.util.HashMap;

public class ExprTreeNode implements Serializable {

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

    public ExprTreeNode() {
        this.lchild = null;
        this.rchild = null;
    }

    public ExprTreeNodeType getType() {
        return type;
    }

    public void setType(ExprTreeNodeType type) {
        this.type = type;
    }

    public ExprTreeNode getLchild() {
        return lchild;
    }

    public void setLchild(ExprTreeNode lchild) {
        this.lchild = lchild;
    }

    public ExprTreeNode getRchild() {
        return rchild;
    }

    public void setRchild(ExprTreeNode rchild) {
        this.rchild = rchild;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    /**
     * 判断一棵表达式树是否能够定型，如果能定型就是一棵合法的表达式树，否则不合法
     *
     * @param node     树节点
     * @param context  哈希表，属性名到类型的映射
     * @return
     */
    public static TypeEnum getTreeType(ExprTreeNode node, HashMap<String, TypeEnum> context) {
        // 基本类型
        if (node == null || context == null) return null;
        if (node.getType().convertToType() != null) return node.getType().convertToType();
        else {
            // 变量
            if (node.getLchild() == null) return context.get(node.getData());
            else {
                TypeEnum lchildType = getTreeType(node.getLchild(), context);
                TypeEnum rchildType = getTreeType(node.getRchild(), context);
                String op = (String) node.getData();
                switch (op) {
                    case "AND":
                    case "OR":
                        if (lchildType == TypeEnum.BOOLEAN_TYPE && rchildType == TypeEnum.BOOLEAN_TYPE)
                            return TypeEnum.BOOLEAN_TYPE;
                        else
                            return null;

                    case "=":
                    case "==":
                    case "!=":
                    case "<>":
                        if (lchildType == TypeEnum.BOOLEAN_TYPE || rchildType == TypeEnum.BOOLEAN_TYPE)
                            return TypeEnum.BOOLEAN_TYPE;
                    case "<":
                    case "<=":
                    case ">":
                    case ">=":
                        if ((lchildType == TypeEnum.INT_TYPE || lchildType == TypeEnum.FLOAT_TYPE) &&
                                (rchildType == TypeEnum.INT_TYPE || rchildType == TypeEnum.FLOAT_TYPE) ||
                                (lchildType == TypeEnum.CHAR_TYPE && rchildType == TypeEnum.CHAR_TYPE))
                            return TypeEnum.BOOLEAN_TYPE;
                        else return null;

                    case "/":
                        if ((lchildType == TypeEnum.INT_TYPE || lchildType == TypeEnum.FLOAT_TYPE) &&
                                (rchildType == TypeEnum.INT_TYPE || rchildType == TypeEnum.FLOAT_TYPE))
                            return TypeEnum.FLOAT_TYPE;
                    case "+":
                    case "-":
                    case "*":
                        if ((lchildType == TypeEnum.INT_TYPE || lchildType == TypeEnum.FLOAT_TYPE) &&
                                (rchildType == TypeEnum.INT_TYPE || rchildType == TypeEnum.FLOAT_TYPE)) {
                            if (lchildType == rchildType) return lchildType;
                            else return TypeEnum.FLOAT_TYPE;
                        } else return null;

                    case "%":
                        if (lchildType == TypeEnum.INT_TYPE && rchildType == TypeEnum.INT_TYPE)
                            return TypeEnum.INT_TYPE;
                        else return null;

                    default:
                        return null;
                }
            }
        }
    }
}
