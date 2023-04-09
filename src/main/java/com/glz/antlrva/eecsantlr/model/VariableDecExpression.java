package com.glz.antlrva.eecsantlr.model;



import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
public class VariableDecExpression extends Expression {

   private String variable;

   private Object value;

   private String type;

   public String getVariable() {
      return variable;
   }

   public void setVariable(String variable) {
      this.variable = variable;
   }

   public Object getValue() {
      return value;
   }

   public void setValue(Object value) {
      this.value = value;
   }

   public String getType() {
      return type;
   }

   public void setType(String type) {
      this.type = type;
   }

   public VariableDecExpression(String variable, String value) {
      this.variable = variable;
      this.value = value;
   }

   public VariableDecExpression(String variable,String type, Object value) {
      this.variable = variable;
      this.value = value;
      this.type = type;
   }
}
