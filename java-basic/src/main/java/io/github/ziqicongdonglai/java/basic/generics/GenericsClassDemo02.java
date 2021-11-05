package io.github.ziqicongdonglai.java.basic.generics;

/**
 * @author ke_zhang
 * @create 2021-11-06 0:16
 * @description 多个类型参数的泛型
 */
public class GenericsClassDemo02 {
    public static void main(String[] args) {
        MyMap<Integer, String> map = new MyMap<>(1, "one");
        System.out.println(map);
    }
}
