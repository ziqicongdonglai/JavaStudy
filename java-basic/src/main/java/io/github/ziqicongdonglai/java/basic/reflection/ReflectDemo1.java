package io.github.ziqicongdonglai.java.basic.reflection;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author ke_zhang
 * @create 2021-11-09 20:48
 * @description 动态创建对象执行方法
 */
@Slf4j
public class ReflectDemo1 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException,
            InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        // 获得class对象
        Class<?> clazz = Class.forName("io.github.ziqicongdonglai.java.basic.reflection.User");
        // 1.构造一个对象，本质是无参构造器
        User user1 = (User) clazz.getDeclaredConstructor().newInstance();
        log.info("user1:{}", user1);

        // 2.通过构造器创建对象
        Constructor<?> constructor = clazz.getDeclaredConstructor(Integer.class, String.class);
        User user2 = (User) constructor.newInstance(1, "王小明");
        log.info("user2:{}", user2);

        //3.通过反射调用普通方法
        User user3 = (User) clazz.getDeclaredConstructor().newInstance();
        Method setName = clazz.getDeclaredMethod("setName", String.class);
        // invoke激活
        setName.invoke(user3, "王明");
        log.info("user3.name{}", user3.getName());

        // 4.通过反射操作属性（即使私有也照样可以，OMG）
        User user4 = (User) clazz.getDeclaredConstructor().newInstance();
        Field name = clazz.getDeclaredField("name");
        // true：取消Java语言访问检查
        name.setAccessible(true);
        name.set(user4, "王明明");
        log.info("user4.name{}", user4.getName());
    }
}
