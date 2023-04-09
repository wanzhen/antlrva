package com.glz.antlrva.eecsantlr.model;


import lombok.Data;

@Data
public class MultiExpression extends Expression {

    private Expression left;
    private Expression right;

    public MultiExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return left.toString() + "*" + right.toString();
    }
}
