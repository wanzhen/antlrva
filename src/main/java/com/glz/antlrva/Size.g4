grammar Size;

expr : expr op expr
      | INT
      | '(' expr ')'
      ;
op   : '+' | '-' | '*' | '/' ;

INT :[0-9]+;      //匹配整数
WS :[ \t]+ -> skip ; //丢弃空白字符