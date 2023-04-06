package com.glz.antlrva.g4.model;

import lombok.Data;

@Data
public class NumExpression extends Expression {
    private Object value;

    public NumExpression(Object value) {
        this.value = value;
    }
}

