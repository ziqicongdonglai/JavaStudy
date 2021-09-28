package io.github.ziqicongdonglai.java.basic.operator;

import lombok.extern.slf4j.Slf4j;

/**
 * @author ke_zhang
 * @create 2021-09-28 21:03
 * @description 逻辑操作符示例
 */
@Slf4j
public class LogicalOperatorDemo {
    public static void main(String[] args) {
        boolean a = true;
        boolean b = false;

        log.info("a && b = " + (a && b));
        log.info("a || b = " + (a || b));
        log.info("!(a && b) = " + !(a && b));
    }
}
