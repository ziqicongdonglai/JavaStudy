package io.github.ziqicongdonglai.java.basic.reflection;

import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @author ke_zhang
 * @create 2021-11-09 22:18
 * @description 通过反射获取配置文件中内容调用类中方法
 */
public class ReflectDemo5 {
    public static void main(String[] args) throws Exception{
        Properties properties = new Properties();;
        properties.load(new FileReader("Class.txt"));

        String className = properties.getProperty("className");
        String methodName = properties.getProperty("methodName");

        Class<?> clazz = Class.forName(className);
        Method method = clazz.getMethod(methodName);
        method.invoke(clazz.getDeclaredConstructor().newInstance());

    }
}
