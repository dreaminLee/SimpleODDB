package com.nanimono.simpleoddb;

import com.nanimono.simpleoddb.executor.ExprTreeNode;
import com.nanimono.simpleoddb.object.Type;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * 存储系统表并对系统表进行操作。
 */
public class Catalog {

    //===================================成员================================================

    /**
     * 类表，类在ArrayList中的索引即为该类的id
     */
    private ArrayList<ClassTableTuple> classTable = new ArrayList<>();

    /**
     * 类名到类id的映射，加速通过类名查找类
     */
    private HashMap<String, Integer> className2classId = new HashMap<>();

    /**
     * 属性表，使用哈希表进行存储，类id作为key；属性作为一个数组存储，属性索引作为数组索引；id+属性索引可唯一确定一个属性
     */
    private HashMap<Integer, AttrTableTuple[]> attrTable = new HashMap<>();

    /**
     * 代理表，使用哈希表进行存储，类id作为key
     */
    private HashMap<Integer, deputyTableTuple> deputyTable = new HashMap<>();

    /**
     * 切换规则表，使用哈希表进行存储，类id作为key；同一个类的切换规则存储在一个数组中，代理类属性索引作为数组索引
     */
    private HashMap<Integer, switchExprTableTuple[]> switchExprTable = new HashMap<>();

    //===================================成员辅助类============================================

    public enum ClassType {UNALLOCATED, SOURCECLASS, SELECTDEPUTY}

    /**
     * 类表元组类，成员包括类id、类名、类类型、是否有子类
     */
    public class ClassTableTuple {

        private int classId;       // start from zero
        private String className;
        private ClassType classType;
        private boolean hasSubClass;

        public ClassTableTuple(int classId, String className, ClassType classType) {
            this.classId = classId;
            this.className = className;
            this.classType = classType;
            this.hasSubClass = false;
        }

        public int getClassId() {
            return classId;
        }

        public String getClassName() {
            return className;
        }

        public ClassType getClassType() {
            return classType;
        }

        public boolean isHasSubClass() {
            return hasSubClass;
        }

        public void setHasSubClass(boolean hasSubClass) {
            this.hasSubClass = hasSubClass;
        }
    }

    public enum AttrType {REAL_ATTR, VIRTUAL_ATTR}

    /**
     * 属性表元组类，成员包括所属类引用，属性名，数据类型，属性类型（实属性、虚属性）
     */
    public class AttrTableTuple {

        private ClassTableTuple belongClass;
        private String attrName;
        private Type type;
        private AttrType attrType;

        public AttrTableTuple(ClassTableTuple belongClass, String attrName, Type type, AttrType attrType) {
            this.belongClass = belongClass;
            this.attrName = attrName;
            this.type = type;
            this.attrType = attrType;
        }

        public ClassTableTuple getBelongClass() {
            return belongClass;
        }

        public String getAttrName() {
            return attrName;
        }

        public Type getType() {
            return type;
        }

        public AttrType getAttrType() {
            return attrType;
        }
    }

    /**
     * 代理表元组类，成员包括代理类id、源类id、代理规则；代理规则使用字符串及二叉树进行存储。
     */
    public class deputyTableTuple {

        private int deputyClassId;
        private int sourceClassId;
        private String deputyRule;
        private ExprTreeNode exprTreeRoot;

        public deputyTableTuple(int deputyClassId, int sourceClassId, String deputyRule, ExprTreeNode exprTreeRoot) {
            this.deputyClassId = deputyClassId;
            this.sourceClassId = sourceClassId;
            this.deputyRule = deputyRule;
            this.exprTreeRoot = exprTreeRoot;
        }

        public int getDeputyClassId() { return deputyClassId; }

        public int getSourceClassId() { return sourceClassId; }

        public String getDeputyRule() { return deputyRule; }

        public ExprTreeNode getExprTreeRoot() {
            return exprTreeRoot;
        }
    }

    /**
     * 切换规则表元组类，成员包括代理类id、源类id、代理类属性索引、源类属性索引、切换规则；切换规则使用字符串及二叉树进行存储。
     */
    public class switchExprTableTuple {

        private int deputyClassId;
        private int sourceClassId;
        private int deputyAttrId;
        private int sourceAttrId;
        private String switchRule;
        private ExprTreeNode exprTreeRoot;

        public switchExprTableTuple(int deputyclassId,
                                    int sourceClassId,
                                    int deputyAttrId,
                                    int sourceAttrId,
                                    String switchRule,
                                    ExprTreeNode exprTreeRoot) {
            this.deputyClassId = deputyclassId;
            this.sourceClassId = sourceClassId;
            this.deputyAttrId = deputyAttrId;
            this.sourceAttrId = sourceAttrId;
            this.switchRule = switchRule;
            this.exprTreeRoot = exprTreeRoot;
        }

        public int getDeputyClassId() {
            return deputyClassId;
        }

        public int getSourceClassId() {
            return sourceClassId;
        }

        public int getDeputyAttrId() {
            return deputyAttrId;
        }

        public int getSourceAttrId() {
            return sourceAttrId;
        }

        public String getSwitchRule() {
            return switchRule;
        }

        public ExprTreeNode getExprTreeRoot() { return exprTreeRoot; }
    }

    //======================================类方法===============================================

    /**
     * 获取类的属性列表
     *
     * @param classId 类名
     * @return 类的属性列表
     */
    public AttrTableTuple[] getClassTypeList(int classId) {
        return attrTable.get(classId);
    }

    /**
     * 获取代理类的切换规则
     *
     * @param classId 类名
     * @return
     */
    public switchExprTableTuple[] getSwitchRuleList(int classId) {
        return switchExprTable.get(classId);
    }

    /**
     * 获取代理类的代理规则
     *
     * @param classId 类id
     * @return
     */
    public deputyTableTuple getDeputyRule(int classId) {
        return deputyTable.get(classId);
    }

    /**
     * 获取类id
     *
     * @param className 类名
     * @return
     */
    public Integer getClassId(String className) { return className2classId.get(className); }

    /**
     * 添加新的源类
     *
     * @param className    类名
     * @param attrNameList 属性名
     * @param typeList     数据类型
     */
    public void addSourceClass(String className, String[] attrNameList, Type[] typeList) {

        // 参数是否合法
        if (attrNameList == null || attrNameList.length == 0) {
            throw new IllegalArgumentException("Attribute name list cannot empty.");
        }
        if (typeList == null || typeList.length == 0) {
            throw new IllegalArgumentException("Type list cannot empty.");
        }
        if (typeList.length != attrNameList.length) {
            throw new IllegalArgumentException("Type list and attribute name list must have the same size");
        }

        // classTable中的是否有同名类；得到新建类存储的位置，低位置优先
        int index = classTable.size();
        for (ClassTableTuple tuple : classTable) {
            if (tuple.className.equals(className)) {
                throw new IllegalArgumentException("Class already exists.");
            }
            if (tuple.classType == ClassType.UNALLOCATED && tuple.classId < index) {
                index = tuple.classId;
            }
        }

        // 修改 ClassTable
        if (index == classTable.size()) {
            classTable.add(new ClassTableTuple(index, className, ClassType.SOURCECLASS));
        } else {
            // 直接修改之前被删除的类的条目
            ClassTableTuple tuple = classTable.get(index);
            tuple.className = className;
            tuple.classType = ClassType.SOURCECLASS;
            tuple.hasSubClass = false;
        }

        className2classId.put(className, classTable.get(index).classId);

        // 修改 AttrTable
        AttrTableTuple[] attrList = new AttrTableTuple[typeList.length];
        for (int i = 0; i < attrList.length; i++) {
            attrList[i] = new AttrTableTuple(classTable.get(index), attrNameList[i], typeList[i], AttrType.REAL_ATTR);
        }
        attrTable.put(index, attrList);
    }

    /**
     * 添加新的选择代理类，目前仅实现了虚属性
     *
     * @param className    新建类名
     * @param sClassName   源类名
     * @param switchExprs  切换规则
     * @param attrNameList
     * @param deputyRules
     */
    public void addSelectDeputyClass(String className,
                                     String sClassName,
                                     String[] switchExprs,
                                     String[] attrNameList,
                                     String deputyRules) {
        // 检查参数是否合法
        if (attrNameList == null || attrNameList.length == 0) {
            throw new IllegalArgumentException("Attribute name list cannot be empty.");
        }
        if (switchExprs == null || switchExprs.length == 0) {
            throw new IllegalArgumentException("Switching expression list cannot be empty");
        }
        if (switchExprs.length != attrNameList.length) {
            throw new IllegalArgumentException("Switching expression list and attribute name list must have the same size");
        }

        // 是否存在同名类；查找源类；得到新建类的存储位置，低位置优先
        ClassTableTuple sourceClass = null;
        int index = classTable.size();
        for (ClassTableTuple tuple : classTable) {
            if (tuple.className.equals(className)) {
                throw new IllegalArgumentException("Class already exists.");
            }
            if (tuple.className.equals(sClassName)) {
                sourceClass = tuple;
            }
            if (tuple.classType == ClassType.UNALLOCATED && tuple.classId < index) {
                index = tuple.classId;
            }
        }
        if (sourceClass == null) {
            throw new IllegalArgumentException("Source class doesn't exist.");
        }

        // 修改classTable
        if (index == classTable.size()) {
            classTable.add(new ClassTableTuple(index, className, ClassType.SELECTDEPUTY));
        } else {
            ClassTableTuple tuple = classTable.get(index);
            tuple.className = className;
            tuple.classType = ClassType.SELECTDEPUTY;
            tuple.hasSubClass = false;
        }

        className2classId.put(className, index);

        // TODO 修改 AttrTable，deputyTable， switchRule
        AttrTableTuple[] attrList = new AttrTableTuple[attrNameList.length];
        for (int i = 0; i < attrList.length; i++) {
            //attrList[i] = new AttrTableTuple(classTable.get(index), attrNameList[i], new Type(), AttrType.VIRTUAL_ATTR);
        }
    }

    /**
     * 删除类
     *
     * @param className 类名
     */
    public void dropClass(String className) {
        if (!className2classId.containsKey(className)) throw new IllegalArgumentException("Class doesn't exist.");

        ClassTableTuple classTableTuple = classTable.get(className2classId.get(className));

        AttrTableTuple[] attrTableTuples = getClassTypeList(classTableTuple.classId);
        attrTable.remove(classTableTuple.classId);
        switchExprTableTuple[] switchExprTableTuples = getSwitchRuleList(classTableTuple.classId);
        switchExprTable.remove(classTableTuple.classId);
    }
}
