package com.glz.antlrva.g4.visitor;

import com.glz.antlrva.g4.CalculatorBaseVisitor;
import com.glz.antlrva.g4.CalculatorParser;
import com.glz.antlrva.g4.model.*;

import java.util.HashMap;
import java.util.Map;

public class ExpressionVisitor extends CalculatorBaseVisitor<Expression> {


    //存储变量的值
    private Map<String, Double> variable = new HashMap<>();

    public Map<String, Double> getVariable() {
        return variable;
    }

    public void setVariable(Map<String, Double> variable) {
        this.variable = variable;
    }


    @Override
    public Expression visitAssign(CalculatorParser.AssignContext ctx) {
        String name = ctx.ID().getText();
        double value = Double.valueOf(ctx.expr().getText());
        variable.put(name, value);
        return new VariableDecExpression(name, value);
    }


    @Override
    public Expression visitMulDiv(CalculatorParser.MulDivContext ctx) {
        Expression left = visit(ctx.getChild(0));
        Expression right = visit(ctx.getChild(2));
        return new MultiExpression(left, right);
    }

    @Override
    public Expression visitAddSub(CalculatorParser.AddSubContext ctx) {
        Expression left = visit(ctx.getChild(0));
        Expression right = visit(ctx.getChild(2));
        return new AddExpression(left, right);
    }

    @Override
    public Expression visitParens(CalculatorParser.ParensContext ctx) {
        return super.visitParens(ctx);
    }

    @Override
    public Expression visitId(CalculatorParser.IdContext ctx) {
        String id =  ctx.ID().getText();
        return new VariableExpression(id);
    }


    @Override
    public Expression visitInt(CalculatorParser.IntContext ctx) {
        return  new NumExpression(Double.valueOf(ctx.getText()));
    }

}
