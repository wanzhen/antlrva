grammar Expr;

@header{
package com.glz.antlrva.eecsantlr.base;
}


prog: (decl  | expr )+ EOF  # Program
    ;

decl: ID ':' INT_TYPE '=' NUM   # Declaration
   ;

expr:  expr  '*'  expr   # Multiplication
      | expr '/'  expr   # Div
      | expr '+'  expr   # Addition
      | expr '-'  expr   # Sub
      | '(' expr ')'     # Parens
      | ID               # Variable
      | NUM              # Number
      ;



ID : [a-z][a-zA=Z0-9_]*; //identifiers

NUM: '0' | '-'?[1-9][0-9]*;

INT_TYPE: 'INT';

COMMENT: '--' ~[\r\n] ->skip;


//WS: [ \t\n]+ ->skip;
//处理换行符 换行符 Windows使用"\r\n"，而UNIX使用"\n"  原视频代码没处理\r 总是报错token recognition error at: '\r'
WS: [ \t\r\n]+ ->skip;

ADD: '+' ;
MUL: '*' ;


