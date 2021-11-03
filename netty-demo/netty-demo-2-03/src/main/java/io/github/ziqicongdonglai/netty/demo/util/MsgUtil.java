package io.github.ziqicongdonglai.netty.demo.util;

import io.github.ziqicongdonglai.netty.demo.domain.MsgInfo;

/**
 * @author ke_zhang
 * @create 2021-11-03 20:21
 * @description
 */
public class MsgUtil {

    public static MsgInfo buildMsg(String channelId, String msgContent) {
        return new MsgInfo(channelId,msgContent);
    }

}
