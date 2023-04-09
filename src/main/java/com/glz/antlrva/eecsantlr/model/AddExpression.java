package com.glz.antlrva.eecsantlr.model;

import lombok.Data;

@Data
public class AddExpression extends Expression {
    private Expression left;
    private Expression right;

    public AddExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return left.toString() + "+" + right.toString();
    }

}
