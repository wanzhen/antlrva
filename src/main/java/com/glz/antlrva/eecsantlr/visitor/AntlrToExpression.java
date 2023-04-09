package com.glz.antlrva.eecsantlr.visitor;

import com.glz.antlrva.eecsantlr.base.ExprBaseVisitor;
import com.glz.antlrva.eecsantlr.base.ExprParser;
import com.glz.antlrva.eecsantlr.model.*;
import lombok.Data;
import org.antlr.v4.runtime.Token;

import java.util.ArrayList;
import java.util.List;

@Data
public class AntlrToExpression extends ExprBaseVisitor<Expression> {


    //stores all the variables declared in the program so far
    private List<String> vars;

    //1.duplicate declaration
    //2 reference to undeclared variable
    // semantic errors are different from syntax errors
    private List<String> semanticErrors;

    public AntlrToExpression(List<String> semanticErrors) {
        vars = new ArrayList<>();
        this.semanticErrors = semanticErrors;
    }

    @Override
    public Expression visitDeclaration(ExprParser.DeclarationContext ctx) {
        String variable = ctx.getChild(0).getText();
        String type = ctx.getChild(2).getText();
        String value = ctx.getChild(4).getText();
        //equivalent to : ctx.getChild(0).getSymbol();
        Token variableToken = ctx.ID().getSymbol();

        int line = variableToken.getLine();
        int column = variableToken.getCharPositionInLine() + 1;

        if (vars.contains(variable)) {
            semanticErrors.add("Error: variable" + variable + "already declared (" + line + "," + column + ")");
        } else {
            vars.add(variable);
        }
        return new VariableDecExpression(variable, type, Double.parseDouble(value));
    }

    @Override
    public Expression visitMultiplication(ExprParser.MultiplicationContext ctx) {
        Expression left = visit(ctx.getChild(0));
        Expression right = visit(ctx.getChild(2));
        return new MultiExpression(left, right);
    }

    @Override
    public Expression visitDiv(ExprParser.DivContext ctx) {
        Expression left = visit(ctx.getChild(0));
        Expression right = visit(ctx.getChild(2));
        return new DivExpression(left, right);
    }

    @Override
    public Expression visitAddition(ExprParser.AdditionContext ctx) {
        Expression left = visit(ctx.getChild(0));
        Expression right = visit(ctx.getChild(2));
        return new AddExpression(left, right);
    }

    @Override
    public Expression visitSub(ExprParser.SubContext ctx) {
        Expression left = visit(ctx.getChild(0));
        Expression right = visit(ctx.getChild(2));
        return new SubExpression(left, right);
    }


    @Override
    public Expression visitVariable(ExprParser.VariableContext ctx) {
        String variable = ctx.getChild(0).getText();
        // String variable =  ctx.ID().getText(); //equivalent
        Token variableToken = ctx.ID().getSymbol();
        int line = variableToken.getLine();
        int column = variableToken.getCharPositionInLine() + 1;

        if (!vars.contains(variable)) {
            semanticErrors.add("Error: variable" + variable + " not  declared (" + line + "," + column + ")");
        }
        return new VariableExpression(variable);
    }

    @Override
    public Expression visitNumber(ExprParser.NumberContext ctx) {
        String numText = ctx.getChild(0).getText();
        return new NumExpression(Double.parseDouble(numText));
    }

    @Override
    public Expression visitParens(ExprParser.ParensContext ctx) {
        Expression expression =   visit(ctx.getChild(1));

        return new ParensExpression(expression);
    }
}
