package com.glz.antlrva.g4.visitor;

import com.glz.antlrva.g4.CalculatorBaseVisitor;
import com.glz.antlrva.g4.CalculatorParser;
import com.glz.antlrva.g4.model.*;

import java.util.HashMap;
import java.util.Map;

public class ExpressionParseVisitor extends CalculatorBaseVisitor<Parse> {

    @Override
    public Parse visitParse(CalculatorParser.ParseContext ctx) {
        Parse parse = new Parse();
        ExpressionVisitor expressionVisitor = new ExpressionVisitor();
        for (int i = 0; i < ctx.getChildCount(); i++) {
            if (i == ctx.getChildCount() - 1) {
            } else {
                parse.add(expressionVisitor.visit(ctx.getChild(i)));
            }
        }
        return parse;
    }
}
