package io.github.ziqicongdonglai.java.basic.datatype;

import lombok.extern.slf4j.Slf4j;

/**
 * @author ke_zhang
 * @create 2021-09-27 19:08
 * @description 包装类装箱拆箱
 */
@Slf4j
public class BoxUnBox {
    public static void main(String[] args) {
        // 自动装箱
        Integer i1 = 10;
        // 非自动装箱
        Integer i2 = new Integer(10);
        // 非自动装箱
        Integer i3 = Integer.valueOf(10);
        // 自动拆箱
        int i4 = new Integer(10);
        // 非自动拆箱
        int i5 = i2.intValue();
        log.info("i1 = [" + i1 + "]");
        log.info("i2 = [" + i2 + "]");
        log.info("i3 = [" + i3 + "]");
        log.info("i4 = [" + i4 + "]");
        log.info("i5 = [" + i5 + "]");
        log.info("i1 == i2 is [" + (i1.equals(i2)) + "]");
        log.info("i1 == i4 is [" + (i1 == i4) + "]");
    }
}
