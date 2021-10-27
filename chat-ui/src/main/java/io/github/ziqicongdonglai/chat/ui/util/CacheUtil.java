package io.github.ziqicongdonglai.chat.ui.util;

import io.github.ziqicongdonglai.chat.ui.view.chat.group_bar_chat.ElementTalk;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author ke_zhang
 * @create 2021-10-23 23:52
 * @description 缓存工具
 */
public class CacheUtil {

    /**
     * 对话框组
     */
    public static Map<String, ElementTalk> talkMap = new ConcurrentHashMap<>(16);

}
