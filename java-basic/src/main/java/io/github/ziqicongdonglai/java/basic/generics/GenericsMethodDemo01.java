package io.github.ziqicongdonglai.java.basic.generics;

/**
 * @author ke_zhang
 * @create 2021-11-06 0:22
 * @description 泛型方法
 */
public class GenericsMethodDemo01 {
    public static <T> void printClass(T obj) {
        System.out.println(obj.getClass().toString());
    }

    public static void main(String[] args) {
        printClass("abc");
        printClass(10);
    }
}
