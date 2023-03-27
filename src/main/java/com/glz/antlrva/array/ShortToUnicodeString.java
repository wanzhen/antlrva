package com.glz.antlrva.array;

/**
 * 将{1,2,3}的short数组初始化语句转成 "\u0001\u0002\u0003"
 */
public class ShortToUnicodeString extends ArrayInitBaseListener {

    /**
     * @param ctx
     */
    @Override
    public void enterInit(ArrayInitParser.InitContext ctx) {
        System.out.print('"');
    }

    @Override
    public void exitInit(ArrayInitParser.InitContext ctx) {
        System.out.println('"');
    }

    @Override
    public void enterValue(ArrayInitParser.ValueContext ctx) {
        if (ctx.INT() != null) {
            int value = Integer.valueOf(ctx.INT().getText());
            System.out.printf("\\u%04x", value);
        }
    }


}
