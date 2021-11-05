package io.github.ziqicongdonglai.java.basic.generics;

import java.util.Arrays;
import java.util.List;

/**
 * @author ke_zhang
 * @create 2021-11-06 0:31
 * @description 无界通配符
 */
public class GenericsUnboundedWildcardDemo {
    public static void printList(List<?> list) {
        for (Object elem : list) {
            System.out.print(elem + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        List<Integer> li = Arrays.asList(1, 2, 3);
        List<String> ls = Arrays.asList("one", "two", "three");
        printList(li);
        printList(ls);
    }
}
