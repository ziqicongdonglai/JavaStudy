package io.github.ziqicongdonglai.java.basic.reflect;

import lombok.extern.slf4j.Slf4j;

/**
 * @author ke_zhang
 * @create 2021-10-07 18:47
 * @description 目标类
 */
@Slf4j
public class TargetObject {
    private final String value;

    public TargetObject() {
        this.value = "default";
    }

    public void publicMethod(String s) {
        log.info("I love" + s);
    }

    private void privateMethod() {
        log.info("value is " + value);
    }
}
