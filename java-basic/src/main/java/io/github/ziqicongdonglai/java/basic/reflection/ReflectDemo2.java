package io.github.ziqicongdonglai.java.basic.reflection;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * @author ke_zhang
 * @create 2021-11-09 21:30
 * @description 通过反射获取泛型信息
 */
@Slf4j
public class ReflectDemo2 {
    public void method1(Map<String, User> map, List<User> list) {
        log.info("method1");
    }

    public Map<String, User> method2() {
        log.info("method2");
        return null;
    }

    public static void main(String[] args) throws Exception {
        Method method = ReflectDemo2.class.getMethod("method1", Map.class, List.class);
        Type[] genericParameterTypes = method.getGenericParameterTypes();
        for (Type genericParameterType : genericParameterTypes) {
            log.info("泛型参数类型：{}", genericParameterType);
            if (genericParameterType instanceof ParameterizedType) {
                Type[] actualTypeArguments = ((ParameterizedType) genericParameterType).getActualTypeArguments();
                for (Type actualTypeArgument : actualTypeArguments) {
                    log.info("实际类型：{}", actualTypeArgument);
                }
            }
        }
        // 通过反射获取方法返回值信息
        method = ReflectDemo2.class.getMethod("method2", null);
        Type genericReturnType = method.getGenericReturnType();
        if (genericReturnType instanceof ParameterizedType) {
            Type[] actualTypeArguments = ((ParameterizedType) genericReturnType).getActualTypeArguments();
            for (Type actualTypeArgument: actualTypeArguments) {
                log.info("实际参数类型{}", actualTypeArgument);
            }
        }
    }
}
