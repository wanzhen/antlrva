package com.glz.antlrva;


import com.glz.antlrva.g4.CalculatorBaseVisitor;
import com.glz.antlrva.g4.CalculatorParser;
import lombok.extern.slf4j.Slf4j;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.glz.antlrva.g4.CalculatorParser.VOCABULARY;


@Slf4j
public class CalculatorShowImpl2 extends CalculatorBaseVisitor<Integer> {
    private StringBuilder result = new StringBuilder();

    //存储变量的值
    private Map<String, Integer> variable = new HashMap<>();


    //存储变量的值
    private List<String> keyVal = new ArrayList<>();

    public List<String> getKeyVal() {
        return keyVal;
    }

    public CalculatorShowImpl2(Map<String, Integer> variable) {
        this.variable = variable;
    }


    @Override
    public Integer visitTerminal(TerminalNode node) {
        String text = node.getText();
        // 如果这个节点不是变量，则拼接到结果字符串中
        if (!isVariable(text)) {
            result.append(text);
        }
        // 如果这个节点是变量，则返回null，表示不需要将此节点拼接到结果字符串中
        return null;
    }

    @Override
    public Integer visitId(CalculatorParser.IdContext ctx) {
        // 访问非终止节点时，将子节点的结果拼接到结果字符串中
        result.append("这是变量" + ctx.getText());
        return null;
    }

    // 判断一个字符串是否是变量
    private boolean isVariable(String text) {
        // 根据自己的规则判断一个字符串是否是变量
        // 这里假设变量名以"$"开头
        return false;
    }

    // 获取最终结果字符串
    public String getResult() {
        return result.toString();
    }
}
