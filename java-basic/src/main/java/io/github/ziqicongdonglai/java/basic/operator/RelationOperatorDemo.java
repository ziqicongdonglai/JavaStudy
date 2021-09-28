package io.github.ziqicongdonglai.java.basic.operator;

import lombok.extern.slf4j.Slf4j;

/**
 * @author ke_zhang
 * @create 2021-09-28 21:12
 * @description 关系操作符示例
 */
@Slf4j
public class RelationOperatorDemo {
    public static void main(String[] args) {
        int x = 20;
        int y = 10;
        log.info("x == y = " + (x == y));
        log.info("x != y = " + (x != y));
        log.info("x > y = " + (x > y));
        log.info("x < y = " + (x < y));
        log.info("x >= y = " + (x >= y));
        log.info("x <= y = " + (x <= y));
    }
}
