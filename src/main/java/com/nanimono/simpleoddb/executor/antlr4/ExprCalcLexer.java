package com.nanimono.simpleoddb.executor.antlr4;// Generated from ExprCalc.g4 by ANTLR 4.7.2

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.LexerATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ExprCalcLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, ID=3, DECIMAL=4, SIGNED_DECIMAL=5, REAL=6, SIGNED_REAL=7, 
		STRING_LITERAL=8, ADD=9, SUB=10, MUL=11, DIV=12, MOD=13, EQUAL=14, NOT_EQUAL=15, 
		GREATER=16, LESS=17, GREATER_OR_EQUAL=18, LESS_OR_EQUAL=19, AND=20, OR=21, 
		TRUE=22, FALSE=23, WS=24;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "ID", "DECIMAL", "SIGNED_DECIMAL", "REAL", "SIGNED_REAL", 
			"STRING_LITERAL", "ADD", "SUB", "MUL", "DIV", "MOD", "EQUAL", "NOT_EQUAL", 
			"GREATER", "LESS", "GREATER_OR_EQUAL", "LESS_OR_EQUAL", "AND", "OR", 
			"TRUE", "FALSE", "WS", "DEC_DIGIT", "A", "B", "C", "D", "E", "F", "G", 
			"H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", 
			"V", "W", "X", "Y", "Z"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", null, null, null, null, null, null, "'+'", "'-'", 
			"'*'", "'/'", "'%'", null, null, "'>'", "'<'", "'>='", "'<='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, "ID", "DECIMAL", "SIGNED_DECIMAL", "REAL", "SIGNED_REAL", 
			"STRING_LITERAL", "ADD", "SUB", "MUL", "DIV", "MOD", "EQUAL", "NOT_EQUAL", 
			"GREATER", "LESS", "GREATER_OR_EQUAL", "LESS_OR_EQUAL", "AND", "OR", 
			"TRUE", "FALSE", "WS"
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


	public ExprCalcLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "ExprCalc.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\32\u0107\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\3\2\3\2\3\3\3\3\3\4\3\4\7\4p\n\4\f\4\16\4s\13\4\3\5\6\5v\n\5\r\5"+
		"\16\5w\3\6\5\6{\n\6\3\6\3\6\3\7\6\7\u0080\n\7\r\7\16\7\u0081\3\7\3\7\6"+
		"\7\u0086\n\7\r\7\16\7\u0087\3\b\5\b\u008b\n\b\3\b\3\b\3\t\3\t\3\t\3\t"+
		"\7\t\u0093\n\t\f\t\16\t\u0096\13\t\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3"+
		"\r\3\r\3\16\3\16\3\17\3\17\3\17\5\17\u00a7\n\17\3\20\3\20\3\20\3\20\5"+
		"\20\u00ad\n\20\3\21\3\21\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3\24\3\25"+
		"\3\25\3\25\3\25\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\31\6\31\u00cc\n\31\r\31\16\31\u00cd\3\31\3\31\3\32\3"+
		"\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\""+
		"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3+\3,\3,\3-"+
		"\3-\3.\3.\3/\3/\3\60\3\60\3\61\3\61\3\62\3\62\3\63\3\63\3\64\3\64\2\2"+
		"\65\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35"+
		"\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\2\65\2\67\29\2;\2"+
		"=\2?\2A\2C\2E\2G\2I\2K\2M\2O\2Q\2S\2U\2W\2Y\2[\2]\2_\2a\2c\2e\2g\2\3\2"+
		"\"\5\2C\\aac|\6\2\62;C\\aac|\4\2--//\3\2))\5\2\13\f\17\17\"\"\3\2\62;"+
		"\4\2CCcc\4\2DDdd\4\2EEee\4\2FFff\4\2GGgg\4\2HHhh\4\2IIii\4\2JJjj\4\2K"+
		"Kkk\4\2LLll\4\2MMmm\4\2NNnn\4\2OOoo\4\2PPpp\4\2QQqq\4\2RRrr\4\2SSss\4"+
		"\2TTtt\4\2UUuu\4\2VVvv\4\2WWww\4\2XXxx\4\2YYyy\4\2ZZzz\4\2[[{{\4\2\\\\"+
		"||\2\u00f6\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2"+
		"\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27"+
		"\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2"+
		"\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2"+
		"\2/\3\2\2\2\2\61\3\2\2\2\3i\3\2\2\2\5k\3\2\2\2\7m\3\2\2\2\tu\3\2\2\2\13"+
		"z\3\2\2\2\r\177\3\2\2\2\17\u008a\3\2\2\2\21\u008e\3\2\2\2\23\u0099\3\2"+
		"\2\2\25\u009b\3\2\2\2\27\u009d\3\2\2\2\31\u009f\3\2\2\2\33\u00a1\3\2\2"+
		"\2\35\u00a6\3\2\2\2\37\u00ac\3\2\2\2!\u00ae\3\2\2\2#\u00b0\3\2\2\2%\u00b2"+
		"\3\2\2\2\'\u00b5\3\2\2\2)\u00b8\3\2\2\2+\u00bc\3\2\2\2-\u00bf\3\2\2\2"+
		"/\u00c4\3\2\2\2\61\u00cb\3\2\2\2\63\u00d1\3\2\2\2\65\u00d3\3\2\2\2\67"+
		"\u00d5\3\2\2\29\u00d7\3\2\2\2;\u00d9\3\2\2\2=\u00db\3\2\2\2?\u00dd\3\2"+
		"\2\2A\u00df\3\2\2\2C\u00e1\3\2\2\2E\u00e3\3\2\2\2G\u00e5\3\2\2\2I\u00e7"+
		"\3\2\2\2K\u00e9\3\2\2\2M\u00eb\3\2\2\2O\u00ed\3\2\2\2Q\u00ef\3\2\2\2S"+
		"\u00f1\3\2\2\2U\u00f3\3\2\2\2W\u00f5\3\2\2\2Y\u00f7\3\2\2\2[\u00f9\3\2"+
		"\2\2]\u00fb\3\2\2\2_\u00fd\3\2\2\2a\u00ff\3\2\2\2c\u0101\3\2\2\2e\u0103"+
		"\3\2\2\2g\u0105\3\2\2\2ij\7*\2\2j\4\3\2\2\2kl\7+\2\2l\6\3\2\2\2mq\t\2"+
		"\2\2np\t\3\2\2on\3\2\2\2ps\3\2\2\2qo\3\2\2\2qr\3\2\2\2r\b\3\2\2\2sq\3"+
		"\2\2\2tv\5\63\32\2ut\3\2\2\2vw\3\2\2\2wu\3\2\2\2wx\3\2\2\2x\n\3\2\2\2"+
		"y{\t\4\2\2zy\3\2\2\2z{\3\2\2\2{|\3\2\2\2|}\5\t\5\2}\f\3\2\2\2~\u0080\5"+
		"\63\32\2\177~\3\2\2\2\u0080\u0081\3\2\2\2\u0081\177\3\2\2\2\u0081\u0082"+
		"\3\2\2\2\u0082\u0083\3\2\2\2\u0083\u0085\7\60\2\2\u0084\u0086\5\63\32"+
		"\2\u0085\u0084\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u0085\3\2\2\2\u0087\u0088"+
		"\3\2\2\2\u0088\16\3\2\2\2\u0089\u008b\t\4\2\2\u008a\u0089\3\2\2\2\u008a"+
		"\u008b\3\2\2\2\u008b\u008c\3\2\2\2\u008c\u008d\5\r\7\2\u008d\20\3\2\2"+
		"\2\u008e\u0094\7)\2\2\u008f\u0093\n\5\2\2\u0090\u0091\7)\2\2\u0091\u0093"+
		"\7)\2\2\u0092\u008f\3\2\2\2\u0092\u0090\3\2\2\2\u0093\u0096\3\2\2\2\u0094"+
		"\u0092\3\2\2\2\u0094\u0095\3\2\2\2\u0095\u0097\3\2\2\2\u0096\u0094\3\2"+
		"\2\2\u0097\u0098\7)\2\2\u0098\22\3\2\2\2\u0099\u009a\7-\2\2\u009a\24\3"+
		"\2\2\2\u009b\u009c\7/\2\2\u009c\26\3\2\2\2\u009d\u009e\7,\2\2\u009e\30"+
		"\3\2\2\2\u009f\u00a0\7\61\2\2\u00a0\32\3\2\2\2\u00a1\u00a2\7\'\2\2\u00a2"+
		"\34\3\2\2\2\u00a3\u00a7\7?\2\2\u00a4\u00a5\7?\2\2\u00a5\u00a7\7?\2\2\u00a6"+
		"\u00a3\3\2\2\2\u00a6\u00a4\3\2\2\2\u00a7\36\3\2\2\2\u00a8\u00a9\7#\2\2"+
		"\u00a9\u00ad\7?\2\2\u00aa\u00ab\7>\2\2\u00ab\u00ad\7@\2\2\u00ac\u00a8"+
		"\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ad \3\2\2\2\u00ae\u00af\7@\2\2\u00af\""+
		"\3\2\2\2\u00b0\u00b1\7>\2\2\u00b1$\3\2\2\2\u00b2\u00b3\7@\2\2\u00b3\u00b4"+
		"\7?\2\2\u00b4&\3\2\2\2\u00b5\u00b6\7>\2\2\u00b6\u00b7\7?\2\2\u00b7(\3"+
		"\2\2\2\u00b8\u00b9\5\65\33\2\u00b9\u00ba\5O(\2\u00ba\u00bb\5;\36\2\u00bb"+
		"*\3\2\2\2\u00bc\u00bd\5Q)\2\u00bd\u00be\5W,\2\u00be,\3\2\2\2\u00bf\u00c0"+
		"\5[.\2\u00c0\u00c1\5W,\2\u00c1\u00c2\5]/\2\u00c2\u00c3\5=\37\2\u00c3."+
		"\3\2\2\2\u00c4\u00c5\5? \2\u00c5\u00c6\5\65\33\2\u00c6\u00c7\5K&\2\u00c7"+
		"\u00c8\5Y-\2\u00c8\u00c9\5=\37\2\u00c9\60\3\2\2\2\u00ca\u00cc\t\6\2\2"+
		"\u00cb\u00ca\3\2\2\2\u00cc\u00cd\3\2\2\2\u00cd\u00cb\3\2\2\2\u00cd\u00ce"+
		"\3\2\2\2\u00ce\u00cf\3\2\2\2\u00cf\u00d0\b\31\2\2\u00d0\62\3\2\2\2\u00d1"+
		"\u00d2\t\7\2\2\u00d2\64\3\2\2\2\u00d3\u00d4\t\b\2\2\u00d4\66\3\2\2\2\u00d5"+
		"\u00d6\t\t\2\2\u00d68\3\2\2\2\u00d7\u00d8\t\n\2\2\u00d8:\3\2\2\2\u00d9"+
		"\u00da\t\13\2\2\u00da<\3\2\2\2\u00db\u00dc\t\f\2\2\u00dc>\3\2\2\2\u00dd"+
		"\u00de\t\r\2\2\u00de@\3\2\2\2\u00df\u00e0\t\16\2\2\u00e0B\3\2\2\2\u00e1"+
		"\u00e2\t\17\2\2\u00e2D\3\2\2\2\u00e3\u00e4\t\20\2\2\u00e4F\3\2\2\2\u00e5"+
		"\u00e6\t\21\2\2\u00e6H\3\2\2\2\u00e7\u00e8\t\22\2\2\u00e8J\3\2\2\2\u00e9"+
		"\u00ea\t\23\2\2\u00eaL\3\2\2\2\u00eb\u00ec\t\24\2\2\u00ecN\3\2\2\2\u00ed"+
		"\u00ee\t\25\2\2\u00eeP\3\2\2\2\u00ef\u00f0\t\26\2\2\u00f0R\3\2\2\2\u00f1"+
		"\u00f2\t\27\2\2\u00f2T\3\2\2\2\u00f3\u00f4\t\30\2\2\u00f4V\3\2\2\2\u00f5"+
		"\u00f6\t\31\2\2\u00f6X\3\2\2\2\u00f7\u00f8\t\32\2\2\u00f8Z\3\2\2\2\u00f9"+
		"\u00fa\t\33\2\2\u00fa\\\3\2\2\2\u00fb\u00fc\t\34\2\2\u00fc^\3\2\2\2\u00fd"+
		"\u00fe\t\35\2\2\u00fe`\3\2\2\2\u00ff\u0100\t\36\2\2\u0100b\3\2\2\2\u0101"+
		"\u0102\t\37\2\2\u0102d\3\2\2\2\u0103\u0104\t \2\2\u0104f\3\2\2\2\u0105"+
		"\u0106\t!\2\2\u0106h\3\2\2\2\16\2qwz\u0081\u0087\u008a\u0092\u0094\u00a6"+
		"\u00ac\u00cd\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}