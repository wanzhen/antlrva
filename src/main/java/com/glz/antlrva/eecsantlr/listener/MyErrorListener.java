package com.glz.antlrva.eecsantlr.listener;

import lombok.Data;
import org.antlr.v4.runtime.*;

import java.util.Collections;
import java.util.List;

@Data
public class MyErrorListener extends BaseErrorListener {

    private Boolean hasError = false;

    public Boolean getHasError() {
        return hasError;
    }

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer,
                            Object offendingSymbol,
                            int line,
                            int charPositionInLine,
                            String msg,
                            RecognitionException e) {


        super.syntaxError(recognizer, offendingSymbol, line, charPositionInLine, msg, e);

        hasError = true;

        List<String> stack = ((Parser) recognizer).getRuleInvocationStack();

        Collections.reverse(stack);
        System.err.println("Syntax Error!");
        System.err.println("Token " + "\"" + ((Token) offendingSymbol).getText() + "\""
                +
                "(line " + line + ", colume " + (charPositionInLine + 1) + ")"
                +
                ": " + msg
        );
        System.err.println("Rule Stack: " + stack);
    }
}
