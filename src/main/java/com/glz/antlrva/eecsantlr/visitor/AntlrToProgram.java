package com.glz.antlrva.eecsantlr.visitor;

import com.glz.antlrva.eecsantlr.base.ExprBaseVisitor;
import com.glz.antlrva.eecsantlr.base.ExprParser;
import com.glz.antlrva.eecsantlr.model.Program;
import lombok.Data;

import java.util.List;

@Data
public class AntlrToProgram extends ExprBaseVisitor<Program> {

    private List<String> semanticErrors ;

    public AntlrToProgram(List<String> semanticErrors) {
        this.semanticErrors = semanticErrors;
    }

    @Override
    public Program visitProgram(ExprParser.ProgramContext ctx) {
        Program program = new Program();

        AntlrToExpression antlrToExpression = new AntlrToExpression(semanticErrors);
        for (int i = 0; i < ctx.getChildCount(); i++) {
            if (i == ctx.getChildCount() - 1) {

            } else {
                program.add(antlrToExpression.visit(ctx.getChild(i)));

            }
        }
        return program;
    }
}
