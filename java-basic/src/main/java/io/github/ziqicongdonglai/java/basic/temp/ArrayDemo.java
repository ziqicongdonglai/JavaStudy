package io.github.ziqicongdonglai.java.basic.temp;

import java.util.Arrays;
import java.util.Random;

/**
 * @author ke_zhang
 * @create 2021-09-30 8:21
 * @description 数组测试程序
 */
public class ArrayDemo {
    public static void main(String[] args) {
        //int[] arr = new int[3]{1, 2, 3};
        //System.out.println(arr);
        //int[] arr1 = new int[] {1, 2, 3};
        //System.out.println(Arrays.toString(arr1));

        //int n = 3;
        //数组长度可以给变量
        //int[] arr = new int[n];

        char[] ch = {'a', 'b', 'c'};
        // public final int length
        // 数组长度是常量 声明定义（或同时赋值后）不好改了
        int length = ch.length;
        //ch[3] = 'd';
        //for (char c : ch) {
        //    System.out.println(c);
        //}

        //int[][] arr1 = new int[2][2];
        //arr1[0][1] = 8;
        //arr1[1][0] = 9;
        //System.out.println(Arrays.deepToString(arr1));

        // 相当于只能放两个元素的一维数组
        //int[][] arr = new int[2][];
        // 长度不一定
        //arr[0] = new int[3];
        //arr[1] = new int[4];
        //System.out.println(arr[0].length);
        //System.out.println(arr[1].length);
        //System.out.println(arr.length);

        //int[][] arr = {{1, 2}, {3, 4}};
        //System.out.println(arr.length);

        Random random = new Random();
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = random.nextInt(100);
        }
        // Arrays
        //System.out.println(Arrays.toString(arr));
        //// 排序
        //Arrays.sort(arr);
        //System.out.println(Arrays.toString(arr));
        Arrays.fill(arr, 2, 4, 88);

        //int i = 0;
        //int j = 0;
        String[][] poem1 = new String[][]{
                {"春眠不觉晓，"}, {"处处闻啼鸟。"},
                {"夜来风雨声，"}, {"花落知多少。"}
        };
        for (int i = 0; i < poem1.length; i++) {
            for (int j = 0; j < poem1[i].length; j++) {
                System.out.println(poem1[i][j]);
            }
        }
        String[][] poem2 = new String[][]{
                {"花夜处春"}, {"落来处眠"}, {"知风闻不"},
                {"多雨啼觉"}, {"少声鸟晓"}, {"。，。，"}
        };
        for (int i = 0; i < poem2.length; i++) {
            for (int j = 0; j < poem2[i].length; j++) {
                System.out.println(poem2[i][j]);
            }
        }

        int[] arr1 = new int[] {1, 2, 3};
        int[] arr2 = {1, 2, 3};
        int[] arr3 = {1, 2, 3};
        System.out.println(Arrays.equals(arr1, arr2));
        System.out.println(arr3 == arr2);
    }
}
