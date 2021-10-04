package io.github.ziqicongdonglai.java.basic.sort;

import lombok.extern.slf4j.Slf4j;

/**
 * @author ke_zhang
 * @create 2021-10-04 19:06
 * @description 选择排序
 */
@Slf4j
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {24, 69, 80, 57, 13};
        selectSort(arr);
    }

    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }

        for (int j : arr) {
            log.info(j + " ");
        }
    }
}
