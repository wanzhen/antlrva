package com.glz.antlrva.eecsantlr.model;


import lombok.Data;

@Data
public class NumExpression extends Expression {

    private Object value;

    public NumExpression(Object value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}

