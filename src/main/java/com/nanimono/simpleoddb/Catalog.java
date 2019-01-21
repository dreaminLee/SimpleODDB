package com.nanimono.simpleoddb;

import com.nanimono.simpleoddb.executor.ExprTreeNode;
import com.nanimono.simpleoddb.object.Type;
import com.nanimono.simpleoddb.object.TypeEnum;

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
    private HashMap<Integer, DeputyTableTuple> deputyTable = new HashMap<>();

    /**
     * 切换规则表，使用哈希表进行存储，类id作为key；同一个类的切换规则存储在一个数组中，代理类属性索引作为数组索引
     */
    private HashMap<Integer, SwitchExprTableTuple[]> switchExprTable = new HashMap<>();

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
     * 属性表元组类，成员包括所属类引用，属性名，属性大小，数据类型，属性类型（实属性、虚属性）
     */
    public class AttrTableTuple {

        private ClassTableTuple belongClass;
        private String attrName;
        private TypeEnum type;
        private int size;
        private AttrType attrType;

        public AttrTableTuple(ClassTableTuple belongClass, String attrName, TypeEnum type, int size, AttrType attrType) {
            this.belongClass = belongClass;
            this.attrName = attrName;
            this.type = type;
            if (type == TypeEnum.CHAR_TYPE) this.size = size;
            else this.size = type.getSize();
            this.attrType = attrType;
        }

        public ClassTableTuple getBelongClass() {
            return belongClass;
        }

        public String getAttrName() {
            return attrName;
        }

        public TypeEnum getType() {
            return type;
        }

        public int getSize() {
            return size;
        }

        public AttrType getAttrType() {
            return attrType;
        }
    }

    /**
     * 代理表元组类，成员包括代理类id、源类id、代理规则；代理规则使用字符串及二叉树进行存储。
     */
    public class DeputyTableTuple {

        private int deputyClassId;
        private int sourceClassId;
        private String deputyRule;
        private ExprTreeNode exprTreeRoot;

        public DeputyTableTuple(int deputyClassId, int sourceClassId, String deputyRule, ExprTreeNode exprTreeRoot) {
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
     * 切换规则表元组类，成员包括代理类id、源类id、代理类属性索引、切换规则；切换规则使用字符串及二叉树进行存储。
     */
    public class SwitchExprTableTuple {

        private int deputyClassId;
        private int sourceClassId;
        private int deputyAttrId;
        private String switchRule;
        private ExprTreeNode exprTreeRoot;

        public SwitchExprTableTuple(int deputyclassId,
                                    int sourceClassId,
                                    int deputyAttrId,
                                    String switchRule,
                                    ExprTreeNode exprTreeRoot) {
            this.deputyClassId = deputyclassId;
            this.sourceClassId = sourceClassId;
            this.deputyAttrId = deputyAttrId;
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
    public AttrTableTuple[] getClassAttrList(int classId) {
        return attrTable.get(classId);
    }

    /**
     * 获取代理类的切换规则
     *
     * @param classId 类名
     * @return
     */
    public SwitchExprTableTuple[] getSwitchRuleList(int classId) {
        return switchExprTable.get(classId);
    }

    /**
     * 获取代理类的代理规则
     *
     * @param classId 类id
     * @return
     */
    public DeputyTableTuple getDeputyRule(int classId) {
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

        // 属性是否有相同名
        for (int i = 0; i < attrNameList.length; i++) {
            for (int j = i + 1; j < attrNameList.length; j++) {
                if (attrNameList[i].equals(attrNameList[j]))
                    throw new IllegalArgumentException("Duplicate attribute's name.");
            }
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
            attrList[i] = new AttrTableTuple(classTable.get(index), attrNameList[i], typeList[i].getTypeEnum(), typeList[i].getSize(), AttrType.REAL_ATTR);
        }
        attrTable.put(index, attrList);
    }

    /**
     * 添加新的选择代理类，目前仅实现了虚属性
     *
     * @param className    新建类名
     * @param sClassName   源类名
     * @param switchExprs  切换表达式
     * @param attrNameList 属性名
     * @param deputyRule  代理规则
     * @param exprTrees    表达式树
     */
    public void addSelectDeputyClass(String className,
                                     String sClassName,
                                     String[] switchExprs,
                                     String[] attrNameList,
                                     String deputyRule,
                                     ExprTreeNode[] exprTrees) {
        // 检查参数是否合法
        if (attrNameList == null || attrNameList.length == 0) {
            throw new IllegalArgumentException("Attribute name list cannot be empty.");
        }
        if (switchExprs == null || switchExprs.length == 0) {
            throw new IllegalArgumentException("Switching expression list cannot be empty");
        }
        if (exprTrees == null || exprTrees.length == 0) {
            throw new IllegalArgumentException("Expression tree cannot be empty.");
        }
        if (!(switchExprs.length == attrNameList.length && switchExprs.length + 1 == exprTrees.length)) {
            throw new IllegalArgumentException("Switching expression list and attribute name list and expression trees must have the same size");
        }

        // 是否存在同名类；查找源类；得到新建类的存储位置，低位置优先
        ClassTableTuple sourceClass = null;
        int classTableIndex = classTable.size();
        for (ClassTableTuple tuple : classTable) {
            if (tuple.className.equals(className)) {
                throw new IllegalArgumentException("Class already exists.");
            }
            if (tuple.className.equals(sClassName)) {
                sourceClass = tuple;
            }
            if (tuple.classType == ClassType.UNALLOCATED && tuple.classId < classTableIndex) {
                classTableIndex = tuple.classId;
            }
        }
        if (sourceClass == null) {
            throw new IllegalArgumentException("Source class doesn't exist.");
        }

        // 检查表达式树是否合法
        AttrTableTuple[] sourceClassAttrs = attrTable.get(sourceClass.classId);
        HashMap<String, TypeEnum> sourceAttrName2Type = new HashMap<>();
        for (AttrTableTuple tuple : sourceClassAttrs) sourceAttrName2Type.put(tuple.attrName, tuple.type);
        // where 表达式必须是布尔型
        if (getTreeType(exprTrees[exprTrees.length - 1], sourceAttrName2Type) != TypeEnum.BOOLEAN_TYPE)
            throw new IllegalArgumentException("Where clause illegal.");
        // 切换规则表达式必须有类型
        Type[] deputyClassAttrTypes = new Type[exprTrees.length - 1];
        for (int i = 0; i < exprTrees.length - 1; i++) {
            ExprTreeNode tree = exprTrees[i];
            TypeEnum treeType;
            if ((treeType = getTreeType(tree, sourceAttrName2Type)) == null) {
                throw new IllegalArgumentException("Expression illegal.");
            }
            else {
                deputyClassAttrTypes[i] = new Type(treeType);
                if (treeType == TypeEnum.CHAR_TYPE) {
                    for (AttrTableTuple tuple : sourceClassAttrs) {
                        if (tree.getData().equals(tuple.attrName)) {
                            deputyClassAttrTypes[i].setSize(tuple.size);
                            break;
                        }
                    }
                }
            }
        }

        // 修改classTable
        sourceClass.hasSubClass = true;
        if (classTableIndex == classTable.size()) {
            classTable.add(new ClassTableTuple(classTableIndex, className, ClassType.SELECTDEPUTY));
        } else {
            ClassTableTuple tuple = classTable.get(classTableIndex);
            tuple.className = className;
            tuple.classType = ClassType.SELECTDEPUTY;
            tuple.hasSubClass = false;
        }

        className2classId.put(className, classTableIndex);

        // 修改AttrTable
        AttrTableTuple[] attrList = new AttrTableTuple[attrNameList.length];
        for (int i = 0; i < attrList.length; i++) {
            attrList[i] = new AttrTableTuple(classTable.get(classTableIndex),
                    attrNameList[i],
                    deputyClassAttrTypes[i].getTypeEnum(),
                    deputyClassAttrTypes[i].getSize(),
                    AttrType.VIRTUAL_ATTR);
        }
        attrTable.put(classTableIndex, attrList);

        // 修改DeputyTable
        deputyTable.put(classTableIndex, new DeputyTableTuple(classTableIndex,
                className2classId.get(sClassName),
                deputyRule,
                exprTrees[exprTrees.length - 1]));

        // 修改SwitchExprTable
        SwitchExprTableTuple[] switchExprList = new SwitchExprTableTuple[attrList.length];
        for (int i = 0; i < switchExprList.length; i++) {
            switchExprList[i] = new SwitchExprTableTuple(classTableIndex,
                    className2classId.get(sClassName),
                    i,
                    switchExprs[i],
                    exprTrees[i]);
        }
        switchExprTable.put(classTableIndex, switchExprList);

    }

    /**
     * 删除类
     *
     * @param className 类名
     */
    public void dropClass(String className) {
        if (!className2classId.containsKey(className)) throw new IllegalArgumentException("Class doesn't exist.");

        ClassTableTuple classTableTuple = classTable.get(className2classId.get(className));

        AttrTableTuple[] attrTableTuples = attrTable.get(classTableTuple.classId);
        attrTable.remove(classTableTuple.classId);
        SwitchExprTableTuple[] switchExprTableTuples = switchExprTable.get(classTableTuple.classId);
        switchExprTable.remove(classTableTuple.classId);
    }

    //==============================================辅助方法=======================================================

    /**
     * 判断一棵表达式树是否能够定型，如果能定型就是一棵合法的表达式树，否则不合法
     *
     * @param node     树节点
     * @param context  哈希表，属性名到类型的映射
     * @return
     */
    public static TypeEnum getTreeType(ExprTreeNode node, HashMap<String, TypeEnum> context) {
        // 基本类型
        if (node == null || context == null) return null;
        if (node.getType().convertToType() != null) return node.getType().convertToType();
        else {
            // 变量
            if (node.getLchild() == null) return context.get(node.getData());
            else {
                TypeEnum lchildType = getTreeType(node.getLchild(), context);
                TypeEnum rchildType = getTreeType(node.getRchild(), context);
                String op = (String) node.getData();
                switch (op) {
                    case "AND":
                    case "OR":
                        if (lchildType == TypeEnum.BOOLEAN_TYPE && rchildType == TypeEnum.BOOLEAN_TYPE)
                            return TypeEnum.BOOLEAN_TYPE;
                        else
                            return null;

                    case "=":
                    case "==":
                    case "!=":
                    case "<>":
                        if (lchildType == TypeEnum.BOOLEAN_TYPE || rchildType == TypeEnum.BOOLEAN_TYPE)
                            return TypeEnum.BOOLEAN_TYPE;
                    case "<":
                    case "<=":
                    case ">":
                    case ">=":
                        if ((lchildType == TypeEnum.INT_TYPE || lchildType == TypeEnum.FLOAT_TYPE) &&
                                (rchildType == TypeEnum.INT_TYPE || rchildType == TypeEnum.FLOAT_TYPE) ||
                                (lchildType == TypeEnum.CHAR_TYPE && rchildType == TypeEnum.CHAR_TYPE))
                            return TypeEnum.BOOLEAN_TYPE;
                        else return null;

                    case "/":
                        if ((lchildType == TypeEnum.INT_TYPE || lchildType == TypeEnum.FLOAT_TYPE) &&
                                (rchildType == TypeEnum.INT_TYPE || rchildType == TypeEnum.FLOAT_TYPE))
                            return TypeEnum.FLOAT_TYPE;
                    case "+":
                    case "-":
                    case "*":
                        if ((lchildType == TypeEnum.INT_TYPE || lchildType == TypeEnum.FLOAT_TYPE) &&
                                (rchildType == TypeEnum.INT_TYPE || rchildType == TypeEnum.FLOAT_TYPE)) {
                            if (lchildType == rchildType) return lchildType;
                            else return TypeEnum.FLOAT_TYPE;
                        } else return null;

                    case "%":
                        if (lchildType == TypeEnum.INT_TYPE && rchildType == TypeEnum.INT_TYPE)
                            return TypeEnum.INT_TYPE;
                        else return null;

                    default:
                        return null;
                }
            }
        }
    }
}
