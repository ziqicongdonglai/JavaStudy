package io.github.ziqicongdonglai.netty.demo.util;

import io.github.ziqicongdonglai.netty.demo.domain.FileBurstInstruct;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author ke_zhang
 * @create 2021-11-03 20:47
 * @description
 */
public class CacheUtil {

    public static Map<String, FileBurstInstruct> burstDataMap = new ConcurrentHashMap<>();

}
