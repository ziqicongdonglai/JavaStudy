package io.github.ziqicongdonglai.java.basic.generics;

/**
 * @author ke_zhang
 * @create 2021-11-06 0:25
 * @description 类型边界
 */
public class GenericsExtendsDemo01 {
    static <T extends Comparable<T>> T max(T x, T y, T z) {
        T max = x; // 假设x是初始最⼤值
        if (y.compareTo(max) > 0) {
            max = y; //y 更⼤
        }
        if (z.compareTo(max) > 0) {
            max = z; // 现在 z 更⼤
        }
        return max; // 返回最⼤对象
    }

    public static void main(String[] args) {
        System.out.println(max(3, 4, 5));
        System.out.println(max(6.6, 8.8, 7.7));
        System.out.println(max("pear", "apple", "orange"));
    }
}
