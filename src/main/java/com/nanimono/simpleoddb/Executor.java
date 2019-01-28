package com.nanimono.simpleoddb;

import com.nanimono.simpleoddb.executorhelper.TypeCalc;
import com.nanimono.simpleoddb.executorhelper.antlr4.OddlGrammarBaseListener;
import com.nanimono.simpleoddb.executorhelper.antlr4.OddlGrammarParser;
import com.nanimono.simpleoddb.object.Object;
import com.nanimono.simpleoddb.object.*;

import java.util.*;

public class Executor extends OddlGrammarBaseListener {

    private Queue<String> queryResults = new LinkedList<>();

    Queue<String> getQueryResults() {
        return queryResults;
    }

    @Override
    public void exitCreateSourceClass(OddlGrammarParser.CreateSourceClassContext ctx) {
        try {
            String className = ctx.className().ID().getText();
            if (DB.getCatalog().getClassId(className) >= 0) throw new IllegalArgumentException("Class already exists.");
            List<OddlGrammarParser.CreateDefinitionContext> list = ctx.createDefinitions().createDefinition();
            String[] attrList = new String[list.size()];
            TypeEnum[] typeList = new TypeEnum[attrList.length];
            int[] sizeList = new int[attrList.length];
            for (int index = 0; index < attrList.length; index++) {
                OddlGrammarParser.CreateDefinitionContext current = list.get(index);
                attrList[index] = current.ID().getText();
                switch (current.dataType().children.get(0).getText().toUpperCase()) {
                    case "CHAR":
                        typeList[index] = TypeEnum.CHAR_TYPE;
                        sizeList[index] = (Integer.parseInt(current.dataType().children.get(2).getText()));
                        break;

                    case "INT":
                        typeList[index] = TypeEnum.INT_TYPE;
                        break;

                    case "FLOAT":
                        typeList[index] = TypeEnum.FLOAT_TYPE;
                        break;

                    case "BOOLEAN":
                        typeList[index] = TypeEnum.BOOLEAN_TYPE;
                        break;

                    default:
                        throw new IllegalStateException("Impossible to reach here.");
                }
                for (int i = index - 1; i >= 0; i--) {
                    if (attrList[index].equals(attrList[i]) && typeList[index] == typeList[i]) {
                        throw new IllegalArgumentException("Duplicate attribute in one class.");
                    }
                }
            }

            DB.getCatalog().addSourceClass(className, attrList, typeList, sizeList);
            DB.getObjectStorage().addObjectList(DB.getCatalog().getClassId(className));

        } catch (IllegalArgumentException e) {
            queryResults.offer(e.getMessage());
        }
    }

    @Override
    public void exitCreateDeputyClass(OddlGrammarParser.CreateDeputyClassContext ctx) {
        try {
            String sClassName = ctx.sClassName().getText();
            int sClassId;
            if ((sClassId = DB.getCatalog().getClassId(sClassName)) < 0)
                throw new IllegalArgumentException("Source class doesn't exist.");
            String className = ctx.className().getText();
            if (DB.getCatalog().getClassId(className) >= 0)
                throw new IllegalArgumentException("Class already exists.");
            String[] switchExprs = new String[ctx.AS().size()];
            String[] dAttr = new String[switchExprs.length];
            TypeEnum[] typeList = new TypeEnum[switchExprs.length];
            int[] sizeList = new int[switchExprs.length];
            TypeCalc typeCalc = new TypeCalc(DB.getCatalog().getAttrName2Type(sClassId));
            for (int index = 0; index < switchExprs.length; index++) {
                switchExprs[index] = ctx.expression(index).getText();
                dAttr[index] = ctx.dAttr(index).getText();
                if ((typeList[index] = typeCalc.typing(switchExprs[index])) == null) {
                    throw new IllegalArgumentException(typeCalc.getErrorMessage());
                }
                if (typeList[index] == TypeEnum.CHAR_TYPE)
                    sizeList[index] = DB.getCatalog().getClassAttrSize(sClassId, switchExprs[index]);
            }
            String deputyRule = ctx.expression().get(ctx.expression().size() - 1).getText();
            if (typeCalc.typing(deputyRule) != TypeEnum.BOOLEAN_TYPE)
                throw new IllegalArgumentException(typeCalc.getErrorMessage());

            DB.getCatalog().addSelectDeputyClass(className, sClassId, switchExprs, dAttr, typeList, sizeList, deputyRule);
            DB.getObjectStorage().addObjectList(DB.getCatalog().getClassId(className));
            DB.getObjectStorage().classPropagation(DB.getCatalog().getClassId(className));

        } catch (IllegalArgumentException e) {
            queryResults.offer(e.getMessage());
        }
    }

    @Override
    public void exitDropClass(OddlGrammarParser.DropClassContext ctx) {
        try {
            String className = ctx.className().getText();
            int classId = DB.getCatalog().getClassId(className);
            if (classId < 0) throw new IllegalArgumentException("Class doesn't exist.");

            DB.getObjectStorage().clearObject(classId);
            DB.getObjectStorage().removeObjectList(classId);
            DB.getObjectStorage().removeObjectList(classId);
            DB.getCatalog().dropClass(classId);

        } catch (IllegalArgumentException e) {
            queryResults.offer(e.getMessage());
        }
    }

    @Override
    public void exitInsertIntoClass(OddlGrammarParser.InsertIntoClassContext ctx) {
        try {
            String className = ctx.className().getText();
            int classId = DB.getCatalog().getClassId(className);
            if (classId < 0)
                throw new IllegalArgumentException("Class doesn't exist.");
            if (DB.getCatalog().getClassType(classId) != Catalog.ClassType.SOURCECLASS)
                throw new IllegalArgumentException("Insert into class other than source class is not supported.");
            Object object = DB.getCatalog().newObject(classId);
            if (DB.getCatalog().getClassAttrNumber(classId) != ctx.valueList().value().size())
                throw new IllegalArgumentException("Value list's size and class's attribute list's size must be the same.");

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

                if (field.getType() != DB.getCatalog().getClassAttrDataType(classId, i))
                    throw new IllegalArgumentException("Value" + field.toString() + "is not the right type.");
                if (field.getType() == TypeEnum.CHAR_TYPE && ((CharField) field).getValue().length() > DB.getCatalog().getClassAttrSize(classId, i)) {
                    String old = ((CharField) field).getValue();
                    field = new CharField(old.substring(0, DB.getCatalog().getClassAttrSize(classId, i) - 1) + "'");
                    queryResults.offer(old + " is too long for attribute " +
                            DB.getCatalog().getClassAttrName(classId, i) +
                            ", cutting it into " + ((CharField) field).getValue());
                }
                object.setField(i, field);
            }

            DB.getObjectStorage().insertObject(object);

        } catch (IllegalArgumentException e) {
            queryResults.offer(e.getMessage());
        }
    }

    @Override
    public void exitDeleteFromClass(OddlGrammarParser.DeleteFromClassContext ctx) {
        String className = ctx.className().getText();
        try {
            int classId = DB.getCatalog().getClassId(className);
            if (classId < 0)
                throw new IllegalArgumentException("Class doesn't exist.");
            if (DB.getCatalog().getClassType(classId) != Catalog.ClassType.SOURCECLASS)
                throw new IllegalArgumentException("Delete from class other than source class is not supported.");

            String filter = ctx.expression().getText();
            TypeCalc typeCalc = new TypeCalc(DB.getCatalog().getAttrName2Type(classId));
            if (typeCalc.typing(filter) != TypeEnum.BOOLEAN_TYPE)
                throw new IllegalArgumentException("Illegal where clause.");

            DB.getObjectStorage().deleteObject(classId, filter);

        } catch (IllegalArgumentException e) {
            queryResults.offer(e.getMessage());
        }
    }

    @Override
    public void exitSimpleQuery(OddlGrammarParser.SimpleQueryContext ctx) {
        String className = ctx.className().getText();
        try {
            int classId = DB.getCatalog().getClassId(className);
            if (classId < 0)
                throw new IllegalArgumentException("Class doesn't exist.");

            String filter = ctx.expression().getText();
            TypeCalc typeCalc = new TypeCalc(DB.getCatalog().getAttrName2Type(classId));
            if (typeCalc.typing(filter) != TypeEnum.BOOLEAN_TYPE)
                throw new IllegalArgumentException("Illegal where clause.");

            int attrNumber = DB.getCatalog().getClassAttrNumber(classId);
            boolean[] isquery = new boolean[attrNumber];
            if (ctx.attrList().getText().equals("*")) {
                Arrays.fill(isquery, true);
            } else {
                for (int i = 0; i < ctx.attrList().attrName().size(); i++) {
                    int attrIndex = 0;
                    for (; attrIndex < attrNumber; attrIndex++) {
                        if (ctx.attrList().attrName(i).getText().equals(DB.getCatalog().getClassAttrName(classId, attrIndex))) {
                            break;
                        }
                    }
                    if (attrIndex >= attrNumber) {
                        throw new IllegalArgumentException("Attribute doesn't exist.");
                    }
                    isquery[attrIndex] = true;
                }
            }

            queryResults.offer(DB.getObjectStorage().simpleQuery(classId, isquery, filter));

        } catch (IllegalArgumentException e) {
            queryResults.offer(e.getMessage());
        }
    }

    @Override
    public void exitCrossClassQuery(OddlGrammarParser.CrossClassQueryContext ctx) {
        try {
            if (!ctx.className(0).getText().equals(ctx.className(2).getText()))
                throw new IllegalArgumentException("Illegal path start class.");

            int fromClassId = DB.getCatalog().getClassId(ctx.className(2).getText());
            String filter = ctx.expression().getText();
            TypeCalc typeCalc = new TypeCalc(DB.getCatalog().getAttrName2Type(fromClassId));
            if (typeCalc.typing(filter) != TypeEnum.BOOLEAN_TYPE)
                throw new IllegalArgumentException("Illegal where clause.");

            int destClassId = DB.getCatalog().getClassId(ctx.className(1).getText());
            if (!(DB.getCatalog().getSourceClassId(fromClassId) == destClassId ||
                    DB.getCatalog().getSourceClassId(destClassId) == fromClassId ||
                    (DB.getCatalog().getSourceClassId(fromClassId) == DB.getCatalog().getSourceClassId(destClassId))))
                throw new IllegalArgumentException("Illegal path expression.");
            int attrNumber = DB.getCatalog().getClassAttrNumber(destClassId);
            boolean[] isquery = new boolean[attrNumber];
            if (ctx.attrList().getText().equals("*")) {
                Arrays.fill(isquery, true);
            } else {
                for (int i = 0; i < ctx.attrList().attrName().size(); i++) {
                    int attrIndex = 0;
                    for (; attrIndex < attrNumber; attrIndex++) {
                        if (ctx.attrList().attrName(i).getText().equals(DB.getCatalog().getClassAttrName(destClassId, attrIndex)))
                            break;
                    }
                    if (attrIndex >= attrNumber)
                        throw new IllegalArgumentException("Attribute doesn't exist.");
                    isquery[attrIndex] = true;
                }
            }

            queryResults.offer(DB.getObjectStorage().crossClassQuery(fromClassId, destClassId, isquery, filter));

        } catch (IllegalArgumentException e) {
            queryResults.offer(e.getMessage());
        }
    }

    @Override
    public void exitUpdateObject(OddlGrammarParser.UpdateObjectContext ctx) {
        try {
            String className = ctx.className().getText();
            int classId = DB.getCatalog().getClassId(className);
            if (DB.getCatalog().getClassType(classId) != Catalog.ClassType.SOURCECLASS)
                throw new IllegalArgumentException("Update class other than source class is not supported.");

            int attrNumber = DB.getCatalog().getClassAttrNumber(classId);
            Field[] values = new Field[attrNumber];
            for (int i = 0; i < ctx.attrName().size(); i++) {
                String attrName = ctx.attrName(i).getText();
                int attrIndex = 0;
                for (; attrIndex < attrNumber; attrIndex++) {
                    if (attrName.equals(DB.getCatalog().getClassAttrName(classId, attrIndex))) break;
                }
                if (attrIndex >= attrNumber)
                    throw new IllegalArgumentException("Attribute doesn't exist.");
                OddlGrammarParser.ValueContext value = ctx.value(i);
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
                if (field.getType() != DB.getCatalog().getClassAttrDataType(classId, attrIndex))
                    throw new IllegalArgumentException("Value " + field.toString() + " is not the right type");
                if (field.getType() == TypeEnum.CHAR_TYPE && ((CharField) field).getValue().length() > DB.getCatalog().getClassAttrSize(classId, attrIndex)) {
                    String old = ((CharField) field).getValue();
                    field = new CharField(old.substring(0, DB.getCatalog().getClassAttrSize(classId, attrIndex) - 1) + "'");
                    queryResults.offer(old + " is too long for attribute " +
                            DB.getCatalog().getClassAttrName(classId, attrIndex) +
                            ", cutting it into " + ((CharField) field).getValue());
                }
                values[attrIndex] = field;
            }
            String updateRule = ctx.expression().getText();

            DB.getObjectStorage().updateObject(classId, updateRule, values);

        } catch (IllegalArgumentException e) {
            queryResults.offer(e.getMessage());
        }
    }
}
