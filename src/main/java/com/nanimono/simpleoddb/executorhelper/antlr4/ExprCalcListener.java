package com.nanimono.simpleoddb.executorhelper.antlr4;// Generated from ExprCalc.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ExprCalcParser}.
 */
public interface ExprCalcListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code MUL_DIV}
	 * labeled alternative in {@link ExprCalcParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMUL_DIV(ExprCalcParser.MUL_DIVContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MUL_DIV}
	 * labeled alternative in {@link ExprCalcParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMUL_DIV(ExprCalcParser.MUL_DIVContext ctx);
	/**
	 * Enter a parse tree produced by the {@code GREATER_LESS}
	 * labeled alternative in {@link ExprCalcParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterGREATER_LESS(ExprCalcParser.GREATER_LESSContext ctx);
	/**
	 * Exit a parse tree produced by the {@code GREATER_LESS}
	 * labeled alternative in {@link ExprCalcParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitGREATER_LESS(ExprCalcParser.GREATER_LESSContext ctx);
	/**
	 * Enter a parse tree produced by the {@code constant}
	 * labeled alternative in {@link ExprCalcParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterConstant(ExprCalcParser.ConstantContext ctx);
	/**
	 * Exit a parse tree produced by the {@code constant}
	 * labeled alternative in {@link ExprCalcParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitConstant(ExprCalcParser.ConstantContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BRACKET}
	 * labeled alternative in {@link ExprCalcParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBRACKET(ExprCalcParser.BRACKETContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BRACKET}
	 * labeled alternative in {@link ExprCalcParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBRACKET(ExprCalcParser.BRACKETContext ctx);
	/**
	 * Enter a parse tree produced by the {@code var}
	 * labeled alternative in {@link ExprCalcParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterVar(ExprCalcParser.VarContext ctx);
	/**
	 * Exit a parse tree produced by the {@code var}
	 * labeled alternative in {@link ExprCalcParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitVar(ExprCalcParser.VarContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MOD_}
	 * labeled alternative in {@link ExprCalcParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMOD_(ExprCalcParser.MOD_Context ctx);
	/**
	 * Exit a parse tree produced by the {@code MOD_}
	 * labeled alternative in {@link ExprCalcParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMOD_(ExprCalcParser.MOD_Context ctx);
	/**
	 * Enter a parse tree produced by the {@code ADD_SUB}
	 * labeled alternative in {@link ExprCalcParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterADD_SUB(ExprCalcParser.ADD_SUBContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ADD_SUB}
	 * labeled alternative in {@link ExprCalcParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitADD_SUB(ExprCalcParser.ADD_SUBContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LOGIC}
	 * labeled alternative in {@link ExprCalcParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLOGIC(ExprCalcParser.LOGICContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LOGIC}
	 * labeled alternative in {@link ExprCalcParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLOGIC(ExprCalcParser.LOGICContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EQUAL_ORNOT}
	 * labeled alternative in {@link ExprCalcParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterEQUAL_ORNOT(ExprCalcParser.EQUAL_ORNOTContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EQUAL_ORNOT}
	 * labeled alternative in {@link ExprCalcParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitEQUAL_ORNOT(ExprCalcParser.EQUAL_ORNOTContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BOOL}
	 * labeled alternative in {@link ExprCalcParser#value}.
	 * @param ctx the parse tree
	 */
	void enterBOOL(ExprCalcParser.BOOLContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BOOL}
	 * labeled alternative in {@link ExprCalcParser#value}.
	 * @param ctx the parse tree
	 */
	void exitBOOL(ExprCalcParser.BOOLContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CHAR}
	 * labeled alternative in {@link ExprCalcParser#value}.
	 * @param ctx the parse tree
	 */
	void enterCHAR(ExprCalcParser.CHARContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CHAR}
	 * labeled alternative in {@link ExprCalcParser#value}.
	 * @param ctx the parse tree
	 */
	void exitCHAR(ExprCalcParser.CHARContext ctx);
	/**
	 * Enter a parse tree produced by the {@code INT}
	 * labeled alternative in {@link ExprCalcParser#value}.
	 * @param ctx the parse tree
	 */
	void enterINT(ExprCalcParser.INTContext ctx);
	/**
	 * Exit a parse tree produced by the {@code INT}
	 * labeled alternative in {@link ExprCalcParser#value}.
	 * @param ctx the parse tree
	 */
	void exitINT(ExprCalcParser.INTContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FLOAT}
	 * labeled alternative in {@link ExprCalcParser#value}.
	 * @param ctx the parse tree
	 */
	void enterFLOAT(ExprCalcParser.FLOATContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FLOAT}
	 * labeled alternative in {@link ExprCalcParser#value}.
	 * @param ctx the parse tree
	 */
	void exitFLOAT(ExprCalcParser.FLOATContext ctx);
}