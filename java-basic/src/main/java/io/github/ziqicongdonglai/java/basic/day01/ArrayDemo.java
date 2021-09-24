package io.github.ziqicongdonglai.java.basic.day01;

/**
 * @author ke_zhang
 * @create 2021-09-23 21:27
 * @description 数组练习
 */
public class ArrayDemo {
    /**
     * 求数组元素之和
     *
     * @param array 整型形参数组
     * @return int：元素之和
     */
    public int getSum(int[] array) {
        // sum为累加器，初始化为0
        int sum = 0;
        /*
         以下通过循环遍历数组，累加求和
         */
        for (int i = 0; i < array.length; i++) {
            sum += i;
        }
        // 返回sum
        return sum;
    }
}
