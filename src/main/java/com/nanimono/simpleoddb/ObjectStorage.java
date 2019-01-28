package com.nanimono.simpleoddb;

import com.nanimono.simpleoddb.executorhelper.ExprCalc;
import com.nanimono.simpleoddb.object.BooleanField;
import com.nanimono.simpleoddb.object.Field;
import com.nanimono.simpleoddb.object.Object;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Stack;

class ObjectStorage implements Serializable {

    /**
     * oid ---> 对象
     */
    private HashMap<Long, Object> oid2Object = new HashMap<>();

    /**
     * 类id ---> oid list
     */
    private HashMap<Integer, ArrayList<Long>> classId2oidList = new HashMap<>();

    /**
     * oid管理相关成员
     */
    private long maxOid = -1;
    private Stack<Long> unusedOid = new Stack<>();

    private long getNextOid() {
        if (unusedOid.empty()) return ++maxOid;
        else return unusedOid.pop();
    }

    /**
     * 代理oid ---> 源oid
     */
    private HashMap<Long, Long> deputyoid2sourceoid = new HashMap<>();

    /**
     * 源oid ---> 代理oid表
     */
    private HashMap<Long, ArrayList<Long>> sourceoid2deputyoid = new HashMap<>();

    /**
     * 新建一个类的对象列表
     *
     * @param classId 类id
     */
    void addObjectList(int classId) {
        classId2oidList.put(classId, new ArrayList<Long>());
    }

    /**
     * 删除一个类及其子类的对象列表
     *
     * @param classId
     */
    void removeObjectList(int classId) {
        if (DB.getCatalog().isClassHasSubclass(classId)) {
            for (int subclassId : DB.getCatalog().getSubclassList(classId))
                removeObjectList(subclassId);
        }
        classId2oidList.remove(classId);
    }

    /**
     * 插入对象；若存在子类且满足代理规则则插入代理对象
     *
     * @param object 对象
     */
    void insertObject(Object object) {

        long oid = getNextOid();
        object.setOid(oid);
        int classId = object.getBelongClassId();
        classId2oidList.get(classId).add(oid);
        sourceoid2deputyoid.put(oid, new ArrayList<Long>());
        oid2Object.put(oid, object);

        if (DB.getCatalog().isClassHasSubclass(classId)) {
            for (int deputyClassId : DB.getCatalog().getSubclassList(classId)) {
                objectPropagation(oid, deputyClassId);
            }
        }
    }

    /**
     * 对某个代理类进行更新迁移
     *
     * @param classId 代理类id
     */
    void classPropagation(int classId) {

        int sourceClassId = DB.getCatalog().getSourceClassId(classId);
        if (!classId2oidList.get(sourceClassId).isEmpty()) {
            for (long oid : classId2oidList.get(sourceClassId)) {
                objectPropagation(oid, classId);
            }
        }
    }

    /**
     * 将某个源对象向其某个代理类进行更新迁移
     *
     * @param oid
     * @param deputyClassId 代理类id
     */
    void objectPropagation(long oid, int deputyClassId) {

        ExprCalc calc = new ExprCalc(getAttrName2Data(oid));
        Field createDeputyObject = calc.calculate(DB.getCatalog().getDeputyRule(deputyClassId));
        if (((BooleanField) createDeputyObject).getValue()) {
            Object deputyObject = DB.getCatalog().newObject(deputyClassId);
            String[] switchExprs = DB.getCatalog().getSwitchExprs(deputyClassId);
            for (int i = 0; i < switchExprs.length; i++) {
                Field field = calc.calculate(switchExprs[i]);
                deputyObject.setField(i, field);
            }
            insertObject(deputyObject);
            deputyoid2sourceoid.put(deputyObject.getOid(), oid);
            sourceoid2deputyoid.get(oid).add(deputyObject.getOid());
        }
    }

    /**
     * 删除某个类中满足条件的对象
     *
     * @param classId 类id
     * @param deleteCond 删除条件
     */
    void deleteObject(int classId, String deleteCond) {
        ArrayList<Long> objectToDelete = filter(classId, deleteCond);
        if (objectToDelete.size() == 0) return;
        for (Long oid : objectToDelete) {
            deleteObject(oid);
        }
    }

    /**
     * 删除对象并删除其所有代理对象
     *
     * @param oid 类id
     */
    private void deleteObject(long oid) {
        int classId = oid2Object.get(oid).getBelongClassId();
        if (DB.getCatalog().isClassHasSubclass(classId)) {
            for (long deputyoid : sourceoid2deputyoid.get(oid)) {
                deleteObject(deputyoid);
                deputyoid2sourceoid.remove(deputyoid);
            }
        }
        sourceoid2deputyoid.remove(oid);
        classId2oidList.get(oid2Object.get(oid).getBelongClassId()).remove(oid);
        oid2Object.remove(oid);

        if (oid == maxOid) maxOid -= 1;
        else unusedOid.push(oid);
    }

    /**
     * 获取某个类中满足过滤条件的对象列表
     *
     * @param classId 类id
     * @param filterCond 过滤条件
     * @return
     */
    private ArrayList<Long> filter(int classId, String filterCond) {
        Iterator<Long> it = classId2oidList.get(classId).iterator();
        ArrayList<Long> objectFiltered = new ArrayList<>();
        while (it.hasNext()) {
            Object current = oid2Object.get(it.next());
            ExprCalc calc = new ExprCalc(getAttrName2Data(current.getOid()));
            if (((BooleanField)calc.calculate(filterCond)).getValue()) {
                objectFiltered.add(current.getOid());
            }
        }
        return objectFiltered;
    }

    /**
     * 更新某个类中满足条件的对象的某些域
     *
     * @param classId 类id
     * @param updateRule 更新条件
     * @param fields 域；若不更新则对应索引下为null
     */
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

    /**
     * 清空某个类中的所有对象及其代理对象
     *
     * @param classId 类id
     */
    void clearObject(int classId) {
        while (!classId2oidList.get(classId).isEmpty()) {
            deleteObject(classId2oidList.get(classId).get(0));
        }
    }

    /**
     * 简单查询
     *
     * @param classId 类id
     * @param isQueryList 与属性一一对应；数组中与属性对应的索引的值为真代表查询该属性
     * @param queryCond 查询条件
     * @return 第一行为属性名；其余行为数据
     */
    String simpleQuery(int classId, boolean[] isQueryList, String queryCond) {
        ArrayList<Long> oidQuery;
        if (queryCond != null)
            oidQuery = filter(classId, queryCond);
        else
            oidQuery = classId2oidList.get(classId);
        StringBuilder builder = new StringBuilder();
        builder.append("| ");
        for (int i = 0; i < isQueryList.length; i++) { ;
            if (isQueryList[i]) {
                builder.append(DB.getCatalog().getClassAttrName(classId, i));
                builder.append(" | ");
            }
        }
        builder.append("\r\n");
        if (oidQuery.size() == 0) return new String(builder);
        for (long oid : oidQuery) {
            builder.append("| ");
            Object current = oid2Object.get(oid);
            for (int i = 0; i < isQueryList.length; i++) {
                if (isQueryList[i]) {
                    builder.append(current.getField(i).toString());
                    builder.append(" | ");
                }
            }
            builder.append("\r\n");
        }
        return new String(builder);
    }

    /**
     * 跨类查询
     *
     * @param fromClassId 源类id
     * @param destClassId 目的类id
     * @param isQueryList 与目的类属性一一对应；数组中与属性对应的索引的值为真代表查询该属性
     * @param queryCond
     * @return
     */
    String crossClassQuery(int fromClassId, int destClassId, boolean[] isQueryList, String queryCond) {
        ArrayList<Long> oidQuery = filter(fromClassId, queryCond);
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
        builder.append("| ");
        for (int i = 0; i < isQueryList.length; i++) {
            if (isQueryList[i]) {
                builder.append(DB.getCatalog().getClassAttrName(destClassId, i));
                builder.append(" | ");
            }
        }
        builder.append("\r\n");
        if (oidQuery.size() == 0) return new String(builder);
        for (long oid : oidQuery) {
            builder.append("| ");
            Object current = oid2Object.get(oid);
            for (int i = 0; i < isQueryList.length; i++) {
                if (isQueryList[i]) {
                    builder.append(current.getField(i).toString());
                    builder.append(" | ");
                }
            }
            builder.append("\r\n");
        }
        return new String(builder);
    }

    /**
     * 获取某个对象属性名到数据的映射
     *
     * @param oid
     * @return
     */
    private HashMap<String, Field> getAttrName2Data(long oid) {
        HashMap<String, Field> attrName2Data = new HashMap<>();
        Object object = oid2Object.get(oid);
        for (int i = 0; i < DB.getCatalog().getClassAttrNumber(object.getBelongClassId()); i++) {
            attrName2Data.put(DB.getCatalog().getClassAttrName(object.getBelongClassId(), i), object.getField(i));
        }
        return attrName2Data;
    }
}
