package com.glz.antlrva.g4.model;


import lombok.Data;

@Data
public class VariableDecExpression extends Expression {

   private String variable;

   private Object value;

   private Object type;

   public VariableDecExpression(String variable, Object value) {
      this.variable = variable;
      this.value = value;
   }
}
