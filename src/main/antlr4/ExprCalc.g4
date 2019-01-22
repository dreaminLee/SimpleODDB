grammar ExprCalc;

expression
    : expression op=MOD expression # MOD_
    | expression op=( MUL | DIV ) expression # MUL_DIV
    | expression op=( ADD | SUB ) expression # ADD_SUB
    | expression op=( GREATER | GREATER_OR_EQUAL | LESS | LESS_OR_EQUAL ) expression # GREATER_LESS
    | expression op=( EQUAL | NOT_EQUAL ) expression # EQUAL_ORNOT
    | expression op=AND expression # LOGIC
    | expression op=OR  expression # LOGIC
    | value # constant
    | ID # var
    | '(' expression ')' # BRACKET
    ;

value
    : (TRUE | FALSE) # BOOL
    | STRING_LITERAL # CHAR
    | (SIGNED_DECIMAL | DECIMAL) # INT
    | (SIGNED_REAL | REAL) # FLOAT
    ;


DECIMAL: DEC_DIGIT+;
SIGNED_DECIMAL: ('+' | '-')? DECIMAL;
REAL:    DEC_DIGIT+ '.' DEC_DIGIT+;
SIGNED_REAL: ('+' | '-')? REAL;
STRING_LITERAL
 : '\'' ( ~'\'' | '\'\'' )* '\''
 ;

// arithmetic
MOD : '%';
MUL : '*';
DIV : '/';
ADD : '+';
SUB : '-';

// compare
GREATER : '>';
LESS : '<';
GREATER_OR_EQUAL: '>=';
LESS_OR_EQUAL : '<=';
EQUAL : ('=' | '==');
NOT_EQUAL : ('!=' | '<>');

// logic
AND : A N D;
OR : O R;
TRUE : T R U E;
FALSE : F A L S E;

ID : [a-zA-Z_] [a-zA-Z0-9_]* ;
WS : [ \t\r\n]+ -> skip ;

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
