package io.github.ziqicongdonglai.java.basic.datatype;

import lombok.extern.slf4j.Slf4j;

/**
 * @author ke_zhang
 * @create 2021-09-26 21:10
 * @description 字符串判等
 */
@Slf4j
public class StringEquals {
    public static void main(String[] args) {
        String a = "1";
        String b = "1";
        log.info("a == b ? {}", a == b);

        String c = new String("2");
        String d = new String("2");
        log.info("c == d ? {}", c == d);

        String e = new String("3").intern();
        String f = new String("3").intern();
        log.info("e == f ? {}", e == f);

        String g = new String("4");
        String h = new String("4");
        log.info("g.equals(h) ? {}", g.equals(h));
    }
}
