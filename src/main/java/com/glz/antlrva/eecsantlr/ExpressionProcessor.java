package com.glz.antlrva.eecsantlr;


import com.glz.antlrva.eecsantlr.model.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExpressionProcessor {
    List<Expression> list;

    /**
     * symbol table for storing  values  of variables
     */
    public Map<String, Object> values;

    public ExpressionProcessor(List<Expression> list) {
        this.list = list;
        values = new HashMap<>();
    }


    public List<String> getEvaluationResults() {
        List<String> evaluations = new ArrayList<>();
        for (Expression e : list) {
            if (e instanceof VariableDecExpression) {
                VariableDecExpression decExpression = (VariableDecExpression) e;
                values.put(decExpression.getVariable(), decExpression.getValue());
                evaluations.add(decExpression.getVariable() + " is " + decExpression.getValue());
            } else { //e instanceof Number Variable Addition Subtraction
                String input = e.toString();
                Object result = getEvalResult(e);
                evaluations.add(input + " is " + result);
            }
        }
        return evaluations;
    }

    private Object getEvalResult(Expression e) {
        Double result = 0.00;
        if (e instanceof NumExpression) {
            NumExpression numExpression = (NumExpression) e;
            result = (Double) numExpression.getValue();
        } else if (e instanceof VariableExpression) {
            VariableExpression variableExpression = (VariableExpression) e;
            result = (Double) values.get(variableExpression.getVariable());
        } else if (e instanceof AddExpression) {
            AddExpression addExpression = (AddExpression) e;
            Double left = (Double) getEvalResult(addExpression.getLeft());
            Double right = (Double) getEvalResult(addExpression.getRight());
            result = left + right;
        } else if (e instanceof SubExpression) {
            SubExpression subExpression = (SubExpression) e;
            Double left = (Double) getEvalResult(subExpression.getLeft());
            Double right = (Double) getEvalResult(subExpression.getRight());
            result = left - right;
        } else if (e instanceof MultiExpression) {
            MultiExpression multiExpression = (MultiExpression) e;
            Double left = (Double) getEvalResult(multiExpression.getLeft());
            Double right = (Double) getEvalResult(multiExpression.getRight());
            result = left * right;
        }else if (e instanceof DivExpression) {
            DivExpression divExpression = (DivExpression) e;
            Double left = (Double) getEvalResult(divExpression.getLeft());
            Double right = (Double) getEvalResult(divExpression.getRight());
            result = left / right;
        } else if (e instanceof ParensExpression) {
            ParensExpression parensExpression = (ParensExpression) e;
            result = (Double) getEvalResult(parensExpression.getChileExpression());
        }
        return result;
    }
}
