package com.glz.antlrva.g4.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Parse  {
    private List<Expression> expressions = new ArrayList<>();

    public void  add(Expression expression){
        this.expressions.add(expression);
    }


}
