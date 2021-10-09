package io.github.ziqicongdonglai.java.basic.array;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * @author ke_zhang
 * @create 2021-10-09 23:33
 * @description 数组操作：初始化、排序、二分查找
 */
public class ArrayOperation {
    private static final int MAX_SIZE = 10;

    /**
     * 初始化数组
     *
     * @return 初始化一组数组
     */
    public static int[] initialize() {
        int[] data = new int[MAX_SIZE];
        Random random = new Random();
        for (int i = 0; i < MAX_SIZE; i++) {
            int num = random.nextInt(100);
            data[i] = num;
        }
        return data;
    }

    /**
     * 输出一维数组
     *
     * @param arr 入参数组
     */
    public static void printArray(int[] arr) {
        System.out.println("\n当前数组元素为：");
        for (int n : arr) {
            System.out.printf("%-4d", n);
        }
    }

    /**
     * 二分查找
     *
     * @param arr 数组
     * @param key 待查元素
     * @return 查找成功的索引
     */
    public static int binarySearch(int[] arr, int key) {
        // 定义二分查找的左、右边界
        int low = 0;
        int high = arr.length - 1;
        // 定义middle
        int middle;
        // 要查的元素比第一个数小，比最后一个数大
        if (key < arr[low] || key > arr[high]) {
            return -1;
        }
        // 循环折半
        while (low <= high) {
            middle = (low + high) / 2;
            // 中位数比关键字大，则关键字在其左域
            if (arr[middle] > key) {
                high = middle - 1;
            } else if (arr[middle] < key) {
                // 关键字在右域
                low = middle + 1;
            } else {
                // 正好等于中位数，查找成功
                return middle;
            }
        }
        // 最后仍然没有找到，则返回-1
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(PackageConst.INFO);
        // 初始化
        int[] arr = ArrayOperation.initialize();
        printArray(arr);
        // 排序
        Arrays.sort(arr);
        printArray(arr);
        // 输入待查元素
        System.out.println("\n请输入待查元素");
        Scanner scanner = new Scanner(System.in);
        int key = scanner.nextInt();
        while (key != -1) {
            // 二分查找
            int index = binarySearch(arr, key);
            System.out.printf("\n%d 查找定位结果：%d", key, index);
            System.out.println("\n请输入待查元素");
            key = scanner.nextInt();
        }
        System.out.println("查找结束！");
    }
}
