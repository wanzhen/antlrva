grammar Calculator;

@header{
package com.glz.antlrva.g4;
}

prog : stat+;
// Parser rules
parse: expr EOF;

stat:
  expr NEWLINE            # print
  | ID '=' expr NEWLINE   # assign
  | NEWLINE               # blank
  ;

expr:
  expr op=('*'|'/') expr    # MulDiv
  | expr op=('+'|'-') expr  # AddSub
  | '(' expr ')'           # Parens
  | INT                     # int
  | ID                      # id
  ;

// Lexer rules
MUL : '*' ;
DIV : '/' ;
ADD : '+' ;
SUB : '-' ;
ID : [a-zA-Z]+ ;
INT : [0-9]+ ;
LPAREN : '(' ;
RPAREN : ')' ;
NEWLINE :'\r'? '\n' ;
WS : [ \t]+ -> skip;