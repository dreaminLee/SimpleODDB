package com.nanimono.simpleoddb.executorhelper;

import com.nanimono.simpleoddb.executorhelper.antlr4.ExprCalcBaseListener;
import com.nanimono.simpleoddb.executorhelper.antlr4.ExprCalcLexer;
import com.nanimono.simpleoddb.executorhelper.antlr4.ExprCalcParser;
import com.nanimono.simpleoddb.object.TypeEnum;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Stack;

public class TypeCalc extends ExprCalcBaseListener {

    private HashMap<String, TypeEnum> var2Type;
    private Stack<TypeEnum> stack;
    private boolean parseState;
    private String errorMessage;

    public TypeCalc(HashMap<String, TypeEnum> var2Type) {
        this.var2Type = var2Type;
        this.stack = new Stack<>();
        this.parseState = true;
        this.errorMessage = null;
    }
    
    public String getErrorMessage() {
        return errorMessage;
    }

    public void setVar2Type(HashMap<String, TypeEnum> var2Type) {
        this.var2Type = var2Type;
    }

    @Override
    public void exitBOOL(ExprCalcParser.BOOLContext ctx) {
        stack.push(TypeEnum.BOOLEAN_TYPE);
    }

    @Override
    public void exitFLOAT(ExprCalcParser.FLOATContext ctx) {
        stack.push(TypeEnum.FLOAT_TYPE);
    }

    @Override
    public void exitINT(ExprCalcParser.INTContext ctx) {
        stack.push(TypeEnum.INT_TYPE);
    }

    @Override
    public void exitCHAR(ExprCalcParser.CHARContext ctx) {
        stack.push(TypeEnum.CHAR_TYPE);
    }

    @Override
    public void exitVar(ExprCalcParser.VarContext ctx) {
        if (var2Type.get(ctx.getText()) == null) {
            errorMessage = "Var " + ctx.getText() + " not found, parse failed.";
            parseState = false;
            return;
        }
        stack.push(var2Type.get(ctx.getText()));
    }

    /**
     *  int mod int = int
     */
    @Override
    public void exitMOD_(ExprCalcParser.MOD_Context ctx) {
        try {
            if (parseState) {
                TypeEnum right = stack.pop();
                TypeEnum left = stack.pop();
                if (right != left || right != TypeEnum.INT_TYPE) {
                    throw new IllegalArgumentException("Type " + left.toString() + " and type" + right.toString() + " can't be applied to mod, parse failed.");
                }
                stack.push(TypeEnum.INT_TYPE);
            }
        } catch (EmptyStackException e) {
            parseState = false;
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            parseState = false;
            errorMessage = e.getMessage();
        }
    }

    /**
     *  (float/int) add/sub (float/int) = int/float
     */
    @Override
    public void exitADD_SUB(ExprCalcParser.ADD_SUBContext ctx) {
        try {
            if (parseState) {
                TypeEnum right = stack.pop();
                TypeEnum left = stack.pop();
                if (left == right) {
                    if (left == TypeEnum.INT_TYPE) stack.push(TypeEnum.INT_TYPE);
                    else if (left == TypeEnum.FLOAT_TYPE) stack.push(TypeEnum.FLOAT_TYPE);
                    else throw new IllegalArgumentException("Type " + left.toString() + " and type" + right.toString() + " can't be applied to add or sub, parse failed.");
                }
                else {
                    if (!(left == TypeEnum.BOOLEAN_TYPE || left == TypeEnum.CHAR_TYPE || right == TypeEnum.BOOLEAN_TYPE || right == TypeEnum.CHAR_TYPE))
                        stack.push(TypeEnum.FLOAT_TYPE);
                    else throw new IllegalArgumentException("Type " + left.toString() + " and type" + right.toString() + " can't be applied to add or sub, parse failed.");
                }
            }
        } catch (EmptyStackException e) {
            parseState = false;
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            parseState = false;
            errorMessage = e.getMessage();
        }
    }

    /**
     *  (float/int) mul/div (float/int) = int/float
     */
    @Override
    public void exitMUL_DIV(ExprCalcParser.MUL_DIVContext ctx) {
        try {
            if (parseState) {
                TypeEnum right = stack.pop();
                TypeEnum left = stack.pop();
                if (left == right) {
                    if (left == TypeEnum.INT_TYPE) stack.push(TypeEnum.INT_TYPE);
                    else if (left == TypeEnum.FLOAT_TYPE) stack.push(TypeEnum.FLOAT_TYPE);
                    else throw new IllegalArgumentException("Type " + left.toString() + " and type" + right.toString() + " can't be applied to mul or div, parse failed.");
                }
                else {
                    if (!(left == TypeEnum.BOOLEAN_TYPE || left == TypeEnum.CHAR_TYPE || right == TypeEnum.BOOLEAN_TYPE || right == TypeEnum.CHAR_TYPE))
                        stack.push(TypeEnum.FLOAT_TYPE);
                    else throw new IllegalArgumentException("Type " + left.toString() + " and type" + right.toString() + " can't be applied to mul or div, parse failed.");
                }
            }
        } catch (EmptyStackException e) {
            parseState = false;
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            parseState = false;
            errorMessage = e.getMessage();
        }
    }

    /**
     *  op: < > <= >=
     *  (float/int) op (float/int) = boolean
     *  char op char (lexicographical comparison) = boolean
     */
    @Override
    public void exitGREATER_LESS(ExprCalcParser.GREATER_LESSContext ctx) {
        try {
            if (parseState) {
                TypeEnum right = stack.pop();
                TypeEnum left = stack.pop();
                if (left == right) {
                    if (left != TypeEnum.BOOLEAN_TYPE) stack.push(TypeEnum.BOOLEAN_TYPE);
                    else throw new IllegalArgumentException("Type " + left.toString() + " and type" + right.toString() + " can't be applied to comparison, parse failed.");
                }
                else {
                    if (!(left == TypeEnum.BOOLEAN_TYPE || left == TypeEnum.CHAR_TYPE || right == TypeEnum.BOOLEAN_TYPE || right == TypeEnum.CHAR_TYPE))
                        stack.push(TypeEnum.BOOLEAN_TYPE);
                    else throw new IllegalArgumentException("Type " + left.toString() + " and type" + right.toString() + " can't be applied to comparison, parse failed.");
                }
            }
        } catch (EmptyStackException e) {
            parseState = false;
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            parseState = false;
            errorMessage = e.getMessage();
        }
    }

    /**
     *  boolean and/or boolean = boolean
     */
    @Override
    public void exitLOGIC(ExprCalcParser.LOGICContext ctx) {
        try {
            if (parseState) {
                TypeEnum right = stack.pop();
                TypeEnum left = stack.pop();
                if (left != right || left != TypeEnum.BOOLEAN_TYPE) {
                    throw new IllegalArgumentException("Type " + left.toString() + " and type" + right.toString() + " can't be applied to logic op, parse failed.");
                }
                stack.push(TypeEnum.BOOLEAN_TYPE);
            }
        } catch (EmptyStackException e) {
            parseState = false;
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            parseState = false;
            errorMessage = e.getMessage();
        }
    }

    /**
     *  op: != ==
     *  (float/int) op (float/int) = boolean
     *  char op char = boolean
     *  boolean op boolean = boolean
     */
    @Override
    public void exitEQUAL_ORNOT(ExprCalcParser.EQUAL_ORNOTContext ctx) {
        try {
            if (parseState) {
                TypeEnum right = stack.pop();
                TypeEnum left = stack.pop();
                if (left == right) stack.push(TypeEnum.BOOLEAN_TYPE);
                else {
                    if (!(left == TypeEnum.BOOLEAN_TYPE || left == TypeEnum.CHAR_TYPE || right == TypeEnum.BOOLEAN_TYPE || right == TypeEnum.CHAR_TYPE))
                        stack.push(TypeEnum.BOOLEAN_TYPE);
                    else throw new IllegalArgumentException("Type " + left.toString() + " and type" + right.toString() + " can't be applied to comparison, parse failed.");
                }
            }
        } catch (EmptyStackException e) {
            parseState = false;
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            parseState = false;
            errorMessage = e.getMessage();
        }
    }
    
    public TypeEnum typing(String expression) {
        CharStream charStream = CharStreams.fromString(expression);
        ExprCalcLexer lexer = new ExprCalcLexer(charStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ExprCalcParser parser = new ExprCalcParser(tokens);
        parser.removeErrorListeners();
        parser.addErrorListener(new ThrowingErrorListener());
        try {
            ParseTree tree = parser.expression();
            ParseTreeWalker walker = new ParseTreeWalker();
            walker.walk(this, tree);
            if (parseState) return stack.pop();
            else return null;
        } catch (ParseCancellationException e) {
            errorMessage = e.getMessage();
            return null;
        } catch (EmptyStackException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void reset() {
        this.parseState = true;
        this.stack = new Stack<>();
        this.errorMessage = null;
        this.var2Type = null;
    }
}
