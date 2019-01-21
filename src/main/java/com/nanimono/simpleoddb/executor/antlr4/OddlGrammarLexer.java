package com.nanimono.simpleoddb.executor.antlr4;// Generated from OddlGrammar.g4 by ANTLR 4.7.2

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.LexerATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class OddlGrammarLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, AS=11, CLASS=12, CREATE=13, CROSS=14, DELETE=15, DROP=16, FROM=17, 
		INSERT=18, INTO=19, SELECT=20, SELECTDEPUTY=21, UPDATE=22, VALUES=23, 
		SET=24, WHERE=25, BOOLEAN=26, CHAR=27, INT=28, LONG=29, FLOAT=30, TRUE=31, 
		FALSE=32, AND=33, OR=34, NOT=35, DOT=36, LR_BRACKET=37, RR_BRACKET=38, 
		COMMA=39, SEMI=40, EQUAL_SYMBOL=41, GREATER_SYMBOL=42, LESS_SYMBOL=43, 
		SPACE=44, DECIMAL=45, REAL=46, STRING_LITERAL=47, SIGNED_DECIMAL=48, SIGNED_REAL=49, 
		ID=50;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "AS", "CLASS", "CREATE", "CROSS", "DELETE", "DROP", "FROM", "INSERT", 
			"INTO", "SELECT", "SELECTDEPUTY", "UPDATE", "VALUES", "SET", "WHERE", 
			"BOOLEAN", "CHAR", "INT", "LONG", "FLOAT", "TRUE", "FALSE", "AND", "OR", 
			"NOT", "DOT", "LR_BRACKET", "RR_BRACKET", "COMMA", "SEMI", "EQUAL_SYMBOL", 
			"GREATER_SYMBOL", "LESS_SYMBOL", "SPACE", "DECIMAL", "REAL", "STRING_LITERAL", 
			"SIGNED_DECIMAL", "SIGNED_REAL", "ID", "DEC_DIGIT", "A", "B", "C", "D", 
			"E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", 
			"S", "T", "U", "V", "W", "X", "Y", "Z"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'*'", "'/'", "'%'", "'+'", "'-'", "'<='", "'>='", "'=='", "'!='", 
			"'<>'", null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, "'.'", "'('", "')'", "','", "';'", "'='", "'>'", "'<'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, "AS", 
			"CLASS", "CREATE", "CROSS", "DELETE", "DROP", "FROM", "INSERT", "INTO", 
			"SELECT", "SELECTDEPUTY", "UPDATE", "VALUES", "SET", "WHERE", "BOOLEAN", 
			"CHAR", "INT", "LONG", "FLOAT", "TRUE", "FALSE", "AND", "OR", "NOT", 
			"DOT", "LR_BRACKET", "RR_BRACKET", "COMMA", "SEMI", "EQUAL_SYMBOL", "GREATER_SYMBOL", 
			"LESS_SYMBOL", "SPACE", "DECIMAL", "REAL", "STRING_LITERAL", "SIGNED_DECIMAL", 
			"SIGNED_REAL", "ID"
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


	public OddlGrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "OddlGrammar.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\64\u01c0\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t"+
		"=\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4"+
		"I\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6"+
		"\3\6\3\7\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\13\3"+
		"\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21"+
		"\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\31"+
		"\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33"+
		"\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\36\3\36"+
		"\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3 \3!\3!\3!"+
		"\3!\3!\3!\3\"\3\"\3\"\3\"\3#\3#\3#\3$\3$\3$\3$\3%\3%\3&\3&\3\'\3\'\3("+
		"\3(\3)\3)\3*\3*\3+\3+\3,\3,\3-\6-\u0159\n-\r-\16-\u015a\3-\3-\3.\6.\u0160"+
		"\n.\r.\16.\u0161\3/\6/\u0165\n/\r/\16/\u0166\3/\3/\6/\u016b\n/\r/\16/"+
		"\u016c\3\60\3\60\3\60\3\60\7\60\u0173\n\60\f\60\16\60\u0176\13\60\3\60"+
		"\3\60\3\61\5\61\u017b\n\61\3\61\3\61\3\62\5\62\u0180\n\62\3\62\3\62\3"+
		"\63\3\63\7\63\u0186\n\63\f\63\16\63\u0189\13\63\3\64\3\64\3\65\3\65\3"+
		"\66\3\66\3\67\3\67\38\38\39\39\3:\3:\3;\3;\3<\3<\3=\3=\3>\3>\3?\3?\3@"+
		"\3@\3A\3A\3B\3B\3C\3C\3D\3D\3E\3E\3F\3F\3G\3G\3H\3H\3I\3I\3J\3J\3K\3K"+
		"\3L\3L\3M\3M\3N\3N\2\2O\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f"+
		"\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63"+
		"\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62"+
		"c\63e\64g\2i\2k\2m\2o\2q\2s\2u\2w\2y\2{\2}\2\177\2\u0081\2\u0083\2\u0085"+
		"\2\u0087\2\u0089\2\u008b\2\u008d\2\u008f\2\u0091\2\u0093\2\u0095\2\u0097"+
		"\2\u0099\2\u009b\2\3\2\"\5\2\13\f\17\17\"\"\3\2))\4\2--//\5\2C\\aac|\6"+
		"\2\62;C\\aac|\3\2\62;\4\2CCcc\4\2DDdd\4\2EEee\4\2FFff\4\2GGgg\4\2HHhh"+
		"\4\2IIii\4\2JJjj\4\2KKkk\4\2LLll\4\2MMmm\4\2NNnn\4\2OOoo\4\2PPpp\4\2Q"+
		"Qqq\4\2RRrr\4\2SSss\4\2TTtt\4\2UUuu\4\2VVvv\4\2WWww\4\2XXxx\4\2YYyy\4"+
		"\2ZZzz\4\2[[{{\4\2\\\\||\2\u01ad\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2"+
		"\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2"+
		"\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2"+
		"\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2"+
		"\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2"+
		"\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2"+
		"\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O"+
		"\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2"+
		"\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\3\u009d\3"+
		"\2\2\2\5\u009f\3\2\2\2\7\u00a1\3\2\2\2\t\u00a3\3\2\2\2\13\u00a5\3\2\2"+
		"\2\r\u00a7\3\2\2\2\17\u00aa\3\2\2\2\21\u00ad\3\2\2\2\23\u00b0\3\2\2\2"+
		"\25\u00b3\3\2\2\2\27\u00b6\3\2\2\2\31\u00b9\3\2\2\2\33\u00bf\3\2\2\2\35"+
		"\u00c6\3\2\2\2\37\u00cc\3\2\2\2!\u00d3\3\2\2\2#\u00d8\3\2\2\2%\u00dd\3"+
		"\2\2\2\'\u00e4\3\2\2\2)\u00e9\3\2\2\2+\u00f0\3\2\2\2-\u00fd\3\2\2\2/\u0104"+
		"\3\2\2\2\61\u010b\3\2\2\2\63\u010f\3\2\2\2\65\u0115\3\2\2\2\67\u011d\3"+
		"\2\2\29\u0122\3\2\2\2;\u0126\3\2\2\2=\u012b\3\2\2\2?\u0131\3\2\2\2A\u0136"+
		"\3\2\2\2C\u013c\3\2\2\2E\u0140\3\2\2\2G\u0143\3\2\2\2I\u0147\3\2\2\2K"+
		"\u0149\3\2\2\2M\u014b\3\2\2\2O\u014d\3\2\2\2Q\u014f\3\2\2\2S\u0151\3\2"+
		"\2\2U\u0153\3\2\2\2W\u0155\3\2\2\2Y\u0158\3\2\2\2[\u015f\3\2\2\2]\u0164"+
		"\3\2\2\2_\u016e\3\2\2\2a\u017a\3\2\2\2c\u017f\3\2\2\2e\u0183\3\2\2\2g"+
		"\u018a\3\2\2\2i\u018c\3\2\2\2k\u018e\3\2\2\2m\u0190\3\2\2\2o\u0192\3\2"+
		"\2\2q\u0194\3\2\2\2s\u0196\3\2\2\2u\u0198\3\2\2\2w\u019a\3\2\2\2y\u019c"+
		"\3\2\2\2{\u019e\3\2\2\2}\u01a0\3\2\2\2\177\u01a2\3\2\2\2\u0081\u01a4\3"+
		"\2\2\2\u0083\u01a6\3\2\2\2\u0085\u01a8\3\2\2\2\u0087\u01aa\3\2\2\2\u0089"+
		"\u01ac\3\2\2\2\u008b\u01ae\3\2\2\2\u008d\u01b0\3\2\2\2\u008f\u01b2\3\2"+
		"\2\2\u0091\u01b4\3\2\2\2\u0093\u01b6\3\2\2\2\u0095\u01b8\3\2\2\2\u0097"+
		"\u01ba\3\2\2\2\u0099\u01bc\3\2\2\2\u009b\u01be\3\2\2\2\u009d\u009e\7,"+
		"\2\2\u009e\4\3\2\2\2\u009f\u00a0\7\61\2\2\u00a0\6\3\2\2\2\u00a1\u00a2"+
		"\7\'\2\2\u00a2\b\3\2\2\2\u00a3\u00a4\7-\2\2\u00a4\n\3\2\2\2\u00a5\u00a6"+
		"\7/\2\2\u00a6\f\3\2\2\2\u00a7\u00a8\7>\2\2\u00a8\u00a9\7?\2\2\u00a9\16"+
		"\3\2\2\2\u00aa\u00ab\7@\2\2\u00ab\u00ac\7?\2\2\u00ac\20\3\2\2\2\u00ad"+
		"\u00ae\7?\2\2\u00ae\u00af\7?\2\2\u00af\22\3\2\2\2\u00b0\u00b1\7#\2\2\u00b1"+
		"\u00b2\7?\2\2\u00b2\24\3\2\2\2\u00b3\u00b4\7>\2\2\u00b4\u00b5\7@\2\2\u00b5"+
		"\26\3\2\2\2\u00b6\u00b7\5i\65\2\u00b7\u00b8\5\u008dG\2\u00b8\30\3\2\2"+
		"\2\u00b9\u00ba\5m\67\2\u00ba\u00bb\5\177@\2\u00bb\u00bc\5i\65\2\u00bc"+
		"\u00bd\5\u008dG\2\u00bd\u00be\5\u008dG\2\u00be\32\3\2\2\2\u00bf\u00c0"+
		"\5m\67\2\u00c0\u00c1\5\u008bF\2\u00c1\u00c2\5q9\2\u00c2\u00c3\5i\65\2"+
		"\u00c3\u00c4\5\u008fH\2\u00c4\u00c5\5q9\2\u00c5\34\3\2\2\2\u00c6\u00c7"+
		"\5m\67\2\u00c7\u00c8\5\u008bF\2\u00c8\u00c9\5\u0085C\2\u00c9\u00ca\5\u008d"+
		"G\2\u00ca\u00cb\5\u008dG\2\u00cb\36\3\2\2\2\u00cc\u00cd\5o8\2\u00cd\u00ce"+
		"\5q9\2\u00ce\u00cf\5\177@\2\u00cf\u00d0\5q9\2\u00d0\u00d1\5\u008fH\2\u00d1"+
		"\u00d2\5q9\2\u00d2 \3\2\2\2\u00d3\u00d4\5o8\2\u00d4\u00d5\5\u008bF\2\u00d5"+
		"\u00d6\5\u0085C\2\u00d6\u00d7\5\u0087D\2\u00d7\"\3\2\2\2\u00d8\u00d9\5"+
		"s:\2\u00d9\u00da\5\u008bF\2\u00da\u00db\5\u0085C\2\u00db\u00dc\5\u0081"+
		"A\2\u00dc$\3\2\2\2\u00dd\u00de\5y=\2\u00de\u00df\5\u0083B\2\u00df\u00e0"+
		"\5\u008dG\2\u00e0\u00e1\5q9\2\u00e1\u00e2\5\u008bF\2\u00e2\u00e3\5\u008f"+
		"H\2\u00e3&\3\2\2\2\u00e4\u00e5\5y=\2\u00e5\u00e6\5\u0083B\2\u00e6\u00e7"+
		"\5\u008fH\2\u00e7\u00e8\5\u0085C\2\u00e8(\3\2\2\2\u00e9\u00ea\5\u008d"+
		"G\2\u00ea\u00eb\5q9\2\u00eb\u00ec\5\177@\2\u00ec\u00ed\5q9\2\u00ed\u00ee"+
		"\5m\67\2\u00ee\u00ef\5\u008fH\2\u00ef*\3\2\2\2\u00f0\u00f1\5\u008dG\2"+
		"\u00f1\u00f2\5q9\2\u00f2\u00f3\5\177@\2\u00f3\u00f4\5q9\2\u00f4\u00f5"+
		"\5m\67\2\u00f5\u00f6\5\u008fH\2\u00f6\u00f7\5o8\2\u00f7\u00f8\5q9\2\u00f8"+
		"\u00f9\5\u0087D\2\u00f9\u00fa\5\u0091I\2\u00fa\u00fb\5\u008fH\2\u00fb"+
		"\u00fc\5\u0099M\2\u00fc,\3\2\2\2\u00fd\u00fe\5\u0091I\2\u00fe\u00ff\5"+
		"\u0087D\2\u00ff\u0100\5o8\2\u0100\u0101\5i\65\2\u0101\u0102\5\u008fH\2"+
		"\u0102\u0103\5q9\2\u0103.\3\2\2\2\u0104\u0105\5\u0093J\2\u0105\u0106\5"+
		"i\65\2\u0106\u0107\5\177@\2\u0107\u0108\5\u0091I\2\u0108\u0109\5q9\2\u0109"+
		"\u010a\5\u008dG\2\u010a\60\3\2\2\2\u010b\u010c\5\u008dG\2\u010c\u010d"+
		"\5q9\2\u010d\u010e\5\u008fH\2\u010e\62\3\2\2\2\u010f\u0110\5\u0095K\2"+
		"\u0110\u0111\5w<\2\u0111\u0112\5q9\2\u0112\u0113\5\u008bF\2\u0113\u0114"+
		"\5q9\2\u0114\64\3\2\2\2\u0115\u0116\5k\66\2\u0116\u0117\5\u0085C\2\u0117"+
		"\u0118\5\u0085C\2\u0118\u0119\5\177@\2\u0119\u011a\5q9\2\u011a\u011b\5"+
		"i\65\2\u011b\u011c\5\u0083B\2\u011c\66\3\2\2\2\u011d\u011e\5m\67\2\u011e"+
		"\u011f\5w<\2\u011f\u0120\5i\65\2\u0120\u0121\5\u008bF\2\u01218\3\2\2\2"+
		"\u0122\u0123\5y=\2\u0123\u0124\5\u0083B\2\u0124\u0125\5\u008fH\2\u0125"+
		":\3\2\2\2\u0126\u0127\5\177@\2\u0127\u0128\5\u0085C\2\u0128\u0129\5\u0083"+
		"B\2\u0129\u012a\5u;\2\u012a<\3\2\2\2\u012b\u012c\5s:\2\u012c\u012d\5\177"+
		"@\2\u012d\u012e\5\u0085C\2\u012e\u012f\5i\65\2\u012f\u0130\5\u008fH\2"+
		"\u0130>\3\2\2\2\u0131\u0132\5\u008fH\2\u0132\u0133\5\u008bF\2\u0133\u0134"+
		"\5\u0091I\2\u0134\u0135\5q9\2\u0135@\3\2\2\2\u0136\u0137\5s:\2\u0137\u0138"+
		"\5i\65\2\u0138\u0139\5\177@\2\u0139\u013a\5\u008dG\2\u013a\u013b\5q9\2"+
		"\u013bB\3\2\2\2\u013c\u013d\5i\65\2\u013d\u013e\5\u0083B\2\u013e\u013f"+
		"\5o8\2\u013fD\3\2\2\2\u0140\u0141\5\u0085C\2\u0141\u0142\5\u008bF\2\u0142"+
		"F\3\2\2\2\u0143\u0144\5\u0083B\2\u0144\u0145\5\u0085C\2\u0145\u0146\5"+
		"\u008fH\2\u0146H\3\2\2\2\u0147\u0148\7\60\2\2\u0148J\3\2\2\2\u0149\u014a"+
		"\7*\2\2\u014aL\3\2\2\2\u014b\u014c\7+\2\2\u014cN\3\2\2\2\u014d\u014e\7"+
		".\2\2\u014eP\3\2\2\2\u014f\u0150\7=\2\2\u0150R\3\2\2\2\u0151\u0152\7?"+
		"\2\2\u0152T\3\2\2\2\u0153\u0154\7@\2\2\u0154V\3\2\2\2\u0155\u0156\7>\2"+
		"\2\u0156X\3\2\2\2\u0157\u0159\t\2\2\2\u0158\u0157\3\2\2\2\u0159\u015a"+
		"\3\2\2\2\u015a\u0158\3\2\2\2\u015a\u015b\3\2\2\2\u015b\u015c\3\2\2\2\u015c"+
		"\u015d\b-\2\2\u015dZ\3\2\2\2\u015e\u0160\5g\64\2\u015f\u015e\3\2\2\2\u0160"+
		"\u0161\3\2\2\2\u0161\u015f\3\2\2\2\u0161\u0162\3\2\2\2\u0162\\\3\2\2\2"+
		"\u0163\u0165\5g\64\2\u0164\u0163\3\2\2\2\u0165\u0166\3\2\2\2\u0166\u0164"+
		"\3\2\2\2\u0166\u0167\3\2\2\2\u0167\u0168\3\2\2\2\u0168\u016a\7\60\2\2"+
		"\u0169\u016b\5g\64\2\u016a\u0169\3\2\2\2\u016b\u016c\3\2\2\2\u016c\u016a"+
		"\3\2\2\2\u016c\u016d\3\2\2\2\u016d^\3\2\2\2\u016e\u0174\7)\2\2\u016f\u0173"+
		"\n\3\2\2\u0170\u0171\7)\2\2\u0171\u0173\7)\2\2\u0172\u016f\3\2\2\2\u0172"+
		"\u0170\3\2\2\2\u0173\u0176\3\2\2\2\u0174\u0172\3\2\2\2\u0174\u0175\3\2"+
		"\2\2\u0175\u0177\3\2\2\2\u0176\u0174\3\2\2\2\u0177\u0178\7)\2\2\u0178"+
		"`\3\2\2\2\u0179\u017b\t\4\2\2\u017a\u0179\3\2\2\2\u017a\u017b\3\2\2\2"+
		"\u017b\u017c\3\2\2\2\u017c\u017d\5[.\2\u017db\3\2\2\2\u017e\u0180\t\4"+
		"\2\2\u017f\u017e\3\2\2\2\u017f\u0180\3\2\2\2\u0180\u0181\3\2\2\2\u0181"+
		"\u0182\5]/\2\u0182d\3\2\2\2\u0183\u0187\t\5\2\2\u0184\u0186\t\6\2\2\u0185"+
		"\u0184\3\2\2\2\u0186\u0189\3\2\2\2\u0187\u0185\3\2\2\2\u0187\u0188\3\2"+
		"\2\2\u0188f\3\2\2\2\u0189\u0187\3\2\2\2\u018a\u018b\t\7\2\2\u018bh\3\2"+
		"\2\2\u018c\u018d\t\b\2\2\u018dj\3\2\2\2\u018e\u018f\t\t\2\2\u018fl\3\2"+
		"\2\2\u0190\u0191\t\n\2\2\u0191n\3\2\2\2\u0192\u0193\t\13\2\2\u0193p\3"+
		"\2\2\2\u0194\u0195\t\f\2\2\u0195r\3\2\2\2\u0196\u0197\t\r\2\2\u0197t\3"+
		"\2\2\2\u0198\u0199\t\16\2\2\u0199v\3\2\2\2\u019a\u019b\t\17\2\2\u019b"+
		"x\3\2\2\2\u019c\u019d\t\20\2\2\u019dz\3\2\2\2\u019e\u019f\t\21\2\2\u019f"+
		"|\3\2\2\2\u01a0\u01a1\t\22\2\2\u01a1~\3\2\2\2\u01a2\u01a3\t\23\2\2\u01a3"+
		"\u0080\3\2\2\2\u01a4\u01a5\t\24\2\2\u01a5\u0082\3\2\2\2\u01a6\u01a7\t"+
		"\25\2\2\u01a7\u0084\3\2\2\2\u01a8\u01a9\t\26\2\2\u01a9\u0086\3\2\2\2\u01aa"+
		"\u01ab\t\27\2\2\u01ab\u0088\3\2\2\2\u01ac\u01ad\t\30\2\2\u01ad\u008a\3"+
		"\2\2\2\u01ae\u01af\t\31\2\2\u01af\u008c\3\2\2\2\u01b0\u01b1\t\32\2\2\u01b1"+
		"\u008e\3\2\2\2\u01b2\u01b3\t\33\2\2\u01b3\u0090\3\2\2\2\u01b4\u01b5\t"+
		"\34\2\2\u01b5\u0092\3\2\2\2\u01b6\u01b7\t\35\2\2\u01b7\u0094\3\2\2\2\u01b8"+
		"\u01b9\t\36\2\2\u01b9\u0096\3\2\2\2\u01ba\u01bb\t\37\2\2\u01bb\u0098\3"+
		"\2\2\2\u01bc\u01bd\t \2\2\u01bd\u009a\3\2\2\2\u01be\u01bf\t!\2\2\u01bf"+
		"\u009c\3\2\2\2\f\2\u015a\u0161\u0166\u016c\u0172\u0174\u017a\u017f\u0187"+
		"\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}