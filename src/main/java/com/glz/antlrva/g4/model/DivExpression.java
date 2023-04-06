package com.glz.antlrva.g4.model;

import lombok.Data;

@Data
public class DivExpression extends Expression {
    private Expression left;
    private Expression right;
}
