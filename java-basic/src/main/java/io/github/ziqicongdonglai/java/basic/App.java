package io.github.ziqicongdonglai.java.basic;

import io.github.ziqicongdonglai.java.basic.array.ArrayDemo;

/**
 * @author ke_zhang
 * @create 2021-09-23 21:25
 * @description
 */
public class App {
    public static void main(String[] args) {
        System.out.println("app launch");
        int[] arr = {1, 2, 3, 4, 5};
        ArrayDemo ad = new ArrayDemo();
        int sum = ad.getSum(arr);
        System.out.println("sum = git" + sum);
    }
}
