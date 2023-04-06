package com.glz.antlrva.g4.visitor;

import cn.hutool.json.JSONUtil;
import com.glz.antlrva.g4.CalculatorLexer;
import com.glz.antlrva.g4.CalculatorParser;
import com.glz.antlrva.g4.model.Expression;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.HashMap;

public class TestAnaly {
    public static void main(String[] args) {
       // String expression = "(a - b) * (3 + ad) + (2*3)*(1+2) \n";


        String expression ="a - b";
        CalculatorLexer lexer = new CalculatorLexer(CharStreams.fromString(expression));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        CalculatorParser parser = new CalculatorParser(tokens);
        parser.setBuildParseTree(true);
        ParseTree tree = parser.parse();
        HashMap<String, Double> variable = new HashMap<>();
        variable.put("a", 12.0);
        variable.put("ad", 12.0);
        variable.put("b", 3.0);
        variable.put("d", 3.0);
        ExpressionVisitor visitor = new ExpressionVisitor();
        visitor.setVariable(variable);
        Expression expre = visitor.visit(tree.getChild(0));
        System.out.println(JSONUtil.toJsonStr(expre));

    }
}
