package com.nanimono.simpleoddb.executor;

import com.nanimono.simpleoddb.Catalog;
import com.nanimono.simpleoddb.DB;
import com.nanimono.simpleoddb.executor.antlr4.OddlGrammarBaseListener;
import com.nanimono.simpleoddb.executor.antlr4.OddlGrammarParser;
import com.nanimono.simpleoddb.object.*;
import com.nanimono.simpleoddb.object.Object;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class ExecutorListener extends OddlGrammarBaseListener {

    /**
     * 分析expression所使用的成员变量
     */
    private ExprTreeNode current;
    private Stack<ExprTreeNode> treeNodeStack;
    private Stack<ExprTreeNode> rootNodeStack;

    public ExecutorListener() {
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

        DB.addSourceClass(className, attrList, typeList);
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

        DB.addSelectDeputyClass(className, sClassName, switchExprs, dAttr, deputyRule, exprTrees);
    }

    @Override
    public void exitDropClass(OddlGrammarParser.DropClassContext ctx) {
        String className = ctx.className().getText();
        DB.dropClass(className);
    }

    @Override
    public void exitInsertIntoClass(OddlGrammarParser.InsertIntoClassContext ctx) {
        String className = ctx.className().getText();
        int classId = DB.getCatalog().getClassId(className);
        if (DB.getCatalog().getClassType(classId) != Catalog.ClassType.SOURCECLASS)
            throw new IllegalArgumentException("Insert into class other than source class is not supported.");
        Object object = new Object(classId);
        if (DB.getCatalog().getClassAttrList(object.getBelongClassId()).length != ctx.valueList().value().size())
            throw new IllegalArgumentException("Value list's size and class's attribute list's size must be the same.");
        Iterator<Catalog.AttrTableTuple> attrIte = DB.getCatalog().getClassAttrIterator(className);
        for (int i = 0; i < ctx.valueList().value().size(); i++) {
            OddlGrammarParser.ValueContext value = ctx.valueList().value(i);
            Field field;
            if (value.TRUE() != null || value.FALSE() != null) {
                field = new BooleanField(Boolean.parseBoolean(value.getText()));
            } else if (value.SIGNED_REAL() != null || value.REAL() != null) {
                field = new FloatField(Float.parseFloat(value.getText()));
            } else if (value.DECIMAL() != null || value.SIGNED_DECIMAL() != null) {
                field = new IntField(Integer.parseInt(value.getText()));
            } else {
                field = new CharField(value.getText());
            }
            if (field.getType() != attrIte.next().getType()) throw new IllegalArgumentException("Value is not the right type.");
            object.setField(i, field);
        }
        DB.insertObject(classId, object);
    }

    @Override
    public void exitDeleteFromClass(OddlGrammarParser.DeleteFromClassContext ctx) {
        String className = ctx.className().getText();
        int classId = DB.getCatalog().getClassId(className);
        if (DB.getCatalog().getClassType(classId) != Catalog.ClassType.SOURCECLASS)
            throw new IllegalArgumentException("Delete from class other than source class is not supported.");
        if (ctx.WHERE() == null)
            throw new IllegalArgumentException("Lack of where clause.");
        String deputyRule = ctx.expression().getText();

        DB.deleteObject(classId, deputyRule);
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

    @Override
    public void exitUpdateObject(OddlGrammarParser.UpdateObjectContext ctx) {
        String className = ctx.className().getText();
    }
}
