package com.glz.antlrva;



import com.glz.antlrva.g4.CalculatorBaseVisitor;
import com.glz.antlrva.g4.CalculatorParser;
import lombok.extern.slf4j.Slf4j;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.glz.antlrva.g4.CalculatorParser.VOCABULARY;


@Slf4j
public class CalculatorShowImpl extends CalculatorBaseVisitor<Integer> {


    //存储变量的值
    private Map<String, Integer> variable = new HashMap<>();


    //存储变量的值
    private List<String> keyVal = new ArrayList<>();

    public List<String> getKeyVal() {
        return keyVal;
    }

    public CalculatorShowImpl(Map<String, Integer> variable) {
        this.variable = variable;
    }

    //遇到print节点，计算结果，打印出来
    @Override
    public Integer visitPrint(CalculatorParser.PrintContext ctx) {

        Integer result = ctx.expr().accept(this);
       // System.out.println(result);
        return result;
    }

    //分别获取expr节点的值，并计算乘除结果
    @Override
    public Integer visitMulDiv(CalculatorParser.MulDivContext ctx) {
        System.out.println("visitMulDiv");
        System.out.println(VOCABULARY.getLiteralName(ctx.op.getType()));
        keyVal.add(VOCABULARY.getLiteralName(ctx.op.getType()));
        Integer param1 = ctx.expr(0).accept(this);
        Integer param2 = ctx.expr(1).accept(this);
        if(ctx.op.getType() == CalculatorParser.MUL){
            return param1 * param2;
        }
        if(ctx.op.getType() == CalculatorParser.DIV){
            return param1 / param2;
        }
        return null;
    }

    //分别获取expr节点的值，并计算结果
    @Override
    public Integer visitAddSub(CalculatorParser.AddSubContext ctx) {
        System.out.println("visitAddSub");
        System.out.println(VOCABULARY.getLiteralName(ctx.op.getType()));
        keyVal.add(VOCABULARY.getLiteralName(ctx.op.getType()));
        Integer param1 = ctx.expr(0).accept(this);
        Integer param2 = ctx.expr(1).accept(this);
        if(ctx.op.getType() == CalculatorParser.ADD){
            return param1 + param2;
        }
        if(ctx.op.getType() == CalculatorParser.SUB){
            return param1 - param2;
        }
        return null;
    }

    //当遇到Id时从变量表获取数据
    @Override
    public Integer visitId(CalculatorParser.IdContext ctx) {
        System.out.println("visitId");
        System.out.println(ctx.getText());
        keyVal.add(ctx.getText());
        return variable.get(ctx.getText());
    }

    //当遇到Int节点时直接返回数据
    @Override
    public Integer visitInt(CalculatorParser.IntContext ctx) {
        System.out.println("visitInt");
        System.out.println(ctx.getText());

        keyVal.add(ctx.getText());
        return Integer.parseInt(ctx.getText());
    }

    //当遇到赋值语句时，获取右边expr的值存储到变量表中
    @Override
    public Integer visitAssign(CalculatorParser.AssignContext ctx) {
        String name = ctx.ID().getText();
        Integer value = ctx.expr().accept(this);
        variable.put(name, value);
        System.out.println("visitAssign");
        System.out.println(name);
        return super.visitAssign(ctx);
    }

    @Override
    public Integer visitParens(CalculatorParser.ParensContext ctx) {
        System.out.println("visitParens");
        System.out.println(ctx.getText());
        keyVal.add(ctx.getText());
        return visit(ctx.expr());
    }


}
