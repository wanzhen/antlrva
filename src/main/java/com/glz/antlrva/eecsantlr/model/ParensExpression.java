package com.glz.antlrva.eecsantlr.model;

 import lombok.Data;

@Data
public class ParensExpression extends Expression  {

    Expression chileExpression;

    public ParensExpression(Expression chileExpression) {
        this.chileExpression = chileExpression;
    }

    @Override
    public String toString() {
        return "(" + chileExpression.toString() +")";
    }


}
