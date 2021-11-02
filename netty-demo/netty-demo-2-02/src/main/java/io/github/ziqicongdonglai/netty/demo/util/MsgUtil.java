package io.github.ziqicongdonglai.netty.demo.util;

import io.github.ziqicongdonglai.netty.demo.domain.MsgBody;

/**
 * @author ke_zhang
 * @create 2021-11-02 23:47
 * @description
 */
public class MsgUtil {

    /**
     * 构建protobuf消息体
     */
    public static MsgBody buildMsg(String channelId, String msgInfo) {
        MsgBody.Builder msg = MsgBody.newBuilder();
        msg.setChannelId(channelId);
        msg.setMsgInfo(msgInfo);
        return msg.build();
    }

}
