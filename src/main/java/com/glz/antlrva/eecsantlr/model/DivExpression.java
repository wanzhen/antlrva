package com.glz.antlrva.eecsantlr.model;


import lombok.Data;

@Data
public class DivExpression extends Expression {
    private Expression left;
    private Expression right;

    public DivExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return left.toString() + "/" + right.toString();
    }
}
