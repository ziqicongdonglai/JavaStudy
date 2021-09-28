package io.github.ziqicongdonglai.java.basic.operator;

import lombok.extern.slf4j.Slf4j;

/**
 * @author ke_zhang
 * @create 2021-09-28 21:29
 * @description Instanceof操作符示例
 */
@Slf4j
public class InstanceOfOperatorDemo {
    public static void main(String[] args) {
        Animal animal = new Cat();
        boolean result = animal instanceof Cat;
        log.info(String.valueOf(result));
    }

    static class Animal {

    }

    static class Cat extends Animal {

    }
}
