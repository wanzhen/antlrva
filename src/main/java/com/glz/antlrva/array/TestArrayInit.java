package com.glz.antlrva.array;

import com.glz.antlrva.AntlrvaApplication;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;

public class TestArrayInit {
    public static void main(String[] args) throws IOException {

        System.out.println(TestArrayInit.class.getClassLoader().getResource("abc.txt").getPath());
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
        ;


    }
}
