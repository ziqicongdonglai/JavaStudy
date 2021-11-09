package io.github.ziqicongdonglai.java.basic.reflection;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author ke_zhang
 * @create 2021-11-09 21:55
 * @description 属性注解
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface FieldSu {
    String columnName();

    String type();

    int length();
}
