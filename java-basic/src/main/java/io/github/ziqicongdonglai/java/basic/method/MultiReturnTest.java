package io.github.ziqicongdonglai.java.basic.method;

import io.vavr.Tuple;
import io.vavr.Tuple3;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.javatuples.Triplet;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.OptionalInt;

/**
 * @author ke_zhang
 * @create 2021-10-14 18:39
 * @description 用可变长参数传入多个整数，同时返回最大值和最小值，求和等结果
 */
@Slf4j
public class MultiReturnTest {
    public static void main(String[] args) {
        int[] resultArr = multiReturnMethod1(4, 3, 5);
        log.info(Arrays.toString(resultArr));
        log.info("******************************");
        Map<String, Integer> resultMap = multiReturnMethod2(4, 3, 5);
        log.info(String.valueOf(resultMap));
        log.info("******************************");
        ReturnObject resultObject = multiReturnMethod3(4, 3, 5);
        log.info(resultObject.toString());
        log.info("******************************");
        Tuple tuple3 = multiReturnMethod4(4, 3, 5);
        log.info(String.valueOf(tuple3));
        log.info("******************************");
        Triplet<Integer, Integer, Integer> triplet = multiReturnMethod5(4, 3, 5);
        log.info(String.valueOf(triplet));
    }

    /**
     * 可变长参数+整型数组返回
     *
     * @param args 可变长参数
     * @return int[]
     */
    public static int[] multiReturnMethod1(int... args) {
        int[] arr = new int[3];
        OptionalInt max = Arrays.stream(args).max();
        OptionalInt min = Arrays.stream(args).min();
        int sum = Arrays.stream(args).sum();
        arr[0] = max.getAsInt();
        arr[1] = min.getAsInt();
        arr[2] = sum;
        return arr;
    }

    /**
     * @param args 可变长参数
     * @return Map
     */
    public static Map<String, Integer> multiReturnMethod2(int... args) {
        OptionalInt max = Arrays.stream(args).max();
        OptionalInt min = Arrays.stream(args).min();
        int sum = Arrays.stream(args).sum();
        // 初始化集合建议最好指定大小
        Map<String, Integer> map = new HashMap<>(4);
        map.put("max", max.getAsInt());
        map.put("min", min.getAsInt());
        map.put("sum", sum);
        return map;
    }

    /**
     * @param args 可变长参数
     * @return 封装的结果对象
     */
    public static ReturnObject multiReturnMethod3(int... args) {
        OptionalInt max = Arrays.stream(args).max();
        OptionalInt min = Arrays.stream(args).min();
        int sum = Arrays.stream(args).sum();
        return new ReturnObject(max.getAsInt(), min.getAsInt(), sum);
    }

    /**
     * @param args 可变长参数
     * @return Tuple3
     * 使用Tuple，需要添加依赖，类似python的元组，最多可支持8个，Tuple1~Tuple8
     * <dependency>
     *  <groupId>io.vavr</groupId>
     *  <artifactId>vavr</artifactId>
     *  <version>0.10.4</version>
     * </dependency>
     */
    public static Tuple3<Integer, Integer, Integer> multiReturnMethod4(int... args) {
        OptionalInt max = Arrays.stream(args).max();
        OptionalInt min = Arrays.stream(args).min();
        int sum = Arrays.stream(args).sum();
        return Tuple.of(max.getAsInt(), min.getAsInt(), sum);
    }

    /**
     * @param args 可变长参数
     * @return Triplet
     * 需要添加依赖，支持1个到10个
     * https://www.geeksforgeeks.org/javatuples-introduction/
     * <dependency>
     *  <groupId>org.javatuples</groupId>
     *  <artifactId>javatuples</artifactId>
     *  <version>1.2</version>
     * </dependency>
     */
    public static Triplet<Integer, Integer, Integer> multiReturnMethod5(int... args) {
        OptionalInt max = Arrays.stream(args).max();
        OptionalInt min = Arrays.stream(args).min();
        int sum = Arrays.stream(args).sum();
        return new Triplet<Integer, Integer, Integer>(max.getAsInt(), min.getAsInt(), sum);
    }
}

@AllArgsConstructor
@NoArgsConstructor
class ReturnObject {
    private Integer max;
    private Integer min;
    private Integer sum;

    @Override
    public String toString() {
        return "ReturnObject{" +
                "max=" + max +
                ", min=" + min +
                ", sum=" + sum +
                '}';
    }
}
