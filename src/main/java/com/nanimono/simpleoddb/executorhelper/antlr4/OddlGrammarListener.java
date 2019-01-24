package com.nanimono.simpleoddb.executorhelper.antlr4;// Generated from OddlGrammar.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link OddlGrammarParser}.
 */
public interface OddlGrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link OddlGrammarParser#root}.
	 * @param ctx the parse tree
	 */
	void enterRoot(OddlGrammarParser.RootContext ctx);
	/**
	 * Exit a parse tree produced by {@link OddlGrammarParser#root}.
	 * @param ctx the parse tree
	 */
	void exitRoot(OddlGrammarParser.RootContext ctx);
	/**
	 * Enter a parse tree produced by {@link OddlGrammarParser#oddlStatements}.
	 * @param ctx the parse tree
	 */
	void enterOddlStatements(OddlGrammarParser.OddlStatementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link OddlGrammarParser#oddlStatements}.
	 * @param ctx the parse tree
	 */
	void exitOddlStatements(OddlGrammarParser.OddlStatementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link OddlGrammarParser#oddlStatement}.
	 * @param ctx the parse tree
	 */
	void enterOddlStatement(OddlGrammarParser.OddlStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link OddlGrammarParser#oddlStatement}.
	 * @param ctx the parse tree
	 */
	void exitOddlStatement(OddlGrammarParser.OddlStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link OddlGrammarParser#createSourceClass}.
	 * @param ctx the parse tree
	 */
	void enterCreateSourceClass(OddlGrammarParser.CreateSourceClassContext ctx);
	/**
	 * Exit a parse tree produced by {@link OddlGrammarParser#createSourceClass}.
	 * @param ctx the parse tree
	 */
	void exitCreateSourceClass(OddlGrammarParser.CreateSourceClassContext ctx);
	/**
	 * Enter a parse tree produced by {@link OddlGrammarParser#createDefinitions}.
	 * @param ctx the parse tree
	 */
	void enterCreateDefinitions(OddlGrammarParser.CreateDefinitionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link OddlGrammarParser#createDefinitions}.
	 * @param ctx the parse tree
	 */
	void exitCreateDefinitions(OddlGrammarParser.CreateDefinitionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link OddlGrammarParser#createDefinition}.
	 * @param ctx the parse tree
	 */
	void enterCreateDefinition(OddlGrammarParser.CreateDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link OddlGrammarParser#createDefinition}.
	 * @param ctx the parse tree
	 */
	void exitCreateDefinition(OddlGrammarParser.CreateDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link OddlGrammarParser#createDeputyClass}.
	 * @param ctx the parse tree
	 */
	void enterCreateDeputyClass(OddlGrammarParser.CreateDeputyClassContext ctx);
	/**
	 * Exit a parse tree produced by {@link OddlGrammarParser#createDeputyClass}.
	 * @param ctx the parse tree
	 */
	void exitCreateDeputyClass(OddlGrammarParser.CreateDeputyClassContext ctx);
	/**
	 * Enter a parse tree produced by {@link OddlGrammarParser#dropClass}.
	 * @param ctx the parse tree
	 */
	void enterDropClass(OddlGrammarParser.DropClassContext ctx);
	/**
	 * Exit a parse tree produced by {@link OddlGrammarParser#dropClass}.
	 * @param ctx the parse tree
	 */
	void exitDropClass(OddlGrammarParser.DropClassContext ctx);
	/**
	 * Enter a parse tree produced by {@link OddlGrammarParser#insertIntoClass}.
	 * @param ctx the parse tree
	 */
	void enterInsertIntoClass(OddlGrammarParser.InsertIntoClassContext ctx);
	/**
	 * Exit a parse tree produced by {@link OddlGrammarParser#insertIntoClass}.
	 * @param ctx the parse tree
	 */
	void exitInsertIntoClass(OddlGrammarParser.InsertIntoClassContext ctx);
	/**
	 * Enter a parse tree produced by {@link OddlGrammarParser#valueList}.
	 * @param ctx the parse tree
	 */
	void enterValueList(OddlGrammarParser.ValueListContext ctx);
	/**
	 * Exit a parse tree produced by {@link OddlGrammarParser#valueList}.
	 * @param ctx the parse tree
	 */
	void exitValueList(OddlGrammarParser.ValueListContext ctx);
	/**
	 * Enter a parse tree produced by {@link OddlGrammarParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(OddlGrammarParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link OddlGrammarParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(OddlGrammarParser.ValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link OddlGrammarParser#deleteFromClass}.
	 * @param ctx the parse tree
	 */
	void enterDeleteFromClass(OddlGrammarParser.DeleteFromClassContext ctx);
	/**
	 * Exit a parse tree produced by {@link OddlGrammarParser#deleteFromClass}.
	 * @param ctx the parse tree
	 */
	void exitDeleteFromClass(OddlGrammarParser.DeleteFromClassContext ctx);
	/**
	 * Enter a parse tree produced by {@link OddlGrammarParser#simpleQuery}.
	 * @param ctx the parse tree
	 */
	void enterSimpleQuery(OddlGrammarParser.SimpleQueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link OddlGrammarParser#simpleQuery}.
	 * @param ctx the parse tree
	 */
	void exitSimpleQuery(OddlGrammarParser.SimpleQueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link OddlGrammarParser#crossClassQuery}.
	 * @param ctx the parse tree
	 */
	void enterCrossClassQuery(OddlGrammarParser.CrossClassQueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link OddlGrammarParser#crossClassQuery}.
	 * @param ctx the parse tree
	 */
	void exitCrossClassQuery(OddlGrammarParser.CrossClassQueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link OddlGrammarParser#updateObject}.
	 * @param ctx the parse tree
	 */
	void enterUpdateObject(OddlGrammarParser.UpdateObjectContext ctx);
	/**
	 * Exit a parse tree produced by {@link OddlGrammarParser#updateObject}.
	 * @param ctx the parse tree
	 */
	void exitUpdateObject(OddlGrammarParser.UpdateObjectContext ctx);
	/**
	 * Enter a parse tree produced by {@link OddlGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(OddlGrammarParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link OddlGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(OddlGrammarParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link OddlGrammarParser#emptyStatement}.
	 * @param ctx the parse tree
	 */
	void enterEmptyStatement(OddlGrammarParser.EmptyStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link OddlGrammarParser#emptyStatement}.
	 * @param ctx the parse tree
	 */
	void exitEmptyStatement(OddlGrammarParser.EmptyStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link OddlGrammarParser#sClassName}.
	 * @param ctx the parse tree
	 */
	void enterSClassName(OddlGrammarParser.SClassNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link OddlGrammarParser#sClassName}.
	 * @param ctx the parse tree
	 */
	void exitSClassName(OddlGrammarParser.SClassNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link OddlGrammarParser#sAttr}.
	 * @param ctx the parse tree
	 */
	void enterSAttr(OddlGrammarParser.SAttrContext ctx);
	/**
	 * Exit a parse tree produced by {@link OddlGrammarParser#sAttr}.
	 * @param ctx the parse tree
	 */
	void exitSAttr(OddlGrammarParser.SAttrContext ctx);
	/**
	 * Enter a parse tree produced by {@link OddlGrammarParser#dAttr}.
	 * @param ctx the parse tree
	 */
	void enterDAttr(OddlGrammarParser.DAttrContext ctx);
	/**
	 * Exit a parse tree produced by {@link OddlGrammarParser#dAttr}.
	 * @param ctx the parse tree
	 */
	void exitDAttr(OddlGrammarParser.DAttrContext ctx);
	/**
	 * Enter a parse tree produced by {@link OddlGrammarParser#className}.
	 * @param ctx the parse tree
	 */
	void enterClassName(OddlGrammarParser.ClassNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link OddlGrammarParser#className}.
	 * @param ctx the parse tree
	 */
	void exitClassName(OddlGrammarParser.ClassNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link OddlGrammarParser#attrName}.
	 * @param ctx the parse tree
	 */
	void enterAttrName(OddlGrammarParser.AttrNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link OddlGrammarParser#attrName}.
	 * @param ctx the parse tree
	 */
	void exitAttrName(OddlGrammarParser.AttrNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link OddlGrammarParser#attrList}.
	 * @param ctx the parse tree
	 */
	void enterAttrList(OddlGrammarParser.AttrListContext ctx);
	/**
	 * Exit a parse tree produced by {@link OddlGrammarParser#attrList}.
	 * @param ctx the parse tree
	 */
	void exitAttrList(OddlGrammarParser.AttrListContext ctx);
	/**
	 * Enter a parse tree produced by {@link OddlGrammarParser#dataType}.
	 * @param ctx the parse tree
	 */
	void enterDataType(OddlGrammarParser.DataTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link OddlGrammarParser#dataType}.
	 * @param ctx the parse tree
	 */
	void exitDataType(OddlGrammarParser.DataTypeContext ctx);
}