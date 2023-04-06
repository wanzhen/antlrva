package com.glz.antlrva.g4.model;

import lombok.Data;

@Data
public class VariableExpression extends Expression {
    private String obj;

    public VariableExpression(String obj) {
        this.obj = obj;
    }
}
