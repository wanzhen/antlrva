package com.glz.antlrva;

import com.glz.antlrva.g4.CalculatorBaseVisitor;
import com.glz.antlrva.g4.CalculatorLexer;
import com.glz.antlrva.g4.CalculatorParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.HashMap;

public class TestShowAntlr {
    public static void main(String[] args) {
/*
        String expression = "a = 12\n" +
                "b = a * 3\n" +
                "a + b\n" +
                "a - b\n";
*/



        String expression ="(a - b) * (3 + ad) + (2*3)*(1+2) \n";
        CalculatorLexer lexer = new CalculatorLexer(CharStreams.fromString(expression));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        CalculatorParser parser = new CalculatorParser(tokens);
        parser.setBuildParseTree(true);
        ParseTree root = parser.prog();

        HashMap<String, Integer> variable = new HashMap<>();

        variable.put("a",12);
        variable.put("ad",12);
        variable.put("b",3);
        variable.put("d",3);

        CalculatorShowImpl visitor = new CalculatorShowImpl(variable);

        double result = root.accept(visitor);
        System.out.println(result);
        visitor.getKeyVal();
        System.out.println(visitor.getKeyVal());

         //   func1(p:param1,p:param2)
         //   (T1 + T2) *

         // a + b * 3


     /*   String expr = "2 * (3 + 4) / 5";
        CalculatorLexer lexer = new CalculatorLexer(CharStreams.fromString(expr));
        CalculatorParser parser = new CalculatorParser(new CommonTokenStream(lexer));
        CalculatorVisitor visitor = new CalculatorVisitorImpl();
        double result = (double) visitor.visit(parser.expression());
        System.out.println("Result: " + result);*/
    }
}
