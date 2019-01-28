package com.nanimono.simpleoddb;

import com.nanimono.simpleoddb.object.Field;
import com.nanimono.simpleoddb.object.Object;
import com.nanimono.simpleoddb.object.TypeEnum;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;


/**
 * 存储系统表并对系统表进行操作。
 */
class Catalog implements Serializable {

    //===================================成员================================================

    /**
     * 类表，类id ---> 类表元组
     */
    private HashMap<Integer, ClassTableTuple> classTable = new HashMap<>();

    /**
     * 类名 ---> 类id
     */
    private HashMap<String, Integer> className2classId = new HashMap<>();

    /**
     * 属性表，类id ---> 属性元组；属性作为一个数组存储，属性索引作为数组索引；类id+属性索引可唯一确定一个属性
     */
    private HashMap<Integer, AttrTableTuple[]> attrTable = new HashMap<>();

    /**
     * 代理表，代理类id ---> 代理表元组
     */
    private HashMap<Integer, DeputyTableTuple> deputyTable = new HashMap<>();

    /**
     * 代理表，源类id ---> 代理表元组数组
     */
    private HashMap<Integer, ArrayList<DeputyTableTuple>> beDeputyTable = new HashMap<>();

    /**
     * 切换规则表，代理类id ---> 切换规则表元组；同一个类的切换规则存储在一个数组中，代理类属性索引作为数组索引
     */
    private HashMap<Integer, SwitchExprTableTuple[]> switchExprTable = new HashMap<>();

    /**
     * 类id管理相关成员
     */
    private int maxClassId = -1;
    private Stack<Integer> unusedClassId = new Stack<>();

    //===================================成员辅助类============================================

    public enum AttrType {REAL_ATTR, VIRTUAL_ATTR}
    public enum ClassType {SOURCECLASS, SELECTDEPUTY}

    /**
     * 类表元组类，成员包括类id、类名、类类型、是否有子类
     */
    private class ClassTableTuple implements Serializable {

        private int classId;       // start from zero
        private String className;
        private ClassType classType;
        private boolean hasSubClass;

        private ClassTableTuple(int classId, String className, ClassType classType) {
            this.classId = classId;
            this.className = className;
            this.classType = classType;
            this.hasSubClass = false;
        }
    }

    /**
     * 属性表元组类，成员包括所属类引用，属性名，属性大小，数据类型，属性类型（实属性、虚属性）
     */
    private class AttrTableTuple implements Serializable {

        private int belongClassId;
        private String attrName;
        private TypeEnum type;
        private int size;
        private AttrType attrType;

        private AttrTableTuple(int belongClassId, String attrName, TypeEnum type, int size, AttrType attrType) {
            this.belongClassId = belongClassId;
            this.attrName = attrName;
            this.type = type;
            if (type == TypeEnum.CHAR_TYPE) this.size = size + 2;
            else this.size = type.getSize();
            this.attrType = attrType;
        }
    }

    /**
     * 代理表元组类，成员包括代理类id、源类id、代理规则；代理规则使用字符串及二叉树进行存储。
     */
    private class DeputyTableTuple implements Serializable {

        private int deputyClassId;
        private int sourceClassId;
        private String deputyRule;

        private DeputyTableTuple(int deputyClassId, int sourceClassId, String deputyRule) {
            this.deputyClassId = deputyClassId;
            this.sourceClassId = sourceClassId;
            this.deputyRule = deputyRule;
        }
    }

    /**
     * 切换规则表元组类，成员包括代理类id、源类id、代理类属性索引、切换规则；切换规则使用字符串及二叉树进行存储。
     */
    private class SwitchExprTableTuple implements Serializable {

        private int deputyClassId;
        private int sourceClassId;
        private int deputyAttrId;
        private String switchExpr;

        private SwitchExprTableTuple(int deputyclassId,
                                    int sourceClassId,
                                    int deputyAttrId,
                                    String switchExpr) {
            this.deputyClassId = deputyclassId;
            this.sourceClassId = sourceClassId;
            this.deputyAttrId = deputyAttrId;
            this.switchExpr = switchExpr;
        }
    }

    //======================================类方法===============================================

    /**
     * 获取类id
     *
     * @param className 类名
     * @return 类存在返回类id，不存在返回-1
     */
    int getClassId(String className) {
        if (className2classId.get(className) == null) return -1;
        return className2classId.get(className);
    }

    /**
     * 获取类的类型
     *
     * @param classId 类id
     * @return 类不存在返回null
     */
    ClassType getClassType(int classId) {
        try {
            return classTable.get(classId).classType;
        } catch (NullPointerException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     *
     * @param classId 类id
     * @return 若类存在子类返回true；若不存在子类或类不存在则返回null
     */
    Boolean isClassHasSubclass(int classId) {
        try {
            return classTable.get(classId).hasSubClass;
        } catch (NullPointerException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取类属性个数
     *
     * @param classId 类id
     * @return 类属性个数
     */
    int getClassAttrNumber(int classId) {
        return attrTable.get(classId).length;
    }

    /**
     * 获取类属性数据类型
     *
     * @param classId 类id
     * @param attrIndex 属性索引
     * @return 属性数据类型；若类不存在或索引超出范围则返回null
     */
    TypeEnum getClassAttrDataType(int classId, int attrIndex) {
        try {
            return attrTable.get(classId)[attrIndex].type;
        } catch (NullPointerException | IndexOutOfBoundsException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取类属性数据大小
     *
     * @param classId 类id
     * @param attrIndex 属性索引
     * @return 属性数据大小；若类不存在或索引超出范围则返回-1
     */
    int getClassAttrSize(int classId, int attrIndex) {
        try {
            return attrTable.get(classId)[attrIndex].size;
        } catch (NullPointerException | IndexOutOfBoundsException e) {
            e.printStackTrace();
            return -1;
        }
    }

    /**
     * 获取类属性名
     *
     * @param classId 类id
     * @param attrIndex 属性索引
     * @return 属性名；若类不存在或索引超出范围则返回null
     */
    String getClassAttrName(int classId, int attrIndex) {
        try {
            return attrTable.get(classId)[attrIndex].attrName;
        } catch (NullPointerException | IndexOutOfBoundsException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取类属性数据大小
     *
     * @param classId 类id
     * @param attrName 类名
     * @return 属性数据大小；若类不存在或属性不存在则返回-1
     */
    int getClassAttrSize(int classId, String attrName) {
        try {
            for (int i = 0; i < attrTable.get(classId).length; i++) {
                if (attrName.equals(attrTable.get(classId)[i].attrName))
                    return attrTable.get(classId)[i].size;
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        } finally {
            return -1;
        }
    }

    /**
     * 获取一个代理类的源类id
     *
     * @param deputyClassId 代理类id
     * @return 若不存在则返回-1
     */
    int getSourceClassId(int deputyClassId) {
        try {
            return deputyTable.get(deputyClassId).sourceClassId;
        } catch (NullPointerException e) {
            e.printStackTrace();
            return -1;
        }
    }

    /**
     * 获取一个类的子类列表
     * @param classId 类id
     * @return 若不存在子类或类不存在则返回null
     */
    ArrayList<Integer> getSubclassList(int classId) {
        try {
            if (beDeputyTable.get(classId).isEmpty()) return null;
            ArrayList<Integer> subclassList = new ArrayList<>();
            for (DeputyTableTuple tuple : beDeputyTable.get(classId)) {
                subclassList.add(tuple.deputyClassId);
            }
            return subclassList;
        } catch (NullPointerException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取一个代理类的代理规则
     * @param classId 代理类id
     * @return 若不存在返回null
     */
    String getDeputyRule(int classId) {
        try {
            return deputyTable.get(classId).deputyRule;
        } catch (NullPointerException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取代理类的切换表达式列表，按属性顺序排列
     * @param classId 代理类id
     * @return 若不存在则返回null
     */
    String[] getSwitchExprs(int classId) {
        try {
            String[] switchExprs = new String[switchExprTable.get(classId).length];
            for (int i = 0; i < switchExprs.length; i++) {
                switchExprs[i] = switchExprTable.get(classId)[i].switchExpr;
            }
            return switchExprs;
        } catch (NullPointerException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取一个类属性名到类型的映射
     * @param classId 类id
     * @return 若不存在则返回null
     */
    HashMap<String, TypeEnum> getAttrName2Type(int classId) {
        try {
            HashMap<String, TypeEnum> attrName2Type = new HashMap<>();
            for (int i = 0; i < attrTable.get(classId).length; i++) {
                attrName2Type.put(attrTable.get(classId)[i].attrName, attrTable.get(classId)[i].type);
            }
            return attrName2Type;
        } catch (NullPointerException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取下一个可用的类id
     * @return 类id
     */
    private int getNextClassId() {
        if (unusedClassId.empty()) return ++maxClassId;
        else return unusedClassId.pop();
    }

    /**
     * 添加新的源类
     * @param className 类名
     * @param attrNameList 属性名列表
     * @param typeList 数据类型列表
     * @param sizeList 数据大小列表（仅对char类型有效）
     */
    void addSourceClass(String className, String[] attrNameList, TypeEnum[] typeList, int[] sizeList) {

        // 修改classTable
        int classId = getNextClassId();
        className2classId.put(className, classId);
        classTable.put(classId, new ClassTableTuple(classId, className, ClassType.SOURCECLASS));

        // 修改attrTable
        AttrTableTuple[] attrList = new AttrTableTuple[typeList.length];
        for (int i = 0; i < attrList.length; i++) {
            attrList[i] = new AttrTableTuple(classId,
                    attrNameList[i],
                    typeList[i],
                    sizeList[i],
                    AttrType.REAL_ATTR);
        }
        attrTable.put(classId, attrList);

        // 修改beDeputyTable
        beDeputyTable.put(classId, new ArrayList<>());
    }

    /**
     * 添加新的选择代理类，仅实现虚属性
     * @param className 类名
     * @param sClassId 源类id
     * @param switchExprs 切换表达式列表
     * @param attrNameList 属性列表
     * @param typeList 数据类型列表
     * @param sizeList 数据大小列表（仅对char类型有效）
     * @param deputyRule 代理规则
     */
    void addSelectDeputyClass(String className,
                                     int sClassId,
                                     String[] switchExprs,
                                     String[] attrNameList,
                                     TypeEnum[] typeList,
                                     int[] sizeList,
                                     String deputyRule) {

        // 修改classTable
        classTable.get(sClassId).hasSubClass = true;
        int classId = getNextClassId();
        className2classId.put(className, classId);
        classTable.put(classId, new ClassTableTuple(classId, className, ClassType.SELECTDEPUTY));

        // 修改attrTable
        AttrTableTuple[] attrList = new AttrTableTuple[attrNameList.length];
        for (int i = 0; i < attrList.length; i++) {
            attrList[i] = new AttrTableTuple(classId,
                    attrNameList[i],
                    typeList[i],
                    sizeList[i],
                    AttrType.VIRTUAL_ATTR);
        }
        attrTable.put(classId, attrList);

        // 修改deputyTable beDeputyTable
        DeputyTableTuple deputyTuple = new DeputyTableTuple(classId,
                sClassId,
                deputyRule);
        deputyTable.put(classId, deputyTuple);
        beDeputyTable.get(sClassId).add(deputyTuple);

        // 修改switchExprTable
        SwitchExprTableTuple[] switchExprList = new SwitchExprTableTuple[attrList.length];
        for (int i = 0; i < switchExprList.length; i++) {
            switchExprList[i] = new SwitchExprTableTuple(classId,
                    sClassId,
                    i,
                    switchExprs[i]);
        }
        switchExprTable.put(classId, switchExprList);
    }

    /**
     * 删除类；仅修改系统表
     *
     * @param classId 类id
     */
    void dropClass(int classId) {

        // 先删除子类
        ClassTableTuple classToDelete = classTable.get(classId);
        if (classToDelete.hasSubClass) {
            while (!beDeputyTable.get(classToDelete.classId).isEmpty())
                dropClass(beDeputyTable.get(classId).remove(0).deputyClassId);
            beDeputyTable.remove(classId);
        }

        // 若是代理类，删除switchExprTable、deputyTable中的条目；若源类不再存在代理类，修改源类相关属性
        if (classToDelete.classType != ClassType.SOURCECLASS) {
            switchExprTable.remove(classToDelete.classId);
            int sClassId = deputyTable.get(classId).sourceClassId;
            beDeputyTable.get(sClassId).remove(deputyTable.remove(classId));
            if (beDeputyTable.get(sClassId).isEmpty()) {
                classTable.get(sClassId).hasSubClass = false;
            }
        }

        // 删除属性表、类表中的条目
        attrTable.remove(classToDelete.classId);
        className2classId.remove(classToDelete.className);
        classTable.remove(classId);

        if (classId == maxClassId) maxClassId -= 1;
        else unusedClassId.push(classId);
    }

    /**
     * 根据类属性定义返回一个对象
     * @param classId 类id
     * @return
     */
    Object newObject(int classId) {
        Object object = new Object();
        object.setBelongClassId(classId);
        object.setFields(new Field[attrTable.get(classId).length]);
        int len = 0;
        for (int i = 0; i < attrTable.get(classId).length; i++) {
            len += attrTable.get(classId)[i].size;
        }
        object.setLen(len);
        return object;
    }
}
