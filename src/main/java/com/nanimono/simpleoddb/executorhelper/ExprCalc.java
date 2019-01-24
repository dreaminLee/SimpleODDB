package com.nanimono.simpleoddb.executorhelper;

import com.nanimono.simpleoddb.executorhelper.antlr4.ExprCalcBaseListener;
import com.nanimono.simpleoddb.executorhelper.antlr4.ExprCalcLexer;
import com.nanimono.simpleoddb.executorhelper.antlr4.ExprCalcParser;
import com.nanimono.simpleoddb.object.*;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.util.HashMap;
import java.util.Stack;

public class ExprCalc extends ExprCalcBaseListener {

    private HashMap<String, Field> var2Field;
    private Stack<Field> stack;

    public ExprCalc(HashMap<String, Field> var2Field) {
        this.var2Field = var2Field;
        this.stack = new Stack<>();
    }

    public Field getResult() {
        return stack.peek();
    }

    @Override
    public void exitBOOL(ExprCalcParser.BOOLContext ctx) {
        stack.push(new BooleanField(Boolean.parseBoolean(ctx.getText())));
    }

    @Override
    public void exitFLOAT(ExprCalcParser.FLOATContext ctx) {
        stack.push(new FloatField(Float.parseFloat(ctx.getText())));
    }

    @Override
    public void exitINT(ExprCalcParser.INTContext ctx) {
        stack.push(new IntField(Integer.parseInt(ctx.getText())));
    }

    @Override
    public void exitCHAR(ExprCalcParser.CHARContext ctx) {
        stack.push(new CharField(ctx.getText()));
    }

    @Override
    public void exitVar(ExprCalcParser.VarContext ctx) {
        stack.push(var2Field.get(ctx.getText()));
    }

    @Override
    public void exitMOD_(ExprCalcParser.MOD_Context ctx) {
        Field right = stack.pop();
        Field left = stack.pop();
        if (right.getType() != left.getType() || right.getType() != TypeEnum.INT_TYPE)
            throw new IllegalArgumentException("Incompatible operator and operand.");
        stack.push(new IntField(((IntField) left).getValue() % ((IntField) right).getValue()));
    }

    @Override
    public void exitADD_SUB(ExprCalcParser.ADD_SUBContext ctx) {
        Field right = stack.pop();
        Field left = stack.pop();
        Field result;
        if (left.getType() == TypeEnum.INT_TYPE) {
            if (right.getType() == TypeEnum.INT_TYPE) {
                if (ctx.op.getType() == ExprCalcParser.ADD) {
                    result = new IntField(((IntField) left).getValue() + ((IntField) right).getValue());
                } else {
                    result = new IntField(((IntField) left).getValue() - ((IntField) right).getValue());
                }
            } else if (right.getType() == TypeEnum.FLOAT_TYPE) {
                if (ctx.op.getType() == ExprCalcParser.ADD) {
                    result = new FloatField((float) ((IntField) left).getValue() + ((FloatField) right).getValue());
                } else {
                    result = new FloatField((float) ((IntField) left).getValue() - ((FloatField) right).getValue());
                }
            } else throw new IllegalArgumentException("Incompatible operator and operand.");
        } else if (left.getType() == TypeEnum.FLOAT_TYPE) {
            if (right.getType() == TypeEnum.INT_TYPE) {
                if (ctx.op.getType() == ExprCalcParser.ADD) {
                    result = new FloatField(((FloatField) left).getValue() + (float) ((IntField) right).getValue());
                } else {
                    result = new FloatField(((FloatField) left).getValue() - (float) ((IntField) right).getValue());
                }
            } else if (right.getType() == TypeEnum.FLOAT_TYPE) {
                if (ctx.op.getType() == ExprCalcParser.ADD) {
                    result = new FloatField(((FloatField) left).getValue() + ((FloatField) right).getValue());
                } else {
                    result = new FloatField(((FloatField) left).getValue() - ((FloatField) right).getValue());
                }
            } else throw new IllegalArgumentException("Incompatible operator and operand.");
        } else throw new IllegalArgumentException("Incompatible operator and operand.");

        stack.push(result);
    }

    @Override
    public void exitMUL_DIV(ExprCalcParser.MUL_DIVContext ctx) {
        Field right = stack.pop();
        Field left = stack.pop();
        Field result;
        if (left.getType() == TypeEnum.INT_TYPE) {
            if (right.getType() == TypeEnum.INT_TYPE) {
                if (ctx.op.getType() == ExprCalcParser.MUL) {
                    result = new IntField(((IntField) left).getValue() * ((IntField) right).getValue());
                } else {
                    result = new FloatField((float) ((IntField) left).getValue() / ((IntField) right).getValue());
                }
            } else if (right.getType() == TypeEnum.FLOAT_TYPE) {
                if (ctx.op.getType() == ExprCalcParser.MUL) {
                    result = new FloatField((float) ((IntField) left).getValue() * ((FloatField) right).getValue());
                } else {
                    result = new FloatField((float) ((IntField) left).getValue() / ((FloatField) right).getValue());
                }
            } else throw new IllegalArgumentException("Incompatible operator and operand.");
        } else if (left.getType() == TypeEnum.FLOAT_TYPE) {
            if (right.getType() == TypeEnum.INT_TYPE) {
                if (ctx.op.getType() == ExprCalcParser.MUL) {
                    result = new FloatField(((FloatField) left).getValue() * (float) ((IntField) right).getValue());
                } else {
                    result = new FloatField(((FloatField) left).getValue() / (float) ((IntField) right).getValue());
                }
            } else if (right.getType() == TypeEnum.FLOAT_TYPE) {
                if (ctx.op.getType() == ExprCalcParser.MUL) {
                    result = new FloatField(((FloatField) left).getValue() * ((FloatField) right).getValue());
                } else {
                    result = new FloatField(((FloatField) left).getValue() / ((FloatField) right).getValue());
                }
            } else throw new IllegalArgumentException("Incompatible operator and operand.");
        } else throw new IllegalArgumentException("Incompatible operator and operand.");

        stack.push(result);
    }

    @Override
    public void exitGREATER_LESS(ExprCalcParser.GREATER_LESSContext ctx) {
        Field right = stack.pop();
        Field left = stack.pop();
        Field result;
        if (right.getType() == TypeEnum.CHAR_TYPE && left.getType() == TypeEnum.CHAR_TYPE) {
            int compare = ((CharField) left).getValue().compareTo(((CharField) right).getValue());
            switch (ctx.op.getType()) {
                case ExprCalcParser.GREATER:
                    result = new BooleanField(compare > 0);
                    break;
                case ExprCalcParser.GREATER_OR_EQUAL:
                    result = new BooleanField(compare >= 0);
                    break;
                case ExprCalcParser.LESS:
                    result = new BooleanField(compare < 0);
                    break;
                case ExprCalcParser.LESS_OR_EQUAL:
                    result = new BooleanField(compare <= 0);
                    break;
                default:
                    throw new IllegalStateException("Impossible to reach here.");
            }
        }
        else if ((right.getType() == TypeEnum.INT_TYPE || right.getType() == TypeEnum.FLOAT_TYPE)
                && (left.getType() == TypeEnum.INT_TYPE || left.getType() == TypeEnum.FLOAT_TYPE)) {
            float vleft;
            float vright;
            if (left.getType() == TypeEnum.INT_TYPE) vleft = ((IntField)left).getValue();
            else vleft = ((FloatField)left).getValue();
            if (right.getType() == TypeEnum.INT_TYPE) vright = ((IntField)right).getValue();
            else vright = ((FloatField)right).getValue();
            switch (ctx.op.getType()) {
                case ExprCalcParser.GREATER:
                    result = new BooleanField(vleft > vright);
                    break;
                case ExprCalcParser.GREATER_OR_EQUAL:
                    result = new BooleanField(vleft >= vright);
                    break;
                case ExprCalcParser.LESS:
                    result = new BooleanField(vleft < vright);
                    break;
                case ExprCalcParser.LESS_OR_EQUAL:
                    result = new BooleanField(vleft <= vright);
                    break;
                default:
                    throw new IllegalStateException("Impossible to reach here.");
            }
        }
        else
            throw new IllegalArgumentException("Incompatible operator and operand.");

        stack.push(result);
    }

    @Override
    public void exitLOGIC(ExprCalcParser.LOGICContext ctx) {
        Field right = stack.pop();
        Field left = stack.pop();
        if (right.getType() != TypeEnum.BOOLEAN_TYPE || left.getType() != TypeEnum.BOOLEAN_TYPE)
            throw new IllegalArgumentException("Incompatible operator and operand.");
        BooleanField result;
        if (ctx.op.getType() == ExprCalcParser.AND)
            result = new BooleanField(((BooleanField) left).getValue() && ((BooleanField) right).getValue());
        else
            result = new BooleanField(((BooleanField) left).getValue() || ((BooleanField) right).getValue());

        stack.push(result);
    }

    @Override
    public void exitEQUAL_ORNOT(ExprCalcParser.EQUAL_ORNOTContext ctx) {
        Field right = stack.pop();
        Field left = stack.pop();
        Field result;
        if (right.getType() == TypeEnum.CHAR_TYPE && left.getType() == TypeEnum.CHAR_TYPE) {
            int compare = ((CharField) left).getValue().compareTo(((CharField) right).getValue());
            switch (ctx.op.getType()) {
                case ExprCalcParser.EQUAL:
                    result = new BooleanField(compare == 0);
                    break;
                case ExprCalcParser.NOT_EQUAL:
                    result = new BooleanField(compare != 0);
                    break;
                default:
                    throw new IllegalStateException("Impossible to reach here.");
            }
        }
        else if ((right.getType() == TypeEnum.INT_TYPE || right.getType() == TypeEnum.FLOAT_TYPE)
                && (left.getType() == TypeEnum.INT_TYPE || left.getType() == TypeEnum.FLOAT_TYPE)) {
            float vleft;
            float vright;
            if (left.getType() == TypeEnum.INT_TYPE) vleft = ((IntField)left).getValue();
            else vleft = ((FloatField)left).getValue();
            if (right.getType() == TypeEnum.INT_TYPE) vright = ((IntField)right).getValue();
            else vright = ((FloatField)right).getValue();
            switch (ctx.op.getType()) {
                case ExprCalcParser.EQUAL:
                    result = new BooleanField(vleft == vright);
                    break;
                case ExprCalcParser.NOT_EQUAL:
                    result = new BooleanField(vleft != vright);
                    break;
                default:
                    throw new IllegalStateException("Impossible to reach here.");
            }
        }
        else {
            boolean vleft = ((BooleanField)left).getValue();
            boolean vright = ((BooleanField)right).getValue();
            switch (ctx.op.getType()) {
                case ExprCalcParser.EQUAL:
                    result = new BooleanField(vleft == vright);
                    break;
                case ExprCalcParser.NOT_EQUAL:
                    result = new BooleanField(vleft != vright);
                    break;
                default:
                    throw new IllegalStateException("Impossible to reach here.");
            }
        }

        stack.push(result);
    }

    public Field calculate(String expression) {
        CharStream charStream = CharStreams.fromString(expression);
        ExprCalcLexer lexer = new ExprCalcLexer(charStream);
        CommonTokenStream token = new CommonTokenStream(lexer);
        ExprCalcParser parser = new ExprCalcParser(token);
        ParseTree tree = parser.expression();
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(this, tree);

        return stack.pop();
    }

    /*
    public static void main(String[] args) throws IOException {
        CharStream charStream = CharStreams.fromStream(System.in);
        ExprCalcLexer lexer = new ExprCalcLexer(charStream);
        CommonTokenStream token = new CommonTokenStream(lexer);
        ExprCalcParser parser = new ExprCalcParser(token);
        ParseTree tree = parser.expression();
        ParseTreeWalker walker = new ParseTreeWalker();
        ExprCalc calc = new ExprCalc(null);
        walker.walk(calc, tree);

        System.out.println(calc.getResult());
    }
    */
}
