package io.github.ziqicongdonglai.java.basic.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ke_zhang
 * @create 2021-11-06 0:10
 * @description 没有使用泛型
 */
public class NoGenericsDemo {
    public static void main(String[] args) {
        List list = new ArrayList<>();
        list.add("abc");
        list.add(18);
        list.add(new double[] {1.0, 2.0});
        Object obj1 = list.get(0);
        Object obj2 = list.get(1);
        Object obj3 = list.get(2);
        System.out.println("obj1 = [" + obj1 + "]");
        System.out.println("obj2 = [" + obj2 + "]");
        System.out.println("obj3 = [" + obj3 + "]");
        int num1 = (int)list.get(0);
        int num2 = (int)list.get(1);
        int num3 = (int)list.get(2);
        System.out.println("num1 = [" + num1 + "]");
        System.out.println("num2 = [" + num2 + "]");
        System.out.println("num3 = [" + num3 + "]");
    }
}
