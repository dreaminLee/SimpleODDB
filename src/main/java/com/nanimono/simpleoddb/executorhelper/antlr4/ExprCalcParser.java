package com.nanimono.simpleoddb.executorhelper.antlr4;// Generated from ExprCalc.g4 by ANTLR 4.7.2

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
public class ExprCalcParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, DECIMAL=3, SIGNED_DECIMAL=4, REAL=5, SIGNED_REAL=6, STRING_LITERAL=7, 
		MOD=8, MUL=9, DIV=10, ADD=11, SUB=12, GREATER=13, LESS=14, GREATER_OR_EQUAL=15, 
		LESS_OR_EQUAL=16, EQUAL=17, NOT_EQUAL=18, AND=19, OR=20, TRUE=21, FALSE=22, 
		ID=23, WS=24;
	public static final int
		RULE_expression = 0, RULE_value = 1;
	private static String[] makeRuleNames() {
		return new String[] {
			"expression", "value"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", null, null, null, null, null, "'%'", "'*'", "'/'", 
			"'+'", "'-'", "'>'", "'<'", "'>='", "'<='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, "DECIMAL", "SIGNED_DECIMAL", "REAL", "SIGNED_REAL", 
			"STRING_LITERAL", "MOD", "MUL", "DIV", "ADD", "SUB", "GREATER", "LESS", 
			"GREATER_OR_EQUAL", "LESS_OR_EQUAL", "EQUAL", "NOT_EQUAL", "AND", "OR", 
			"TRUE", "FALSE", "ID", "WS"
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
	public String getGrammarFileName() { return "ExprCalc.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ExprCalcParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class MUL_DIVContext extends ExpressionContext {
		public Token op;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode MUL() { return getToken(ExprCalcParser.MUL, 0); }
		public TerminalNode DIV() { return getToken(ExprCalcParser.DIV, 0); }
		public MUL_DIVContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprCalcListener) ((ExprCalcListener)listener).enterMUL_DIV(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprCalcListener) ((ExprCalcListener)listener).exitMUL_DIV(this);
		}
	}
	public static class GREATER_LESSContext extends ExpressionContext {
		public Token op;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode GREATER() { return getToken(ExprCalcParser.GREATER, 0); }
		public TerminalNode GREATER_OR_EQUAL() { return getToken(ExprCalcParser.GREATER_OR_EQUAL, 0); }
		public TerminalNode LESS() { return getToken(ExprCalcParser.LESS, 0); }
		public TerminalNode LESS_OR_EQUAL() { return getToken(ExprCalcParser.LESS_OR_EQUAL, 0); }
		public GREATER_LESSContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprCalcListener) ((ExprCalcListener)listener).enterGREATER_LESS(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprCalcListener) ((ExprCalcListener)listener).exitGREATER_LESS(this);
		}
	}
	public static class ConstantContext extends ExpressionContext {
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public ConstantContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprCalcListener) ((ExprCalcListener)listener).enterConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprCalcListener) ((ExprCalcListener)listener).exitConstant(this);
		}
	}
	public static class BRACKETContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public BRACKETContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprCalcListener) ((ExprCalcListener)listener).enterBRACKET(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprCalcListener) ((ExprCalcListener)listener).exitBRACKET(this);
		}
	}
	public static class VarContext extends ExpressionContext {
		public TerminalNode ID() { return getToken(ExprCalcParser.ID, 0); }
		public VarContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprCalcListener) ((ExprCalcListener)listener).enterVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprCalcListener) ((ExprCalcListener)listener).exitVar(this);
		}
	}
	public static class MOD_Context extends ExpressionContext {
		public Token op;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode MOD() { return getToken(ExprCalcParser.MOD, 0); }
		public MOD_Context(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprCalcListener) ((ExprCalcListener)listener).enterMOD_(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprCalcListener) ((ExprCalcListener)listener).exitMOD_(this);
		}
	}
	public static class ADD_SUBContext extends ExpressionContext {
		public Token op;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode ADD() { return getToken(ExprCalcParser.ADD, 0); }
		public TerminalNode SUB() { return getToken(ExprCalcParser.SUB, 0); }
		public ADD_SUBContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprCalcListener) ((ExprCalcListener)listener).enterADD_SUB(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprCalcListener) ((ExprCalcListener)listener).exitADD_SUB(this);
		}
	}
	public static class LOGICContext extends ExpressionContext {
		public Token op;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode AND() { return getToken(ExprCalcParser.AND, 0); }
		public TerminalNode OR() { return getToken(ExprCalcParser.OR, 0); }
		public LOGICContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprCalcListener) ((ExprCalcListener)listener).enterLOGIC(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprCalcListener) ((ExprCalcListener)listener).exitLOGIC(this);
		}
	}
	public static class EQUAL_ORNOTContext extends ExpressionContext {
		public Token op;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode EQUAL() { return getToken(ExprCalcParser.EQUAL, 0); }
		public TerminalNode NOT_EQUAL() { return getToken(ExprCalcParser.NOT_EQUAL, 0); }
		public EQUAL_ORNOTContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprCalcListener) ((ExprCalcListener)listener).enterEQUAL_ORNOT(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprCalcListener) ((ExprCalcListener)listener).exitEQUAL_ORNOT(this);
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
		int _startState = 0;
		enterRecursionRule(_localctx, 0, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(11);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DECIMAL:
			case SIGNED_DECIMAL:
			case REAL:
			case SIGNED_REAL:
			case STRING_LITERAL:
			case TRUE:
			case FALSE:
				{
				_localctx = new ConstantContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(5);
				value();
				}
				break;
			case ID:
				{
				_localctx = new VarContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(6);
				match(ID);
				}
				break;
			case T__0:
				{
				_localctx = new BRACKETContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(7);
				match(T__0);
				setState(8);
				expression(0);
				setState(9);
				match(T__1);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(36);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(34);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
					case 1:
						{
						_localctx = new MOD_Context(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(13);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(14);
						((MOD_Context)_localctx).op = match(MOD);
						setState(15);
						expression(11);
						}
						break;
					case 2:
						{
						_localctx = new MUL_DIVContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(16);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(17);
						((MUL_DIVContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==MUL || _la==DIV) ) {
							((MUL_DIVContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(18);
						expression(10);
						}
						break;
					case 3:
						{
						_localctx = new ADD_SUBContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(19);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(20);
						((ADD_SUBContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
							((ADD_SUBContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(21);
						expression(9);
						}
						break;
					case 4:
						{
						_localctx = new GREATER_LESSContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(22);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(23);
						((GREATER_LESSContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GREATER) | (1L << LESS) | (1L << GREATER_OR_EQUAL) | (1L << LESS_OR_EQUAL))) != 0)) ) {
							((GREATER_LESSContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(24);
						expression(8);
						}
						break;
					case 5:
						{
						_localctx = new EQUAL_ORNOTContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(25);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(26);
						((EQUAL_ORNOTContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==EQUAL || _la==NOT_EQUAL) ) {
							((EQUAL_ORNOTContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(27);
						expression(7);
						}
						break;
					case 6:
						{
						_localctx = new LOGICContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(28);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(29);
						((LOGICContext)_localctx).op = match(AND);
						setState(30);
						expression(6);
						}
						break;
					case 7:
						{
						_localctx = new LOGICContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(31);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(32);
						((LOGICContext)_localctx).op = match(OR);
						setState(33);
						expression(5);
						}
						break;
					}
					}
				}
				setState(38);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
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

	public static class ValueContext extends ParserRuleContext {
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }

		public ValueContext() { }
		public void copyFrom(ValueContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FLOATContext extends ValueContext {
		public TerminalNode SIGNED_REAL() { return getToken(ExprCalcParser.SIGNED_REAL, 0); }
		public TerminalNode REAL() { return getToken(ExprCalcParser.REAL, 0); }
		public FLOATContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprCalcListener) ((ExprCalcListener)listener).enterFLOAT(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprCalcListener) ((ExprCalcListener)listener).exitFLOAT(this);
		}
	}
	public static class BOOLContext extends ValueContext {
		public TerminalNode TRUE() { return getToken(ExprCalcParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(ExprCalcParser.FALSE, 0); }
		public BOOLContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprCalcListener) ((ExprCalcListener)listener).enterBOOL(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprCalcListener) ((ExprCalcListener)listener).exitBOOL(this);
		}
	}
	public static class CHARContext extends ValueContext {
		public TerminalNode STRING_LITERAL() { return getToken(ExprCalcParser.STRING_LITERAL, 0); }
		public CHARContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprCalcListener) ((ExprCalcListener)listener).enterCHAR(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprCalcListener) ((ExprCalcListener)listener).exitCHAR(this);
		}
	}
	public static class INTContext extends ValueContext {
		public TerminalNode SIGNED_DECIMAL() { return getToken(ExprCalcParser.SIGNED_DECIMAL, 0); }
		public TerminalNode DECIMAL() { return getToken(ExprCalcParser.DECIMAL, 0); }
		public INTContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprCalcListener) ((ExprCalcListener)listener).enterINT(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprCalcListener) ((ExprCalcListener)listener).exitINT(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_value);
		int _la;
		try {
			setState(43);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TRUE:
			case FALSE:
				_localctx = new BOOLContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(39);
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
			case STRING_LITERAL:
				_localctx = new CHARContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(40);
				match(STRING_LITERAL);
				}
				break;
			case DECIMAL:
			case SIGNED_DECIMAL:
				_localctx = new INTContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(41);
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
				_localctx = new FLOATContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(42);
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
		case 0:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 10);
		case 1:
			return precpred(_ctx, 9);
		case 2:
			return precpred(_ctx, 8);
		case 3:
			return precpred(_ctx, 7);
		case 4:
			return precpred(_ctx, 6);
		case 5:
			return precpred(_ctx, 5);
		case 6:
			return precpred(_ctx, 4);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\32\60\4\2\t\2\4\3"+
		"\t\3\3\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2\16\n\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\7\2%\n\2\f"+
		"\2\16\2(\13\2\3\3\3\3\3\3\3\3\5\3.\n\3\3\3\2\3\2\4\2\4\2\t\3\2\13\f\3"+
		"\2\r\16\3\2\17\22\3\2\23\24\3\2\27\30\3\2\5\6\3\2\7\b\29\2\r\3\2\2\2\4"+
		"-\3\2\2\2\6\7\b\2\1\2\7\16\5\4\3\2\b\16\7\31\2\2\t\n\7\3\2\2\n\13\5\2"+
		"\2\2\13\f\7\4\2\2\f\16\3\2\2\2\r\6\3\2\2\2\r\b\3\2\2\2\r\t\3\2\2\2\16"+
		"&\3\2\2\2\17\20\f\f\2\2\20\21\7\n\2\2\21%\5\2\2\r\22\23\f\13\2\2\23\24"+
		"\t\2\2\2\24%\5\2\2\f\25\26\f\n\2\2\26\27\t\3\2\2\27%\5\2\2\13\30\31\f"+
		"\t\2\2\31\32\t\4\2\2\32%\5\2\2\n\33\34\f\b\2\2\34\35\t\5\2\2\35%\5\2\2"+
		"\t\36\37\f\7\2\2\37 \7\25\2\2 %\5\2\2\b!\"\f\6\2\2\"#\7\26\2\2#%\5\2\2"+
		"\7$\17\3\2\2\2$\22\3\2\2\2$\25\3\2\2\2$\30\3\2\2\2$\33\3\2\2\2$\36\3\2"+
		"\2\2$!\3\2\2\2%(\3\2\2\2&$\3\2\2\2&\'\3\2\2\2\'\3\3\2\2\2(&\3\2\2\2)."+
		"\t\6\2\2*.\7\t\2\2+.\t\7\2\2,.\t\b\2\2-)\3\2\2\2-*\3\2\2\2-+\3\2\2\2-"+
		",\3\2\2\2.\5\3\2\2\2\6\r$&-";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}