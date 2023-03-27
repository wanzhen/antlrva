grammar Expr;
import CommonLexerRules;
/**起始规则*/
prog: stat+;

stat: expr NEWLINE
      | ID '=' expr NEWLINE
      | NEWLINE
      ;

expr : expr ('*'|'/') expr
     | expr ('+'|'-') expr
     | INT
     | ID
     | '('  expr ')'
     ;
