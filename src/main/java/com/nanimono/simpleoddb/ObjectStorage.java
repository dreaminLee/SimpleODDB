package com.nanimono.simpleoddb;

import com.nanimono.simpleoddb.executor.ExprCalc;
import com.nanimono.simpleoddb.object.BooleanField;
import com.nanimono.simpleoddb.object.Field;
import com.nanimono.simpleoddb.object.Object;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ObjectStorage implements Serializable {

    /**
     * 类id，oid ---> 对象
     */
    private HashMap<Integer, HashMap<Integer, Object>> classId2ObjectList = new HashMap<>();

    /**
     * 类id ---> 下一个oid
     */
    private HashMap<Integer, Integer> nextOid = new HashMap<>();

    /**
     * 代理类id ---> 双向指针表
     */
    private HashMap<Integer, ArrayList<BiPointerTableTuple>> biPointerTable = new HashMap<>();

    public class BiPointerTableTuple implements Serializable {
        private int deputyClassId;
        private int deputyObjectId;
        private int sourceClassId;
        private int sourceObjectId;

        public BiPointerTableTuple(int deputyClassId, int deputyObjectId, int sourceClassId, int sourceObjectId) {
            this.deputyClassId = deputyClassId;
            this.deputyObjectId = deputyObjectId;
            this.sourceClassId = sourceClassId;
            this.sourceObjectId = sourceObjectId;
        }

        public int getDeputyClassId() {
            return deputyClassId;
        }

        public int getDeputyObjectId() {
            return deputyObjectId;
        }

        public int getSourceClassId() {
            return sourceClassId;
        }

        public int getSourceObjectId() {
            return sourceObjectId;
        }
    }

    public int nextObjectIndex(int classId) {
        int oid = nextOid.get(classId);
        nextOid.put(classId, oid + 1);
        return oid;
    }

    public void addObjectList(int classId) {
        classId2ObjectList.put(classId, new HashMap<>());
        nextOid.put(classId, 0);
    }

    public void removeObjectList(int classId) {
        classId2ObjectList.remove(classId);
        nextOid.remove(classId);
    }

    public void addBiPointerTable(int classId) {
        biPointerTable.put(classId, new ArrayList<>());
    }

    public void removeBiPointerTable(int classId) {
        biPointerTable.remove(classId);
    }

    public void insertObject(int classId, Object object) {

        // 插入源对象并创建新对象插入代理类
        object.setOid(nextObjectIndex(classId));
        classId2ObjectList.get(classId).put(object.getOid(), object);

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
                    Object deputyObject = new Object(deputyTuple.getDeputyClassId());
                    Catalog.SwitchExprTableTuple[] switchExprList = DB.getCatalog().getSwitchRuleList(deputyTuple.getDeputyClassId());
                    for (int i = 0; i < switchExprList.length; i++) {
                        Field field = calc.calculate(switchExprList[i].getSwitchRule());
                        deputyObject.setField(i, field);
                    }
                    DB.insertObject(deputyTuple.getDeputyClassId(), deputyObject);
                    biPointerTable.get(deputyTuple.getDeputyClassId()).add(new BiPointerTableTuple(
                            deputyTuple.getDeputyClassId(),
                            deputyObject.getOid(),
                            classId,
                            object.getOid()
                    ));
                }
            }
        }
    }

    public void deleteObject(int classId, String deputyRule) {
        ArrayList<Integer> objectToDelete = filter(classId, deputyRule);
        for (int oid : objectToDelete) {
            deleteObject(classId, oid);
        }
    }

    private void deleteObject(int classId, int oid) {
        if (DB.getCatalog().getClassHasSubclass(classId)) {
            Iterator<Catalog.DeputyTableTuple> it = DB.getCatalog().getBeDeputyRule(classId).iterator();
            while (it.hasNext()) {
                int deputyClassId = it.next().getDeputyClassId();
                Iterator<BiPointerTableTuple> biPointerIte = biPointerTable.get(deputyClassId).iterator();
                while (biPointerIte.hasNext()) {
                    BiPointerTableTuple tuple = biPointerIte.next();
                    if (tuple.getSourceClassId() == classId && tuple.getSourceObjectId() == oid) {
                        deleteObject(deputyClassId, tuple.getDeputyObjectId());
                        biPointerTable.get(deputyClassId).remove(tuple);
                        break;
                    }
                }
            }
        }
        classId2ObjectList.get(classId).remove(oid);
    }

    private ArrayList<Integer> filter(int classId, String filterRule) {
        Iterator<Map.Entry<Integer, Object>> it = classId2ObjectList.get(classId).entrySet().iterator();
        HashMap<String, Field> var2field = new HashMap<>();
        Catalog.AttrTableTuple[] attrList = DB.getCatalog().getClassAttrList(classId);
        ArrayList<Integer> objectFiltered = new ArrayList<>();
        while (it.hasNext()) {
            Object current = it.next().getValue();
            for (int i = 0; i < attrList.length; i++) {
                var2field.put(attrList[i].getAttrName(), current.getField(i));
            }
            ExprCalc calc = new ExprCalc(var2field);
            if (((BooleanField)calc.calculate(filterRule)).getValue()) {
                objectFiltered.add(current.getOid());
            }
            else continue;
        }
        return objectFiltered;
    }

    public void updateObject(int classId, String updateRule, Field[] fields) {
        ArrayList<Integer> oidToUpdate = filter(classId, updateRule);
        for (int oid : oidToUpdate) {
            Object current = classId2ObjectList.get(classId).get(oid);
            deleteObject(classId, oid);
            for (int i = 0; i < fields.length; i++) {
                current.setField(i, fields[i]);
            }
            insertObject(classId, current);
        }
    }
}
