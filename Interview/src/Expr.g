grammar Expr;

prog 	:	stat+;

stat	:	expr NEWLINE
	|	ID '=' expr NEWLINE
	|	NEWLINE
	;

expr 	:	multExpr (('and'|'or') multExpr)*
	;
	
multExpr:	atom ('*' atom)*
	;

atom	:	INT
	|	ID
	|	'(' expr ')'
	;

ID	:	('NOT'|'not')('a'..'z'|'A'..'Z')+;
INT	:	('NOT'|'not')'0'..'9'+;
NEWLINE	:	'\r'? '\n';
WS	:	(' '|'\t'|'\n'|'\r')+ {skip();};