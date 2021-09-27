package io.github.ziqicongdonglai.java.basic.datatype;

import lombok.extern.slf4j.Slf4j;

/**
 * @author ke_zhang
 * @create 2021-09-26 21:09
 * @description Integer判等
 */
@Slf4j
public class IntegerEquals {
    public static void main(String[] args) {
        Integer  a = 127;
        Integer b = 127;
        log.info("a == b ? {}", a == b);

        Integer c = 128;
        Integer d = 128;
        log.info("c == d ? {}", c == d);

        Integer e = 127;
        Integer f = new Integer(127);
        log.info("e == f ? {}", e == f);

        Integer g = new Integer(127);
        Integer h = new Integer(127);
        log.info("g == h ? {}", g == h);

        // unbox
        Integer i = 128;
        int j = 128;
        log.info("i == j ? {}", i == j);
    }
}
