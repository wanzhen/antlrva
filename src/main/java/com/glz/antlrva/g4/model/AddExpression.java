package com.glz.antlrva.g4.model;

import lombok.Data;

@Data
public class AddExpression extends Expression {
    private Expression left;
    private Expression right;

    public AddExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }



}
