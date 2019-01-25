package com.nanimono.simpleoddb;

import com.nanimono.simpleoddb.executorhelper.ExprCalc;
import com.nanimono.simpleoddb.object.BooleanField;
import com.nanimono.simpleoddb.object.Field;
import com.nanimono.simpleoddb.object.Object;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

class ObjectStorage implements Serializable {

    /**
     * oid ---> 对象
     */
    private HashMap<Long, Object> oid2Object = new HashMap<>();

    /**
     * 类id ---> oid list
     */
    private HashMap<Integer, ArrayList<Long>> classId2oidList = new HashMap<>();

    private long nextOid = 0;

    long nextOid() {
        return nextOid++;
    }

    /**
     * 代理oid ---> 源oid
     */
    private HashMap<Long, Long> deputyoid2sourceoid = new HashMap<>();

    /**
     * 源oid ---> 代理oid表
     */
    private HashMap<Long, ArrayList<Long>> sourceoid2deputyoid = new HashMap<>();

    void addObjectList(int classId) {
        classId2oidList.put(classId, new ArrayList<Long>());
    }

    void removeObjectList(int classId) {
        if (DB.getCatalog().getClassHasSubclass(classId)) {
            for (Catalog.DeputyTableTuple tuple : DB.getCatalog().getBeDeputyRule(classId))
                removeObjectList(tuple.getDeputyClassId());
        }
        classId2oidList.remove(classId);
    }

    ArrayList<Long> getObjectList(int classId) {
        return classId2oidList.get(classId);
    }

    Object getObject(long oid) {
        return oid2Object.get(oid);
    }

    void insertBiPointer(long sourceoid, long deputyoid) {
        deputyoid2sourceoid.put(deputyoid, sourceoid);
        sourceoid2deputyoid.get(sourceoid).add(deputyoid);
    }

    void insertObject(Object object) {

        // 插入源对象并根据代理规则判断是否创建新代理对象并插入
        long nextOid = nextOid();
        object.setOid(nextOid);
        int classId = object.getBelongClassId();
        classId2oidList.get(classId).add(nextOid);
        sourceoid2deputyoid.put(nextOid, new ArrayList<Long>());
        oid2Object.put(nextOid, object);

        if (DB.getCatalog().getClassHasSubclass(classId)) {
            HashMap<String, Field> var2field = new HashMap<>();
            Catalog.AttrTableTuple[] attrList = DB.getCatalog().getClassAttrList(classId);
            for (int i = 0; i < attrList.length; i++) {
                var2field.put(attrList[i].getAttrName(), object.getField(i));
            }
            Iterator<Catalog.DeputyTableTuple> iterator = DB.getCatalog().getBeDeputyRule(classId).iterator();
            while (iterator.hasNext()) {
                Catalog.DeputyTableTuple deputyTuple = iterator.next();
                ExprCalc calc = new ExprCalc(var2field);
                Field result = calc.calculate(deputyTuple.getDeputyRule());
                if (((BooleanField) result).getValue()) {
                    Object deputyObject = DB.getCatalog().newObject(deputyTuple.getDeputyClassId());
                    Catalog.SwitchExprTableTuple[] switchExprList = DB.getCatalog().getSwitchRuleList(deputyTuple.getDeputyClassId());
                    for (int i = 0; i < switchExprList.length; i++) {
                        Field field = calc.calculate(switchExprList[i].getSwitchRule());
                        deputyObject.setField(i, field);
                    }
                    insertObject(deputyObject);
                    deputyoid2sourceoid.put(deputyObject.getOid(), object.getOid());
                    sourceoid2deputyoid.get(object.getOid()).add(deputyObject.getOid());
                }
            }
        }
    }

    void deleteObject(int classId, String deputyRule) {
        ArrayList<Long> objectToDelete = filter(classId, deputyRule);
        if (objectToDelete.size() == 0) return;
        for (Long oid : objectToDelete) {
            deleteObject(oid);
        }
    }

    private void deleteObject(long oid) {
        int classId = oid2Object.get(oid).getBelongClassId();
        if (DB.getCatalog().getClassHasSubclass(classId)) {
            for (long deputyoid : sourceoid2deputyoid.get(oid)) {
                deleteObject(deputyoid);
                deputyoid2sourceoid.remove(deputyoid);
            }
        }
        sourceoid2deputyoid.remove(oid);
        classId2oidList.get(oid2Object.get(oid).getBelongClassId()).remove(oid);
        oid2Object.remove(oid);
    }

    private ArrayList<Long> filter(int classId, String filterRule) {
        Iterator<Long> it = classId2oidList.get(classId).iterator();
        HashMap<String, Field> var2field = new HashMap<>();
        Catalog.AttrTableTuple[] attrList = DB.getCatalog().getClassAttrList(classId);
        ArrayList<Long> objectFiltered = new ArrayList<>();
        while (it.hasNext()) {
            Object current = oid2Object.get(it.next());
            for (int i = 0; i < attrList.length; i++) {
                var2field.put(attrList[i].getAttrName(),
                        current.getField(i));
            }
            ExprCalc calc = new ExprCalc(var2field);
            if (((BooleanField)calc.calculate(filterRule)).getValue()) {
                objectFiltered.add(current.getOid());
            }
        }
        return objectFiltered;
    }

    void updateObject(int classId, String updateRule, Field[] fields) {
        ArrayList<Long> oidToUpdate = filter(classId, updateRule);
        if (oidToUpdate.size() == 0) return;
        for (long oid : oidToUpdate) {
            Object current = oid2Object.get(oid);
            deleteObject(oid);
            for (int i = 0; i < fields.length; i++) {
                if (fields[i] != null)
                    current.setField(i, fields[i]);
            }
            insertObject(current);
        }
    }

    void clearObject(int classId) {
        while (!classId2oidList.get(classId).isEmpty()) {
            deleteObject(classId2oidList.get(classId).get(0));
        }
    }

    String simpleQuery(int classId, boolean[] isQueryList, String filter) {
        ArrayList<Long> oidQuery;
        if (filter != null)
            oidQuery = filter(classId, filter);
        else
            oidQuery = classId2oidList.get(classId);
        StringBuilder builder = new StringBuilder();
        builder.append("|  ");
        for (int i = 0; i < isQueryList.length; i++) {
            Catalog.AttrTableTuple tuple = DB.getCatalog().getClassAttrList(classId)[i];
            if (isQueryList[i]) {
                builder.append(tuple.getAttrName());
                builder.append("  |  ");
            }
        }
        builder.append("\r\n");
        if (oidQuery.size() == 0) return new String(builder);
        for (long oid : oidQuery) {
            builder.append("|  ");
            Object current = oid2Object.get(oid);
            for (int i = 0; i < isQueryList.length; i++) {
                if (isQueryList[i]) {
                    builder.append(current.getField(i).toString());
                    builder.append("  |  ");
                }
            }
            builder.append("\r\n");
        }
        return new String(builder);
    }

    String crossClassQuery(int fromClassId, int destClassId, boolean[] isQueryList, String filter) {
        ArrayList<Long> oidQuery = filter(fromClassId, filter);
        if (oidQuery.size() == 0) return null;
        if (DB.getCatalog().getClassType(fromClassId) == Catalog.ClassType.SELECTDEPUTY) {
            ArrayList<Long> newoidQuery = new ArrayList<>();
            for (long oid : oidQuery) {
                newoidQuery.add(deputyoid2sourceoid.get(oid));
            }
            oidQuery = newoidQuery;
        }

        if (oid2Object.get(oidQuery.get(0)).getBelongClassId() != destClassId) {
            ArrayList<Long> newoidQuery = new ArrayList<>();
            for (long oid : oidQuery) {
                for (long deputyoid : sourceoid2deputyoid.get(oid)) {
                    if (oid2Object.get(deputyoid).getBelongClassId() == destClassId)
                        newoidQuery.add(deputyoid);
                }
            }
            oidQuery = newoidQuery;
        }

        StringBuilder builder = new StringBuilder();
        builder.append("|  ");
        for (int i = 0; i < isQueryList.length; i++) {
            Catalog.AttrTableTuple tuple = DB.getCatalog().getClassAttrList(destClassId)[i];
            if (isQueryList[i]) {
                builder.append(tuple.getAttrName());
                builder.append("  |  ");
            }
        }
        builder.append("\r\n");
        if (oidQuery.size() == 0) return new String(builder);
        for (long oid : oidQuery) {
            builder.append("|  ");
            Object current = oid2Object.get(oid);
            for (int i = 0; i < isQueryList.length; i++) {
                if (isQueryList[i]) {
                    builder.append(current.getField(i).toString());
                    builder.append("  |  ");
                }
            }
            builder.append("\r\n");
        }
        return new String(builder);
    }
}
