package com.glz.antlrva.eecsantlr;

import cn.hutool.core.collection.CollUtil;
import com.glz.antlrva.eecsantlr.base.ExprLexer;
import com.glz.antlrva.eecsantlr.base.ExprParser;
import com.glz.antlrva.eecsantlr.listener.MyErrorListener;
import com.glz.antlrva.eecsantlr.model.Program;
import com.glz.antlrva.eecsantlr.visitor.AntlrToProgram;
import lombok.extern.slf4j.Slf4j;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ExpressionApp {
    public static void main(String[] args) {
        InputStream in = ExpressionApp.class.getResourceAsStream("/" + "eecsantlr/test1.txt");
        if (args.length != 1) {
            System.err.println("Usage: file name");
        } else {
            new ExpressionApp().calc(args[0]);
        }
    }

    public void calc(String fileName) {
        ExprParser exprParser = getParser(fileName);



        // syntax error handling
        MyErrorListener errorListener = new MyErrorListener();
        exprParser.removeErrorListeners();
        exprParser.addErrorListener(errorListener);


        //tell antrl to build a parse tree
        // parse from the start symbol 'prog'
        ParseTree antlrAST = exprParser.prog();

        if (errorListener.getHasError()) {
            log.info("has syntax error");
            return;
        }

        List<String> semanticErrors = new ArrayList<>();
        // create a visitor for converting the parse tree into program/expression object
        AntlrToProgram progVisitor = new AntlrToProgram(semanticErrors);
        Program program = progVisitor.visit(antlrAST);
        if (CollUtil.isEmpty(semanticErrors)) {
            ExpressionProcessor expressionProcessor = new ExpressionProcessor(program.getExpressions());
            List<String> evalResults = expressionProcessor.getEvaluationResults();
            for (String str : evalResults) {
                System.out.println(str);
            }
        } else {
            for (String err : semanticErrors) {
                System.out.println(err);
            }
        }
    }

    /**
     * Here tye  types of parser and lexer are specific to the grammar name Expr.g4
     *
     * @param fileName
     * @return
     */
    private static ExprParser getParser(String fileName) {
        ExprParser parser = null;
        try {
            CharStream input = CharStreams.fromFileName(fileName);
            ExprLexer exprLexer = new ExprLexer(input);
            CommonTokenStream commonTokenStream = new CommonTokenStream(exprLexer);
            parser = new ExprParser(commonTokenStream);

            return parser;
        } catch (IOException e) {
            return null;
        }
    }
}
