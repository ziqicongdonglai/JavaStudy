package io.github.ziqicongdonglai.java.basic.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ke_zhang
 * @create 2021-11-06 0:31
 * @description 使⽤通配符来向上转型
 */
public class GenericsWildcardDemo {
    public static void main(String[] args) {
        List<Integer> intList = new ArrayList<>();
        //List<Number> numList = intList; // Error
        List<? extends Integer> intList2 = new ArrayList<>();
        List<? extends Number> numList2 = intList2; // OK
    }
}
