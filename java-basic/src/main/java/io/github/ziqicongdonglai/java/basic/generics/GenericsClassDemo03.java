package io.github.ziqicongdonglai.java.basic.generics;

/**
 * @author ke_zhang
 * @create 2021-11-06 0:17
 * @description 泛型类的类型嵌套
 */
public class GenericsClassDemo03 {
    public static void main(String[] args) {
        Info<String> info = new Info("Hello");
        MyMap<Integer, Info<String>> map = new MyMap<>(1, info);
        System.out.println(map);
    }
}
