package io.github.ziqicongdonglai.java.basic.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author ke_zhang
 * @create 2021-10-10 22:38
 * @description 自定义注释
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyFiled {
    String description();
    int length();
}
