package io.github.ziqicongdonglai.chat.client.infrastructure.util;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author ke_zhang
 * @create 2021-11-06 23:41
 * @description 实体类工具
 */
public class BeanUtil {

    private static final Map<String, Object> CACHE_MAP = new ConcurrentHashMap<>();

    public static synchronized void addBean(String name, Object obj) {
        CACHE_MAP.put(name, obj);
    }

    public static <T> T getBean(String name, Class<T> t) {
        return (T) CACHE_MAP.get(name);
    }

}
