package com.glz.antlrva.eecsantlr;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

class ExpressionAppTest {

    private ExpressionApp expressionApp;

    @BeforeEach
    void before() {
        expressionApp = new ExpressionApp();
    }


    @Test
    void testMain() {
    }
    @Test
    void test3() {
        String fileName  = "eecsantlr/test3.txt";
        String path = getPath(fileName);
        expressionApp.calc(path);
    }

    @Test
    void test2() {
        String fileName  = "eecsantlr/test2.txt";
        String path = getPath(fileName);
        expressionApp.calc(path);
    }
    @Test
    void test4() {
        String fileName  = "eecsantlr/test4.txt";
        String path = getPath(fileName);
        expressionApp.calc(path);
    }
    @Test
    void test5() {
        String fileName  = "eecsantlr/test5.txt";
        String path = getPath(fileName);
        expressionApp.calc(path);
    }
    @Test
    void testSyntax() {
        String fileName  = "eecsantlr/test6.txt";
        String path = getPath(fileName);
        expressionApp.calc(path);
    }

    @Test
    void calc() {
        String fileName  = "eecsantlr/test1.txt";
        String path = getPath(fileName);
        expressionApp.calc(path);
    }
    private String getPath(String fileName){
        String os = System.getProperty("os.name");
        String path ="";
        if (os.startsWith("Windows")) {
            path = System.getProperty("user.dir") + File.separator + "src"+ File.separator + "test"+ File.separator+"resources" + File.separator + fileName;
        }else {
            path = ExpressionAppTest.class.getClassLoader().getResource("").getPath() + fileName;
        }
        return path;
    }
}