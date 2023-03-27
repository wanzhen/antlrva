package com.glz.antlrva.demo4;

import com.glz.antlrva.array.ArrayInitLexer;
import com.glz.antlrva.array.ArrayInitParser;
import com.glz.antlrva.array.TestArrayInit;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ExprJoyRide {
    public static void main(String[] args) throws IOException {
        String inputFile = null;
        if (args.length > 0) {
            inputFile = args[0];
        }
       // InputStream is = System.in;
         InputStream is = new FileInputStream(ExprJoyRide.class.getClassLoader().getResource("demo4.expr").getPath());
        if (inputFile != null) {
            is = new FileInputStream(inputFile);
        }

        CharStream charStream = CharStreams.fromStream(is);
        //词法分析器
        ExprLexer lexer = new ExprLexer(charStream);

        //词法符号缓冲区 存储词法分析器将生成的词法符号
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        //语法分析器
        ExprParser parser = new ExprParser(tokens);

        ParseTree tree = parser.prog();
        System.out.println(tree.toStringTree(parser));
        ;

    }
}
