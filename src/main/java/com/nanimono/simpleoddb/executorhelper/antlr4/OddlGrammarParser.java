package com.nanimono.simpleoddb.executorhelper.antlr4;// Generated from OddlGrammar.g4 by ANTLR 4.7.2

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.ParserATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class OddlGrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, AS=12, CLASS=13, CREATE=14, DELETE=15, DROP=16, FROM=17, 
		INSERT=18, INTO=19, SELECT=20, SELECTDEPUTY=21, UPDATE=22, VALUES=23, 
		SET=24, WHERE=25, BOOLEAN=26, CHAR=27, INT=28, LONG=29, FLOAT=30, TRUE=31, 
		FALSE=32, AND=33, OR=34, NOT=35, DOT=36, LR_BRACKET=37, RR_BRACKET=38, 
		COMMA=39, SEMI=40, EQUAL_SYMBOL=41, GREATER_SYMBOL=42, LESS_SYMBOL=43, 
		SPACE=44, DECIMAL=45, REAL=46, STRING_LITERAL=47, SIGNED_DECIMAL=48, SIGNED_REAL=49, 
		SINGLE_LINE_COMMENT=50, MULTILINE_COMMENT=51, ID=52;
	public static final int
		RULE_root = 0, RULE_oddlStatements = 1, RULE_oddlStatement = 2, RULE_createSourceClass = 3, 
		RULE_createDefinitions = 4, RULE_createDefinition = 5, RULE_createDeputyClass = 6, 
		RULE_dropClass = 7, RULE_insertIntoClass = 8, RULE_valueList = 9, RULE_value = 10, 
		RULE_deleteFromClass = 11, RULE_simpleQuery = 12, RULE_crossClassQuery = 13, 
		RULE_updateObject = 14, RULE_expression = 15, RULE_emptyStatement = 16, 
		RULE_sClassName = 17, RULE_sAttr = 18, RULE_dAttr = 19, RULE_className = 20, 
		RULE_attrName = 21, RULE_attrList = 22, RULE_dataType = 23;
	private static String[] makeRuleNames() {
		return new String[] {
			"root", "oddlStatements", "oddlStatement", "createSourceClass", "createDefinitions", 
			"createDefinition", "createDeputyClass", "dropClass", "insertIntoClass", 
			"valueList", "value", "deleteFromClass", "simpleQuery", "crossClassQuery", 
			"updateObject", "expression", "emptyStatement", "sClassName", "sAttr", 
			"dAttr", "className", "attrName", "attrList", "dataType"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'->'", "'*'", "'/'", "'%'", "'+'", "'-'", "'<='", "'>='", "'=='", 
			"'!='", "'<>'", null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, "'.'", "'('", "')'", "','", "';'", "'='", "'>'", "'<'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			"AS", "CLASS", "CREATE", "DELETE", "DROP", "FROM", "INSERT", "INTO", 
			"SELECT", "SELECTDEPUTY", "UPDATE", "VALUES", "SET", "WHERE", "BOOLEAN", 
			"CHAR", "INT", "LONG", "FLOAT", "TRUE", "FALSE", "AND", "OR", "NOT", 
			"DOT", "LR_BRACKET", "RR_BRACKET", "COMMA", "SEMI", "EQUAL_SYMBOL", "GREATER_SYMBOL", 
			"LESS_SYMBOL", "SPACE", "DECIMAL", "REAL", "STRING_LITERAL", "SIGNED_DECIMAL", 
			"SIGNED_REAL", "SINGLE_LINE_COMMENT", "MULTILINE_COMMENT", "ID"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "OddlGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public OddlGrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class RootContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(OddlGrammarParser.EOF, 0); }
		public OddlStatementsContext oddlStatements() {
			return getRuleContext(OddlStatementsContext.class,0);
		}
		public RootContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_root; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OddlGrammarListener) ((OddlGrammarListener)listener).enterRoot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OddlGrammarListener) ((OddlGrammarListener)listener).exitRoot(this);
		}
	}

	public final RootContext root() throws RecognitionException {
		RootContext _localctx = new RootContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_root);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(49);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CREATE) | (1L << DELETE) | (1L << DROP) | (1L << INSERT) | (1L << SELECT) | (1L << UPDATE) | (1L << SEMI))) != 0)) {
				{
				setState(48);
				oddlStatements();
				}
			}

			setState(51);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OddlStatementsContext extends ParserRuleContext {
		public List<OddlStatementContext> oddlStatement() {
			return getRuleContexts(OddlStatementContext.class);
		}
		public OddlStatementContext oddlStatement(int i) {
			return getRuleContext(OddlStatementContext.class,i);
		}
		public List<TerminalNode> SEMI() { return getTokens(OddlGrammarParser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(OddlGrammarParser.SEMI, i);
		}
		public List<EmptyStatementContext> emptyStatement() {
			return getRuleContexts(EmptyStatementContext.class);
		}
		public EmptyStatementContext emptyStatement(int i) {
			return getRuleContext(EmptyStatementContext.class,i);
		}
		public OddlStatementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oddlStatements; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OddlGrammarListener) ((OddlGrammarListener)listener).enterOddlStatements(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OddlGrammarListener) ((OddlGrammarListener)listener).exitOddlStatements(this);
		}
	}

	public final OddlStatementsContext oddlStatements() throws RecognitionException {
		OddlStatementsContext _localctx = new OddlStatementsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_oddlStatements);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(57);
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(57);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case CREATE:
				case DELETE:
				case DROP:
				case INSERT:
				case SELECT:
				case UPDATE:
					{
					setState(53);
					oddlStatement();
					setState(54);
					match(SEMI);
					}
					break;
				case SEMI:
					{
					setState(56);
					emptyStatement();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(59);
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CREATE) | (1L << DELETE) | (1L << DROP) | (1L << INSERT) | (1L << SELECT) | (1L << UPDATE) | (1L << SEMI))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OddlStatementContext extends ParserRuleContext {
		public CreateSourceClassContext createSourceClass() {
			return getRuleContext(CreateSourceClassContext.class,0);
		}
		public CreateDeputyClassContext createDeputyClass() {
			return getRuleContext(CreateDeputyClassContext.class,0);
		}
		public DropClassContext dropClass() {
			return getRuleContext(DropClassContext.class,0);
		}
		public InsertIntoClassContext insertIntoClass() {
			return getRuleContext(InsertIntoClassContext.class,0);
		}
		public DeleteFromClassContext deleteFromClass() {
			return getRuleContext(DeleteFromClassContext.class,0);
		}
		public SimpleQueryContext simpleQuery() {
			return getRuleContext(SimpleQueryContext.class,0);
		}
		public CrossClassQueryContext crossClassQuery() {
			return getRuleContext(CrossClassQueryContext.class,0);
		}
		public UpdateObjectContext updateObject() {
			return getRuleContext(UpdateObjectContext.class,0);
		}
		public OddlStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oddlStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OddlGrammarListener) ((OddlGrammarListener)listener).enterOddlStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OddlGrammarListener) ((OddlGrammarListener)listener).exitOddlStatement(this);
		}
	}

	public final OddlStatementContext oddlStatement() throws RecognitionException {
		OddlStatementContext _localctx = new OddlStatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_oddlStatement);
		try {
			setState(69);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(61);
				createSourceClass();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(62);
				createDeputyClass();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(63);
				dropClass();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(64);
				insertIntoClass();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(65);
				deleteFromClass();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(66);
				simpleQuery();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(67);
				crossClassQuery();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(68);
				updateObject();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CreateSourceClassContext extends ParserRuleContext {
		public TerminalNode CREATE() { return getToken(OddlGrammarParser.CREATE, 0); }
		public TerminalNode CLASS() { return getToken(OddlGrammarParser.CLASS, 0); }
		public ClassNameContext className() {
			return getRuleContext(ClassNameContext.class,0);
		}
		public CreateDefinitionsContext createDefinitions() {
			return getRuleContext(CreateDefinitionsContext.class,0);
		}
		public CreateSourceClassContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_createSourceClass; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OddlGrammarListener) ((OddlGrammarListener)listener).enterCreateSourceClass(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OddlGrammarListener) ((OddlGrammarListener)listener).exitCreateSourceClass(this);
		}
	}

	public final CreateSourceClassContext createSourceClass() throws RecognitionException {
		CreateSourceClassContext _localctx = new CreateSourceClassContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_createSourceClass);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
			match(CREATE);
			setState(72);
			match(CLASS);
			setState(73);
			className();
			setState(74);
			createDefinitions();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CreateDefinitionsContext extends ParserRuleContext {
		public TerminalNode LR_BRACKET() { return getToken(OddlGrammarParser.LR_BRACKET, 0); }
		public List<CreateDefinitionContext> createDefinition() {
			return getRuleContexts(CreateDefinitionContext.class);
		}
		public CreateDefinitionContext createDefinition(int i) {
			return getRuleContext(CreateDefinitionContext.class,i);
		}
		public TerminalNode RR_BRACKET() { return getToken(OddlGrammarParser.RR_BRACKET, 0); }
		public List<TerminalNode> COMMA() { return getTokens(OddlGrammarParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(OddlGrammarParser.COMMA, i);
		}
		public CreateDefinitionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_createDefinitions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OddlGrammarListener) ((OddlGrammarListener)listener).enterCreateDefinitions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OddlGrammarListener) ((OddlGrammarListener)listener).exitCreateDefinitions(this);
		}
	}

	public final CreateDefinitionsContext createDefinitions() throws RecognitionException {
		CreateDefinitionsContext _localctx = new CreateDefinitionsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_createDefinitions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(76);
			match(LR_BRACKET);
			setState(77);
			createDefinition();
			setState(82);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(78);
				match(COMMA);
				setState(79);
				createDefinition();
				}
				}
				setState(84);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(85);
			match(RR_BRACKET);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CreateDefinitionContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(OddlGrammarParser.ID, 0); }
		public DataTypeContext dataType() {
			return getRuleContext(DataTypeContext.class,0);
		}
		public CreateDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_createDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OddlGrammarListener) ((OddlGrammarListener)listener).enterCreateDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OddlGrammarListener) ((OddlGrammarListener)listener).exitCreateDefinition(this);
		}
	}

	public final CreateDefinitionContext createDefinition() throws RecognitionException {
		CreateDefinitionContext _localctx = new CreateDefinitionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_createDefinition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			match(ID);
			setState(88);
			dataType();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CreateDeputyClassContext extends ParserRuleContext {
		public TerminalNode CREATE() { return getToken(OddlGrammarParser.CREATE, 0); }
		public TerminalNode SELECTDEPUTY() { return getToken(OddlGrammarParser.SELECTDEPUTY, 0); }
		public ClassNameContext className() {
			return getRuleContext(ClassNameContext.class,0);
		}
		public TerminalNode SELECT() { return getToken(OddlGrammarParser.SELECT, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> AS() { return getTokens(OddlGrammarParser.AS); }
		public TerminalNode AS(int i) {
			return getToken(OddlGrammarParser.AS, i);
		}
		public List<DAttrContext> dAttr() {
			return getRuleContexts(DAttrContext.class);
		}
		public DAttrContext dAttr(int i) {
			return getRuleContext(DAttrContext.class,i);
		}
		public TerminalNode FROM() { return getToken(OddlGrammarParser.FROM, 0); }
		public SClassNameContext sClassName() {
			return getRuleContext(SClassNameContext.class,0);
		}
		public TerminalNode WHERE() { return getToken(OddlGrammarParser.WHERE, 0); }
		public List<TerminalNode> COMMA() { return getTokens(OddlGrammarParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(OddlGrammarParser.COMMA, i);
		}
		public CreateDeputyClassContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_createDeputyClass; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OddlGrammarListener) ((OddlGrammarListener)listener).enterCreateDeputyClass(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OddlGrammarListener) ((OddlGrammarListener)listener).exitCreateDeputyClass(this);
		}
	}

	public final CreateDeputyClassContext createDeputyClass() throws RecognitionException {
		CreateDeputyClassContext _localctx = new CreateDeputyClassContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_createDeputyClass);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
			match(CREATE);
			setState(91);
			match(SELECTDEPUTY);
			setState(92);
			className();
			setState(93);
			match(SELECT);
			setState(94);
			expression(0);
			setState(95);
			match(AS);
			setState(96);
			dAttr();
			setState(104);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(97);
				match(COMMA);
				setState(98);
				expression(0);
				setState(99);
				match(AS);
				setState(100);
				dAttr();
				}
				}
				setState(106);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(107);
			match(FROM);
			setState(108);
			sClassName();
			setState(109);
			match(WHERE);
			setState(110);
			expression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DropClassContext extends ParserRuleContext {
		public TerminalNode DROP() { return getToken(OddlGrammarParser.DROP, 0); }
		public TerminalNode CLASS() { return getToken(OddlGrammarParser.CLASS, 0); }
		public ClassNameContext className() {
			return getRuleContext(ClassNameContext.class,0);
		}
		public DropClassContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dropClass; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OddlGrammarListener) ((OddlGrammarListener)listener).enterDropClass(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OddlGrammarListener) ((OddlGrammarListener)listener).exitDropClass(this);
		}
	}

	public final DropClassContext dropClass() throws RecognitionException {
		DropClassContext _localctx = new DropClassContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_dropClass);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(112);
			match(DROP);
			setState(113);
			match(CLASS);
			setState(114);
			className();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InsertIntoClassContext extends ParserRuleContext {
		public TerminalNode INSERT() { return getToken(OddlGrammarParser.INSERT, 0); }
		public TerminalNode INTO() { return getToken(OddlGrammarParser.INTO, 0); }
		public ClassNameContext className() {
			return getRuleContext(ClassNameContext.class,0);
		}
		public TerminalNode VALUES() { return getToken(OddlGrammarParser.VALUES, 0); }
		public ValueListContext valueList() {
			return getRuleContext(ValueListContext.class,0);
		}
		public InsertIntoClassContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_insertIntoClass; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OddlGrammarListener) ((OddlGrammarListener)listener).enterInsertIntoClass(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OddlGrammarListener) ((OddlGrammarListener)listener).exitInsertIntoClass(this);
		}
	}

	public final InsertIntoClassContext insertIntoClass() throws RecognitionException {
		InsertIntoClassContext _localctx = new InsertIntoClassContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_insertIntoClass);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			match(INSERT);
			setState(117);
			match(INTO);
			setState(118);
			className();
			setState(119);
			match(VALUES);
			setState(120);
			valueList();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ValueListContext extends ParserRuleContext {
		public TerminalNode LR_BRACKET() { return getToken(OddlGrammarParser.LR_BRACKET, 0); }
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public TerminalNode RR_BRACKET() { return getToken(OddlGrammarParser.RR_BRACKET, 0); }
		public List<TerminalNode> COMMA() { return getTokens(OddlGrammarParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(OddlGrammarParser.COMMA, i);
		}
		public ValueListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_valueList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OddlGrammarListener) ((OddlGrammarListener)listener).enterValueList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OddlGrammarListener) ((OddlGrammarListener)listener).exitValueList(this);
		}
	}

	public final ValueListContext valueList() throws RecognitionException {
		ValueListContext _localctx = new ValueListContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_valueList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(122);
			match(LR_BRACKET);
			setState(123);
			value();
			setState(128);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(124);
				match(COMMA);
				setState(125);
				value();
				}
				}
				setState(130);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(131);
			match(RR_BRACKET);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ValueContext extends ParserRuleContext {
		public TerminalNode STRING_LITERAL() { return getToken(OddlGrammarParser.STRING_LITERAL, 0); }
		public TerminalNode SIGNED_DECIMAL() { return getToken(OddlGrammarParser.SIGNED_DECIMAL, 0); }
		public TerminalNode DECIMAL() { return getToken(OddlGrammarParser.DECIMAL, 0); }
		public TerminalNode SIGNED_REAL() { return getToken(OddlGrammarParser.SIGNED_REAL, 0); }
		public TerminalNode REAL() { return getToken(OddlGrammarParser.REAL, 0); }
		public TerminalNode TRUE() { return getToken(OddlGrammarParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(OddlGrammarParser.FALSE, 0); }
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OddlGrammarListener) ((OddlGrammarListener)listener).enterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OddlGrammarListener) ((OddlGrammarListener)listener).exitValue(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_value);
		int _la;
		try {
			setState(137);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING_LITERAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(133);
				match(STRING_LITERAL);
				}
				break;
			case DECIMAL:
			case SIGNED_DECIMAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(134);
				_la = _input.LA(1);
				if ( !(_la==DECIMAL || _la==SIGNED_DECIMAL) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case REAL:
			case SIGNED_REAL:
				enterOuterAlt(_localctx, 3);
				{
				setState(135);
				_la = _input.LA(1);
				if ( !(_la==REAL || _la==SIGNED_REAL) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case TRUE:
			case FALSE:
				enterOuterAlt(_localctx, 4);
				{
				setState(136);
				_la = _input.LA(1);
				if ( !(_la==TRUE || _la==FALSE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeleteFromClassContext extends ParserRuleContext {
		public TerminalNode DELETE() { return getToken(OddlGrammarParser.DELETE, 0); }
		public TerminalNode FROM() { return getToken(OddlGrammarParser.FROM, 0); }
		public ClassNameContext className() {
			return getRuleContext(ClassNameContext.class,0);
		}
		public TerminalNode WHERE() { return getToken(OddlGrammarParser.WHERE, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public DeleteFromClassContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_deleteFromClass; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OddlGrammarListener) ((OddlGrammarListener)listener).enterDeleteFromClass(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OddlGrammarListener) ((OddlGrammarListener)listener).exitDeleteFromClass(this);
		}
	}

	public final DeleteFromClassContext deleteFromClass() throws RecognitionException {
		DeleteFromClassContext _localctx = new DeleteFromClassContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_deleteFromClass);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(139);
			match(DELETE);
			setState(140);
			match(FROM);
			setState(141);
			className();
			setState(142);
			match(WHERE);
			setState(143);
			expression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SimpleQueryContext extends ParserRuleContext {
		public TerminalNode SELECT() { return getToken(OddlGrammarParser.SELECT, 0); }
		public AttrListContext attrList() {
			return getRuleContext(AttrListContext.class,0);
		}
		public TerminalNode FROM() { return getToken(OddlGrammarParser.FROM, 0); }
		public ClassNameContext className() {
			return getRuleContext(ClassNameContext.class,0);
		}
		public TerminalNode WHERE() { return getToken(OddlGrammarParser.WHERE, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public SimpleQueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleQuery; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OddlGrammarListener) ((OddlGrammarListener)listener).enterSimpleQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OddlGrammarListener) ((OddlGrammarListener)listener).exitSimpleQuery(this);
		}
	}

	public final SimpleQueryContext simpleQuery() throws RecognitionException {
		SimpleQueryContext _localctx = new SimpleQueryContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_simpleQuery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(145);
			match(SELECT);
			setState(146);
			attrList();
			setState(147);
			match(FROM);
			setState(148);
			className();
			setState(149);
			match(WHERE);
			setState(150);
			expression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CrossClassQueryContext extends ParserRuleContext {
		public TerminalNode SELECT() { return getToken(OddlGrammarParser.SELECT, 0); }
		public List<ClassNameContext> className() {
			return getRuleContexts(ClassNameContext.class);
		}
		public ClassNameContext className(int i) {
			return getRuleContext(ClassNameContext.class,i);
		}
		public TerminalNode DOT() { return getToken(OddlGrammarParser.DOT, 0); }
		public AttrListContext attrList() {
			return getRuleContext(AttrListContext.class,0);
		}
		public TerminalNode FROM() { return getToken(OddlGrammarParser.FROM, 0); }
		public TerminalNode WHERE() { return getToken(OddlGrammarParser.WHERE, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public CrossClassQueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_crossClassQuery; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OddlGrammarListener) ((OddlGrammarListener)listener).enterCrossClassQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OddlGrammarListener) ((OddlGrammarListener)listener).exitCrossClassQuery(this);
		}
	}

	public final CrossClassQueryContext crossClassQuery() throws RecognitionException {
		CrossClassQueryContext _localctx = new CrossClassQueryContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_crossClassQuery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(152);
			match(SELECT);
			setState(153);
			className();
			setState(154);
			match(T__0);
			setState(155);
			className();
			setState(156);
			match(DOT);
			setState(157);
			attrList();
			setState(158);
			match(FROM);
			setState(159);
			className();
			setState(160);
			match(WHERE);
			setState(161);
			expression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UpdateObjectContext extends ParserRuleContext {
		public TerminalNode UPDATE() { return getToken(OddlGrammarParser.UPDATE, 0); }
		public ClassNameContext className() {
			return getRuleContext(ClassNameContext.class,0);
		}
		public TerminalNode SET() { return getToken(OddlGrammarParser.SET, 0); }
		public List<AttrNameContext> attrName() {
			return getRuleContexts(AttrNameContext.class);
		}
		public AttrNameContext attrName(int i) {
			return getRuleContext(AttrNameContext.class,i);
		}
		public List<TerminalNode> EQUAL_SYMBOL() { return getTokens(OddlGrammarParser.EQUAL_SYMBOL); }
		public TerminalNode EQUAL_SYMBOL(int i) {
			return getToken(OddlGrammarParser.EQUAL_SYMBOL, i);
		}
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public TerminalNode WHERE() { return getToken(OddlGrammarParser.WHERE, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<TerminalNode> COMMA() { return getTokens(OddlGrammarParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(OddlGrammarParser.COMMA, i);
		}
		public UpdateObjectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_updateObject; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OddlGrammarListener) ((OddlGrammarListener)listener).enterUpdateObject(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OddlGrammarListener) ((OddlGrammarListener)listener).exitUpdateObject(this);
		}
	}

	public final UpdateObjectContext updateObject() throws RecognitionException {
		UpdateObjectContext _localctx = new UpdateObjectContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_updateObject);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(163);
			match(UPDATE);
			setState(164);
			className();
			setState(165);
			match(SET);
			setState(166);
			attrName();
			setState(167);
			match(EQUAL_SYMBOL);
			setState(168);
			value();
			setState(176);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(169);
				match(COMMA);
				setState(170);
				attrName();
				setState(171);
				match(EQUAL_SYMBOL);
				setState(172);
				value();
				}
				}
				setState(178);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(179);
			match(WHERE);
			setState(180);
			expression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public Token op;
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public AttrNameContext attrName() {
			return getRuleContext(AttrNameContext.class,0);
		}
		public TerminalNode LR_BRACKET() { return getToken(OddlGrammarParser.LR_BRACKET, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode RR_BRACKET() { return getToken(OddlGrammarParser.RR_BRACKET, 0); }
		public TerminalNode LESS_SYMBOL() { return getToken(OddlGrammarParser.LESS_SYMBOL, 0); }
		public TerminalNode GREATER_SYMBOL() { return getToken(OddlGrammarParser.GREATER_SYMBOL, 0); }
		public TerminalNode EQUAL_SYMBOL() { return getToken(OddlGrammarParser.EQUAL_SYMBOL, 0); }
		public TerminalNode AND() { return getToken(OddlGrammarParser.AND, 0); }
		public TerminalNode OR() { return getToken(OddlGrammarParser.OR, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OddlGrammarListener) ((OddlGrammarListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OddlGrammarListener) ((OddlGrammarListener)listener).exitExpression(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 30;
		enterRecursionRule(_localctx, 30, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(189);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TRUE:
			case FALSE:
			case DECIMAL:
			case REAL:
			case STRING_LITERAL:
			case SIGNED_DECIMAL:
			case SIGNED_REAL:
				{
				setState(183);
				value();
				}
				break;
			case ID:
				{
				setState(184);
				attrName();
				}
				break;
			case LR_BRACKET:
				{
				setState(185);
				match(LR_BRACKET);
				setState(186);
				expression(0);
				setState(187);
				match(RR_BRACKET);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(211);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(209);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(191);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(192);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__2) | (1L << T__3))) != 0)) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(193);
						expression(8);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(194);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(195);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__4 || _la==T__5) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(196);
						expression(7);
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(197);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(198);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__7) | (1L << GREATER_SYMBOL) | (1L << LESS_SYMBOL))) != 0)) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(199);
						expression(6);
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(200);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(201);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << EQUAL_SYMBOL))) != 0)) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(202);
						expression(5);
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(203);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(204);
						match(AND);
						setState(205);
						expression(4);
						}
						break;
					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(206);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(207);
						match(OR);
						setState(208);
						expression(3);
						}
						break;
					}
					}
				}
				setState(213);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class EmptyStatementContext extends ParserRuleContext {
		public TerminalNode SEMI() { return getToken(OddlGrammarParser.SEMI, 0); }
		public EmptyStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_emptyStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OddlGrammarListener) ((OddlGrammarListener)listener).enterEmptyStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OddlGrammarListener) ((OddlGrammarListener)listener).exitEmptyStatement(this);
		}
	}

	public final EmptyStatementContext emptyStatement() throws RecognitionException {
		EmptyStatementContext _localctx = new EmptyStatementContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_emptyStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(214);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SClassNameContext extends ParserRuleContext {
		public ClassNameContext className() {
			return getRuleContext(ClassNameContext.class,0);
		}
		public SClassNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sClassName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OddlGrammarListener) ((OddlGrammarListener)listener).enterSClassName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OddlGrammarListener) ((OddlGrammarListener)listener).exitSClassName(this);
		}
	}

	public final SClassNameContext sClassName() throws RecognitionException {
		SClassNameContext _localctx = new SClassNameContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_sClassName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(216);
			className();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SAttrContext extends ParserRuleContext {
		public AttrNameContext attrName() {
			return getRuleContext(AttrNameContext.class,0);
		}
		public SAttrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sAttr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OddlGrammarListener) ((OddlGrammarListener)listener).enterSAttr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OddlGrammarListener) ((OddlGrammarListener)listener).exitSAttr(this);
		}
	}

	public final SAttrContext sAttr() throws RecognitionException {
		SAttrContext _localctx = new SAttrContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_sAttr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(218);
			attrName();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DAttrContext extends ParserRuleContext {
		public AttrNameContext attrName() {
			return getRuleContext(AttrNameContext.class,0);
		}
		public DAttrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dAttr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OddlGrammarListener) ((OddlGrammarListener)listener).enterDAttr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OddlGrammarListener) ((OddlGrammarListener)listener).exitDAttr(this);
		}
	}

	public final DAttrContext dAttr() throws RecognitionException {
		DAttrContext _localctx = new DAttrContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_dAttr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(220);
			attrName();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassNameContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(OddlGrammarParser.ID, 0); }
		public ClassNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_className; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OddlGrammarListener) ((OddlGrammarListener)listener).enterClassName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OddlGrammarListener) ((OddlGrammarListener)listener).exitClassName(this);
		}
	}

	public final ClassNameContext className() throws RecognitionException {
		ClassNameContext _localctx = new ClassNameContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_className);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(222);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AttrNameContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(OddlGrammarParser.ID, 0); }
		public AttrNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attrName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OddlGrammarListener) ((OddlGrammarListener)listener).enterAttrName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OddlGrammarListener) ((OddlGrammarListener)listener).exitAttrName(this);
		}
	}

	public final AttrNameContext attrName() throws RecognitionException {
		AttrNameContext _localctx = new AttrNameContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_attrName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(224);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AttrListContext extends ParserRuleContext {
		public List<AttrNameContext> attrName() {
			return getRuleContexts(AttrNameContext.class);
		}
		public AttrNameContext attrName(int i) {
			return getRuleContext(AttrNameContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(OddlGrammarParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(OddlGrammarParser.COMMA, i);
		}
		public AttrListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attrList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OddlGrammarListener) ((OddlGrammarListener)listener).enterAttrList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OddlGrammarListener) ((OddlGrammarListener)listener).exitAttrList(this);
		}
	}

	public final AttrListContext attrList() throws RecognitionException {
		AttrListContext _localctx = new AttrListContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_attrList);
		int _la;
		try {
			setState(235);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(226);
				attrName();
				setState(231);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(227);
					match(COMMA);
					setState(228);
					attrName();
					}
					}
					setState(233);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 2);
				{
				setState(234);
				match(T__1);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DataTypeContext extends ParserRuleContext {
		public Token typeName;
		public TerminalNode CHAR() { return getToken(OddlGrammarParser.CHAR, 0); }
		public TerminalNode LR_BRACKET() { return getToken(OddlGrammarParser.LR_BRACKET, 0); }
		public TerminalNode DECIMAL() { return getToken(OddlGrammarParser.DECIMAL, 0); }
		public TerminalNode RR_BRACKET() { return getToken(OddlGrammarParser.RR_BRACKET, 0); }
		public TerminalNode INT() { return getToken(OddlGrammarParser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(OddlGrammarParser.FLOAT, 0); }
		public TerminalNode BOOLEAN() { return getToken(OddlGrammarParser.BOOLEAN, 0); }
		public DataTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dataType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OddlGrammarListener) ((OddlGrammarListener)listener).enterDataType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OddlGrammarListener) ((OddlGrammarListener)listener).exitDataType(this);
		}
	}

	public final DataTypeContext dataType() throws RecognitionException {
		DataTypeContext _localctx = new DataTypeContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_dataType);
		int _la;
		try {
			setState(244);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CHAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(237);
				match(CHAR);
				setState(241);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LR_BRACKET) {
					{
					setState(238);
					match(LR_BRACKET);
					setState(239);
					match(DECIMAL);
					setState(240);
					match(RR_BRACKET);
					}
				}

				}
				break;
			case BOOLEAN:
			case INT:
			case FLOAT:
				enterOuterAlt(_localctx, 2);
				{
				setState(243);
				((DataTypeContext)_localctx).typeName = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << INT) | (1L << FLOAT))) != 0)) ) {
					((DataTypeContext)_localctx).typeName = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 15:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 7);
		case 1:
			return precpred(_ctx, 6);
		case 2:
			return precpred(_ctx, 5);
		case 3:
			return precpred(_ctx, 4);
		case 4:
			return precpred(_ctx, 3);
		case 5:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\66\u00f9\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\3\2\5\2\64\n\2\3\2\3\2\3\3\3\3\3\3\3\3\6\3<\n\3\r\3\16\3=\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\5\4H\n\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\7\6"+
		"S\n\6\f\6\16\6V\13\6\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\7\bi\n\b\f\b\16\bl\13\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t"+
		"\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\7\13\u0081\n\13\f"+
		"\13\16\13\u0084\13\13\3\13\3\13\3\f\3\f\3\f\3\f\5\f\u008c\n\f\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\7\20\u00b1\n\20\f\20\16\20\u00b4\13\20\3\20\3\20"+
		"\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u00c0\n\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\7\21\u00d4\n\21\f\21\16\21\u00d7\13\21\3\22\3\22\3\23\3\23\3\24"+
		"\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\30\7\30\u00e8\n\30\f\30"+
		"\16\30\u00eb\13\30\3\30\5\30\u00ee\n\30\3\31\3\31\3\31\3\31\5\31\u00f4"+
		"\n\31\3\31\5\31\u00f7\n\31\3\31\2\3 \32\2\4\6\b\n\f\16\20\22\24\26\30"+
		"\32\34\36 \"$&(*,.\60\2\n\4\2//\62\62\4\2\60\60\63\63\3\2!\"\3\2\4\6\3"+
		"\2\7\b\4\2\t\n,-\4\2\13\r++\5\2\34\34\36\36  \2\u00fd\2\63\3\2\2\2\4;"+
		"\3\2\2\2\6G\3\2\2\2\bI\3\2\2\2\nN\3\2\2\2\fY\3\2\2\2\16\\\3\2\2\2\20r"+
		"\3\2\2\2\22v\3\2\2\2\24|\3\2\2\2\26\u008b\3\2\2\2\30\u008d\3\2\2\2\32"+
		"\u0093\3\2\2\2\34\u009a\3\2\2\2\36\u00a5\3\2\2\2 \u00bf\3\2\2\2\"\u00d8"+
		"\3\2\2\2$\u00da\3\2\2\2&\u00dc\3\2\2\2(\u00de\3\2\2\2*\u00e0\3\2\2\2,"+
		"\u00e2\3\2\2\2.\u00ed\3\2\2\2\60\u00f6\3\2\2\2\62\64\5\4\3\2\63\62\3\2"+
		"\2\2\63\64\3\2\2\2\64\65\3\2\2\2\65\66\7\2\2\3\66\3\3\2\2\2\678\5\6\4"+
		"\289\7*\2\29<\3\2\2\2:<\5\"\22\2;\67\3\2\2\2;:\3\2\2\2<=\3\2\2\2=;\3\2"+
		"\2\2=>\3\2\2\2>\5\3\2\2\2?H\5\b\5\2@H\5\16\b\2AH\5\20\t\2BH\5\22\n\2C"+
		"H\5\30\r\2DH\5\32\16\2EH\5\34\17\2FH\5\36\20\2G?\3\2\2\2G@\3\2\2\2GA\3"+
		"\2\2\2GB\3\2\2\2GC\3\2\2\2GD\3\2\2\2GE\3\2\2\2GF\3\2\2\2H\7\3\2\2\2IJ"+
		"\7\20\2\2JK\7\17\2\2KL\5*\26\2LM\5\n\6\2M\t\3\2\2\2NO\7\'\2\2OT\5\f\7"+
		"\2PQ\7)\2\2QS\5\f\7\2RP\3\2\2\2SV\3\2\2\2TR\3\2\2\2TU\3\2\2\2UW\3\2\2"+
		"\2VT\3\2\2\2WX\7(\2\2X\13\3\2\2\2YZ\7\66\2\2Z[\5\60\31\2[\r\3\2\2\2\\"+
		"]\7\20\2\2]^\7\27\2\2^_\5*\26\2_`\7\26\2\2`a\5 \21\2ab\7\16\2\2bj\5(\25"+
		"\2cd\7)\2\2de\5 \21\2ef\7\16\2\2fg\5(\25\2gi\3\2\2\2hc\3\2\2\2il\3\2\2"+
		"\2jh\3\2\2\2jk\3\2\2\2km\3\2\2\2lj\3\2\2\2mn\7\23\2\2no\5$\23\2op\7\33"+
		"\2\2pq\5 \21\2q\17\3\2\2\2rs\7\22\2\2st\7\17\2\2tu\5*\26\2u\21\3\2\2\2"+
		"vw\7\24\2\2wx\7\25\2\2xy\5*\26\2yz\7\31\2\2z{\5\24\13\2{\23\3\2\2\2|}"+
		"\7\'\2\2}\u0082\5\26\f\2~\177\7)\2\2\177\u0081\5\26\f\2\u0080~\3\2\2\2"+
		"\u0081\u0084\3\2\2\2\u0082\u0080\3\2\2\2\u0082\u0083\3\2\2\2\u0083\u0085"+
		"\3\2\2\2\u0084\u0082\3\2\2\2\u0085\u0086\7(\2\2\u0086\25\3\2\2\2\u0087"+
		"\u008c\7\61\2\2\u0088\u008c\t\2\2\2\u0089\u008c\t\3\2\2\u008a\u008c\t"+
		"\4\2\2\u008b\u0087\3\2\2\2\u008b\u0088\3\2\2\2\u008b\u0089\3\2\2\2\u008b"+
		"\u008a\3\2\2\2\u008c\27\3\2\2\2\u008d\u008e\7\21\2\2\u008e\u008f\7\23"+
		"\2\2\u008f\u0090\5*\26\2\u0090\u0091\7\33\2\2\u0091\u0092\5 \21\2\u0092"+
		"\31\3\2\2\2\u0093\u0094\7\26\2\2\u0094\u0095\5.\30\2\u0095\u0096\7\23"+
		"\2\2\u0096\u0097\5*\26\2\u0097\u0098\7\33\2\2\u0098\u0099\5 \21\2\u0099"+
		"\33\3\2\2\2\u009a\u009b\7\26\2\2\u009b\u009c\5*\26\2\u009c\u009d\7\3\2"+
		"\2\u009d\u009e\5*\26\2\u009e\u009f\7&\2\2\u009f\u00a0\5.\30\2\u00a0\u00a1"+
		"\7\23\2\2\u00a1\u00a2\5*\26\2\u00a2\u00a3\7\33\2\2\u00a3\u00a4\5 \21\2"+
		"\u00a4\35\3\2\2\2\u00a5\u00a6\7\30\2\2\u00a6\u00a7\5*\26\2\u00a7\u00a8"+
		"\7\32\2\2\u00a8\u00a9\5,\27\2\u00a9\u00aa\7+\2\2\u00aa\u00b2\5\26\f\2"+
		"\u00ab\u00ac\7)\2\2\u00ac\u00ad\5,\27\2\u00ad\u00ae\7+\2\2\u00ae\u00af"+
		"\5\26\f\2\u00af\u00b1\3\2\2\2\u00b0\u00ab\3\2\2\2\u00b1\u00b4\3\2\2\2"+
		"\u00b2\u00b0\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3\u00b5\3\2\2\2\u00b4\u00b2"+
		"\3\2\2\2\u00b5\u00b6\7\33\2\2\u00b6\u00b7\5 \21\2\u00b7\37\3\2\2\2\u00b8"+
		"\u00b9\b\21\1\2\u00b9\u00c0\5\26\f\2\u00ba\u00c0\5,\27\2\u00bb\u00bc\7"+
		"\'\2\2\u00bc\u00bd\5 \21\2\u00bd\u00be\7(\2\2\u00be\u00c0\3\2\2\2\u00bf"+
		"\u00b8\3\2\2\2\u00bf\u00ba\3\2\2\2\u00bf\u00bb\3\2\2\2\u00c0\u00d5\3\2"+
		"\2\2\u00c1\u00c2\f\t\2\2\u00c2\u00c3\t\5\2\2\u00c3\u00d4\5 \21\n\u00c4"+
		"\u00c5\f\b\2\2\u00c5\u00c6\t\6\2\2\u00c6\u00d4\5 \21\t\u00c7\u00c8\f\7"+
		"\2\2\u00c8\u00c9\t\7\2\2\u00c9\u00d4\5 \21\b\u00ca\u00cb\f\6\2\2\u00cb"+
		"\u00cc\t\b\2\2\u00cc\u00d4\5 \21\7\u00cd\u00ce\f\5\2\2\u00ce\u00cf\7#"+
		"\2\2\u00cf\u00d4\5 \21\6\u00d0\u00d1\f\4\2\2\u00d1\u00d2\7$\2\2\u00d2"+
		"\u00d4\5 \21\5\u00d3\u00c1\3\2\2\2\u00d3\u00c4\3\2\2\2\u00d3\u00c7\3\2"+
		"\2\2\u00d3\u00ca\3\2\2\2\u00d3\u00cd\3\2\2\2\u00d3\u00d0\3\2\2\2\u00d4"+
		"\u00d7\3\2\2\2\u00d5\u00d3\3\2\2\2\u00d5\u00d6\3\2\2\2\u00d6!\3\2\2\2"+
		"\u00d7\u00d5\3\2\2\2\u00d8\u00d9\7*\2\2\u00d9#\3\2\2\2\u00da\u00db\5*"+
		"\26\2\u00db%\3\2\2\2\u00dc\u00dd\5,\27\2\u00dd\'\3\2\2\2\u00de\u00df\5"+
		",\27\2\u00df)\3\2\2\2\u00e0\u00e1\7\66\2\2\u00e1+\3\2\2\2\u00e2\u00e3"+
		"\7\66\2\2\u00e3-\3\2\2\2\u00e4\u00e9\5,\27\2\u00e5\u00e6\7)\2\2\u00e6"+
		"\u00e8\5,\27\2\u00e7\u00e5\3\2\2\2\u00e8\u00eb\3\2\2\2\u00e9\u00e7\3\2"+
		"\2\2\u00e9\u00ea\3\2\2\2\u00ea\u00ee\3\2\2\2\u00eb\u00e9\3\2\2\2\u00ec"+
		"\u00ee\7\4\2\2\u00ed\u00e4\3\2\2\2\u00ed\u00ec\3\2\2\2\u00ee/\3\2\2\2"+
		"\u00ef\u00f3\7\35\2\2\u00f0\u00f1\7\'\2\2\u00f1\u00f2\7/\2\2\u00f2\u00f4"+
		"\7(\2\2\u00f3\u00f0\3\2\2\2\u00f3\u00f4\3\2\2\2\u00f4\u00f7\3\2\2\2\u00f5"+
		"\u00f7\t\t\2\2\u00f6\u00ef\3\2\2\2\u00f6\u00f5\3\2\2\2\u00f7\61\3\2\2"+
		"\2\22\63;=GTj\u0082\u008b\u00b2\u00bf\u00d3\u00d5\u00e9\u00ed\u00f3\u00f6";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}