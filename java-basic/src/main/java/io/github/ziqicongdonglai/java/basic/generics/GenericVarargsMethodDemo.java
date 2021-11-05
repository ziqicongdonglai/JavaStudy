package io.github.ziqicongdonglai.java.basic.generics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author ke_zhang
 * @create 2021-11-06 0:23
 * @description 泛型⽅法中也可以使⽤可变参数列表
 */
public class GenericVarargsMethodDemo {
    public static <T> List<T> makeList(T... args) {
        List<T> result = new ArrayList<T>();
        Collections.addAll(result, args);
        return result;
    }
    public static void main(String[] args) {
        List<String> ls = makeList("A");
        System.out.println(ls);
        ls = makeList("A", "B", "C");
        System.out.println(ls);
    }
}
