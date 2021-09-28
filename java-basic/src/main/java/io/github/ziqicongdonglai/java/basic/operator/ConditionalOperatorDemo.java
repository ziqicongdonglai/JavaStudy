package io.github.ziqicongdonglai.java.basic.operator;

import lombok.extern.slf4j.Slf4j;

/**
 * @author ke_zhang
 * @create 2021-09-28 21:16
 * @description 三目运算符
 */
@Slf4j
public class ConditionalOperatorDemo {
    public static void main(String[] args) {
        int a,b;
        a = 10;
        b = (a == 1) ? 20 : 30;
        log.info("Value of b is :" +b);

        b = (a == 10) ? 20 : 30;
        log.info("Value of b is : " + b);
    }
}
