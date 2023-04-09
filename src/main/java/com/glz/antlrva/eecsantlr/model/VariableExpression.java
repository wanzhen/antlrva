package com.glz.antlrva.eecsantlr.model;

import com.glz.antlrva.eecsantlr.model.Expression;
import lombok.Data;

@Data
public class VariableExpression extends Expression {

    private String variable;

    public VariableExpression(String variable) {
        this.variable = variable;
    }

    @Override
    public String toString() {
        return variable;
    }
}
