package com.glz.antlrva.array;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.FileInputStream;
import java.io.IOException;

public class TestArrayInitListener {
    public static void main(String[] args) throws IOException {

        System.out.println(TestArrayInitListener.class.getClassLoader().getResource("abc.txt").getPath());
        FileInputStream fileInputStream = new FileInputStream( "C:\\Users\\glz\\Documents\\GitHub\\antlrva\\src\\main\\java\\com\\glz\\antlrva\\array\\abc.txt");
        ANTLRInputStream charStream = new ANTLRInputStream(fileInputStream);


        //词法分析器
        ArrayInitLexer lexer = new ArrayInitLexer(charStream);

        //词法符号缓冲区 存储词法分析器将生成的词法符号
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        //语法分析器
        ArrayInitParser parser = new ArrayInitParser(tokens);

        ParseTree tree = parser.init();

        System.out.println(tree.toStringTree(parser));

        //通用的出发回调函数的语法分析树遍历器
        ParseTreeWalker walker = new ParseTreeWalker();

        //遍历语法分析过程中生成的语法分析树，触发发回调
        walker.walk(new ShortToUnicodeString(parser),tree);

        ;


    }
}
