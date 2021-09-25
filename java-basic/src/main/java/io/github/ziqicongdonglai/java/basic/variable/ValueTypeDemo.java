package io.github.ziqicongdonglai.java.basic.variable;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Method;

/**
 * @author ke_zhang
 * @create 2021-09-25 16:13
 * @description 值类型使用示例
 */
@Slf4j
public class ValueTypeDemo {
    public static void demo1() {
        // compile error
        // int num = 99999999999999999999999999999999;
    }

    public static void demo10() {
        // 浮点型
        float f = 30.3f;
        // 强转类型转换
        int x = (int) f;
        log.info("x = {}", x);
        // 执行强转转换
        log.info("10 / 3 = {}", ((float) 10 / 3));
    }

    public static void demo2() {
        int max = Integer.MAX_VALUE;
        log.info("整型的最大值：{}", max);
        log.info("整型的最大值 + 1：{}", (max + 1));
        log.info("整型的最大值 + 2：{}", (max + 2));
        log.info("整型的最大值 + 2：{}", ((long)max + 2));
    }

    public static void demo3() {
        // 字符是使用“ ’ ”括起来的数据
        char ch1 = 'a';
        // 通过数学定义字符变量
        char ch2 = 97;
        log.info("ch1 = {}", ch1);
        log.info("ch2 = {}", ch2);
    }

    public static void demo4() {
        // 表示的是一个"
        char ch1 = '\"';
        // 表示的是一个\
        char ch2 = '\\';
        log.info("ch1 = {}", ch1);
        log.info("ch2 = {}", ch2);
        log.info("\"Hello World!\"");
    }

    public static void demo5() {
        // 定义一浮点型变量
        float num = 3.0f;
        log.info("两个小数相乘：{}", num * num);
    }

    public static void demo6() {
        // 定义布尔型变量
        boolean flag = true;
        // 打印输出
        log.info("flag = {}", flag);
    }

    public static void demo7() {
        // 定义整型变量
        int x = 30;
        // 定义浮点型变量
        float y = 22.19f;
        log.info("x / y = {}", (x / y));
        log.info("10 / 3.5 = {}", (10 / 3.5));
        log.info("10 / 3 = {}", (10 / 3));
    }

    public static void demo8() {
        // 定义字符串变量
        String str = "Super Man";
        int x = 30;
        // 修改str的内容并将内容重新给str变量
        str = str + x;
        log.info("str = {}", str);
    }

    public static void demo9() {
        // 定义整型变量
        int i = 1;
        // 定义整型变量
        int j = 2;
        log.info("i + 2 = {}", i + 2);
        log.info("j + 2 = {}", (j + 2));
    }

    public static void main(String[] args) throws Exception {
        for (int i = 1; i <= 10; i++) {
            Method method = ValueTypeDemo.class.getMethod("demo" + i);
            method.invoke(null);
        }
    }
}
