package com.glz.antlrva.eecsantlr.model;


import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Program {

    private List<Expression> expressions;

    public Program() {
        this.expressions = new ArrayList<>();
    }

    public void add(Expression expression) {
        this.expressions.add(expression);
    }

}
