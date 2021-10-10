package io.github.ziqicongdonglai.java.basic.annotation;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;

/**
 * @author ke_zhang
 * @create 2021-10-10 22:37
 * @description
 */
@Slf4j
public class MyFiledTest {

    private static MyFiled annotation;
    /**
     * 使用自定义注解
     */
    @MyFiled(description = "学习之路", length = 12)
    private String username;

    public static void main(String[] args) {
        // 获取类模板
        Class<MyFiledTest> c = MyFiledTest.class;

        // 获取所有字段
        for (Field f : c.getDeclaredFields()) {
            // 判断这个字段是否有MyField注解
            if (f.isAnnotationPresent(MyFiled.class)) {
                MyFiled annotation = f.getAnnotation(MyFiled.class);
                log.info("字段：{}，描述：{}，长度：{}", f.getName(), annotation.description(),
                        annotation.length());
            }
        }
    }
}
