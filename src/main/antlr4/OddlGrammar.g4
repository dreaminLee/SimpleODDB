grammar OddlGrammar;

root
    : oddlStatements? EOF
    ;

oddlStatements
    : (oddlStatement SEMI | emptyStatement)+
    ;

oddlStatement
    : createSourceClass
    | createDeputyClass
    | dropClass
    | insertIntoClass
    | deleteFromClass
    | simpleQuery
    | crossClassQuery
    | updateObject
    ;

createSourceClass
    : CREATE CLASS className createDefinitions
    ;

createDefinitions
    : '(' createDefinition (',' createDefinition)* ')'
    ;

createDefinition
    : ID dataType;

createDeputyClass
    : CREATE SELECTDEPUTY className
      SELECT expression AS dAttr (',' expression AS dAttr)* 
      FROM sClassName
      WHERE expression
    ;

dropClass
    : DROP CLASS className;

insertIntoClass
    : INSERT INTO className VALUES valueList;

valueList
    : '(' value (',' value)* ')'
    ;

value
    : STRING_LITERAL
    | (SIGNED_DECIMAL | DECIMAL)
    | (SIGNED_REAL | REAL)
    | (TRUE | FALSE)
    ;

deleteFromClass
    : DELETE FROM className WHERE expression;

simpleQuery
    : SELECT attrList FROM className (WHERE expression)?;

crossClassQuery
    : SELECT className (CROSS className)* DOT attrName 
      FROM className
      (WHERE expression)?
    ;

updateObject
    : UPDATE className SET attrName '=' value (',' attrName '=' value)*
      WHERE expression
    ;


expression
    : value
    | attrName 
    | expression op=('*' | '/' | '%') expression
    | expression op=('+' | '-') expression
    | expression op=('<' | '<=' | '>' | '>=') expression
    | expression op=('=' | '==' | '!=' | '<>' ) expression
    | expression AND expression
    | expression OR  expression
    | '(' expression ')'
    ;

emptyStatement
    : SEMI
    ;

sClassName: className;
sAttr: attrName;
dAttr: attrName;
className: ID;
attrName:  ID;
attrList
    : attrName (',' attrName)
    ;
dataType
    : CHAR ('(' DECIMAL ')')?
    | typeName=(INT | FLOAT | BOOLEAN)
    ;

// Keywords
AS : A S;
CLASS:  C L A S S;
CREATE : C R E A T E;
CROSS : C R O S S;
DELETE : D E L E T E;
DROP : D R O P;
FROM : F R O M;
INSERT : I N S E R T;
INTO : I N T O;
SELECT : S E L E C T;
SELECTDEPUTY: S E L E C T D E P U T Y;
UPDATE : U P D A T E;
VALUES : V A L U E S;
SET : S E T;
WHERE : W H E R E;

BOOLEAN: B O O L E A N;
CHAR:    C H A R;
INT:     I N T;
LONG:    L O N G;
FLOAT:   F L O A T;

TRUE: T R U E;
FALSE: F A L S E;
AND: A N D ;
OR:  O R;
NOT: N O T;

// Constructors symbols
DOT:                '.';
LR_BRACKET:         '(';
RR_BRACKET:         ')';
COMMA:              ',';
SEMI:               ';';
EQUAL_SYMBOL:       '=';
GREATER_SYMBOL:     '>';
LESS_SYMBOL:        '<';

SPACE: [ \t\r\n]+    -> channel(HIDDEN);

DECIMAL: DEC_DIGIT+;
REAL:    DEC_DIGIT+ '.' DEC_DIGIT+;
STRING_LITERAL
 : '\'' ( ~'\'' | '\'\'' )* '\''
 ;

SIGNED_DECIMAL: ('+' | '-')? DECIMAL;
SIGNED_REAL: ('+' | '-')? REAL;

ID : [a-zA-Z_] [a-zA-Z0-9_]* ;

fragment DEC_DIGIT:  [0-9];

fragment A : [aA];
fragment B : [bB];
fragment C : [cC];
fragment D : [dD];
fragment E : [eE];
fragment F : [fF];
fragment G : [gG];
fragment H : [hH];
fragment I : [iI];
fragment J : [jJ];
fragment K : [kK];
fragment L : [lL];
fragment M : [mM];
fragment N : [nN];
fragment O : [oO];
fragment P : [pP];
fragment Q : [qQ];
fragment R : [rR];
fragment S : [sS];
fragment T : [tT];
fragment U : [uU];
fragment V : [vV];
fragment W : [wW];
fragment X : [xX];
fragment Y : [yY];
fragment Z : [zZ];
