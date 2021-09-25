package io.github.ziqicongdonglai.java.basic.variable;

/**
 * @author ke_zhang
 * @create 2021-09-25 21:11
 * @description 基础类型变量
 */
public class BaseVar {
    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        /**
         * 变量定义格式：
         * 数据类型 变量名;
         * 数据类型 变量名 = 变量值;
         */

        /*
          以下为布尔型
         */

        // 布尔类型未赋值
        boolean boolNoValue;

        // 布尔赋值 true
        boolean boolTrue = true;

        // 布尔赋值一个计算结果
        boolean boolWithResult = 2 > 1;

        // 布尔赋值 非 true 或 false 会编译报错
        // boolean boolCompileError = 123;

        /*
          以下整数类型
         */

        // 字节赋值 8
        byte byteDemo = 8;

        // 赋值越界会编译报错
        //byte byteOutOfBounds = 188;

        // 短整型赋值 188
        short shortDemo = 188;

        // 整型赋值 38888
        int intDemo = 38888;

        // 整型赋值带下划线，提高辨识度
        int intDemoWithUnderLine = 1888_888_888;

        // 十六进制表示 16711680
        int intDemoWithHex = 0xff0000;

        // 二进制表示的512
        int intDemoWithBinary = 0b1000000000;

        // long型的结尾需要加 L
        long longWithSuffix = 2147483649L;

        /*
          以下为浮点数类型
         */

        // 单精度浮点数赋值，加 f 后缀
        float floatDemo = 9.18f;

        // 负的单精度浮点数
        float floatNegDemo = -9.18f;

        // 科学计数法表示的 3.14×10^38，float 类型可表示的最大数
        float floatDemoWithSci = 3.14e38f;

        // 科学计数法表示的1.79×10^308，double类型可表示的最大数
        double doubleDemo = 1.79e308;

        /*
          以下为字符类型
          Java 的 字符类可表示标准的 ASCII 和 一个 Unicode 字符
         */

        // char 用 ascii 字符赋值
        char charWithAscii = '.';

        // char 用 Unicode 字符赋值
        char charWithUnicode = '牛';

        // char 多字符会编译报错
        // char charCompileError = '蜗牛';
    }
}
