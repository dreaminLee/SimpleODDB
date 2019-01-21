package com.nanimono.simpleoddb.executor;

import com.nanimono.simpleoddb.Catalog;
import com.nanimono.simpleoddb.object.Type;
import com.nanimono.simpleoddb.object.TypeEnum;
import com.nanimono.simpleoddb.executor.antlr4.OddlGrammarBaseListener;
import com.nanimono.simpleoddb.executor.antlr4.OddlGrammarParser;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class ExecutorListener extends OddlGrammarBaseListener {

    private Catalog catalog;

    /**
     * 分析expression所使用的成员变量
     */
    private ExprTreeNode current;
    private Stack<ExprTreeNode> treeNodeStack;
    private Stack<ExprTreeNode> rootNodeStack;

    public ExecutorListener(Catalog catalog) {
        this.catalog = catalog;
        current = null;
        treeNodeStack = null;
        rootNodeStack = null;
    }

    @Override
    public void enterExpression(OddlGrammarParser.ExpressionContext ctx) {
        if (ctx.LR_BRACKET() != null) return;
        current = new ExprTreeNode();
        if (ctx.value() != null) {
            OddlGrammarParser.ValueContext value = ctx.value();
            if (value.STRING_LITERAL() != null) {
                current.setType(ExprTreeNode.ExprTreeNodeType.CONST_CHAR);
                current.setData(value.getText());
            }
            else if (value.DECIMAL() != null || value.SIGNED_DECIMAL() != null) {
                current.setType(ExprTreeNode.ExprTreeNodeType.CONST_INT);
                current.setData(Integer.parseInt(value.getText()));
            }
            else if (value.REAL() != null || value.SIGNED_REAL() != null) {
                current.setType(ExprTreeNode.ExprTreeNodeType.CONST_FLOAT);
                current.setData(Float.parseFloat(value.getText()));
            }
            else if (value.TRUE() != null || value.FALSE() != null) {
                current.setType(ExprTreeNode.ExprTreeNodeType.CONST_BOOL);
                current.setData(Boolean.parseBoolean(value.getText()));
            }

        }
        else if (ctx.attrName() != null) {
            current.setType(ExprTreeNode.ExprTreeNodeType.VAR);
            current.setData(ctx.attrName().getText());
        }
        else {
            current.setType(ExprTreeNode.ExprTreeNodeType.OP);
            current.setData(ctx.children.get(1).getText());
        }
        treeNodeStack.push(current);
        System.out.println(ctx.getText());
    }

    @Override
    public void exitExpression(OddlGrammarParser.ExpressionContext ctx) {
        if (ctx.LR_BRACKET() != null) return;
        current = treeNodeStack.pop();
        if (!treeNodeStack.isEmpty()) {
            ExprTreeNode father = treeNodeStack.peek();
            if (father.getLchild() == null) father.setLchild(current);
            else if (father.getRchild() == null) father.setRchild(current);
            else throw new UnsupportedOperationException("Expression tree build failed.");
        }
        if (treeNodeStack.isEmpty()) rootNodeStack.push(current);
        System.out.println(ctx.getText());
    }

    @Override
    public void exitCreateSourceClass(OddlGrammarParser.CreateSourceClassContext ctx) {
        String className = ctx.className().ID().getText();
        List<OddlGrammarParser.CreateDefinitionContext> list = ctx.createDefinitions().createDefinition();
        String[] attrList = new String[list.size()];
        Type[] typeList = new Type[attrList.length];
        for (int index = 0; index < attrList.length; index++) {
            OddlGrammarParser.CreateDefinitionContext current = list.get(index);
            attrList[index] = current.ID().getText();
            switch (current.dataType().children.get(0).getText()) {
                case "CHAR":
                    typeList[index] = new Type(TypeEnum.CHAR_TYPE);
                    typeList[index].setSize(Integer.parseInt(current.dataType().children.get(2).getText()));
                    break;

                case "INT":
                    typeList[index] = new Type(TypeEnum.INT_TYPE);
                    break;

                case "LONG":
                    typeList[index] = new Type(TypeEnum.LONG_TYPE);
                    break;

                case "FLOAT":
                    typeList[index] = new Type(TypeEnum.FLOAT_TYPE);
                    break;

                case "BOOLEAN":
                    typeList[index] = new Type(TypeEnum.BOOLEAN_TYPE);
                    break;
            }
        }

        catalog.addSourceClass(className, attrList, typeList);
    }

    @Override
    public void enterCreateDeputyClass(OddlGrammarParser.CreateDeputyClassContext ctx) {
        current = null;
        treeNodeStack = new Stack<>();
        rootNodeStack = new Stack<>();
    }

    @Override
    public void exitCreateDeputyClass(OddlGrammarParser.CreateDeputyClassContext ctx) {

        String sClassName = ctx.sClassName().getText();
        String className = ctx.className().getText();
        String[] switchExprs = new String[ctx.AS().size()];
        String[] dAttr = new String[ctx.AS().size()];
        for (int index = 0; index < switchExprs.length; index++) {
            switchExprs[index] = ctx.expression(index).getText();
            dAttr[index] = ctx.dAttr(index).getText();
        }
        String deputyRule = ctx.WHERE() == null ? null : ctx.expression().get(ctx.expression().size() - 1).getText();
        ExprTreeNode[] exprTrees = new ExprTreeNode[rootNodeStack.size()];
        for (int i = exprTrees.length - 1; i >= 0; i--) {
            exprTrees[i] = rootNodeStack.pop();
        }

        catalog.addSelectDeputyClass(className, sClassName, switchExprs, dAttr, deputyRule, exprTrees);
    }

    @Override
    public void exitDropClass(OddlGrammarParser.DropClassContext ctx) {
        String className = ctx.className().getText();
        catalog.dropClass(className);
    }

    @Override
    public void exitInsertIntoClass(OddlGrammarParser.InsertIntoClassContext ctx) {
        String className = ctx.className().getText();
        String[] valueList = new String[ctx.valueList().value().size()];
        for (int index = 0; index < valueList.length; index++) {
            valueList[index] = ctx.valueList().value(index).children.toString();
            System.out.println(valueList[index]);
        }
        // value in String Format
    }

    @Override
    public void exitDeleteFromClass(OddlGrammarParser.DeleteFromClassContext ctx) {
        String className = ctx.className().getText();

        // TODO: expression
    }

    @Override
    public void exitSimpleQuery(OddlGrammarParser.SimpleQueryContext ctx) {
        String className = ctx.className().getText();
        String[] attrList = new String[ctx.attrList().attrName().size()];
        for (int index = 0; index < attrList.length; index++) {
            attrList[index] = ctx.attrList().attrName(index).getText();
        }

        // TODO: expression
    }

    @Override
    public void exitCrossClassQuery(OddlGrammarParser.CrossClassQueryContext ctx) {
        String className = ctx.className(0).getText();
        String from_className = ctx.className(ctx.className().size() - 1).getText();
        String attrName = ctx.attrName().getText();
        String[] cross_classList = new String[ctx.className().size() - 2];
        for (int index = 0; index < cross_classList.length; index++) {
            cross_classList[index] = ctx.className(index + 1).getText();
        }

        // TODO: expression
    }
}
