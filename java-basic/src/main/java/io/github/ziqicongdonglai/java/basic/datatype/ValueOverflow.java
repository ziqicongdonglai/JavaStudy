package io.github.ziqicongdonglai.java.basic.datatype;

import lombok.extern.slf4j.Slf4j;

import java.math.BigInteger;

/**
 * @author ke_zhang
 * @create 2021-09-26 21:08
 * @description 数值溢出
 */
@Slf4j
public class ValueOverflow {
    public static void main(String[] args) {
        log.info("=============== wrong1 ===============");
        wrong();
        log.info("=============== right1 ===============");
        right1();
        log.info("=============== right2 ===============");
        right2();
    }

    private static void wrong() {
        long l = Long.MAX_VALUE;
        log.info(String.valueOf(l + 1));
        log.info(String.valueOf(l + 1 == Long.MIN_VALUE));
    }

    private static void right1() {
        try {
            long l = Long.MAX_VALUE;
            // Math.addExact
            // 返回其参数的总和，如果结果溢出long，则抛出 long 。
            System.out.println(Math.addExact(l, 1));
        } catch (Exception ex) {
            log.error(ex.toString());
        }
    }

    private static void right2() {
        BigInteger i = new BigInteger(String.valueOf(Long.MAX_VALUE));
        log.info(i.add(BigInteger.ONE).toString());
        try {
            // .logValueExact
            // 将此 BigInteger转换为 long ，检查丢失的信息。
            // 如果超出 BigInteger的范围 抛出 算术异常
            long longValue = i.add(BigInteger.ONE).longValueExact();
            log.info(String.valueOf(longValue));
        } catch (Exception ex) {
            log.error(ex.toString());
        }
    }
}
