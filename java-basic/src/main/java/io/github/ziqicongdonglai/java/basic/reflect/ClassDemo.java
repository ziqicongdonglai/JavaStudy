package io.github.ziqicongdonglai.java.basic.reflect;

import lombok.extern.slf4j.Slf4j;

/**
 * @author ke_zhang
 * @create 2021-10-06 20:32
 * @description
 * Java反射之Class类的练习
 * 在面向对象的语言里，万事万物皆对象，那么类是谁的对象呢？
 * 类的类型是Class
 * 反射机制，欲获取一个类或者调用某个类的方法，首先要获取到该类的 Class 对象
 */
@Slf4j
public class ClassDemo {
    public static void main(String[] args) {
        // 在 Java API 中，提供了获取 Class 类对象的三种方法

        // 第一种，使用 Class.forName 静态方法，前提：已明确类的全路径名。
        Class clazz1 = null;
        try {
            clazz1 = Class.forName("io.github.ziqicongdonglai.java.basic.reflect.User");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // 第二种，使用.class 方法，说明：仅适合在编译前就已经明确要操作的 Class
        Class clazz2 = User.class;

        // 第三种，使用类对象的 getClass()方法，适合有对象示例的情况下
        User user = new User();
        Class clazz3 = user.getClass();

        // 结果
        log.info("clazz——clazz2——clazz3：{},{},{}", clazz1, clazz2, clazz3);
        log.info(String.valueOf(clazz1 == clazz2));
        log.info(String.valueOf(clazz3 == clazz2));
    }
}
