package io.github.ziqicongdonglai.netty.demo.server;

import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

/**
 * @author ke_zhang
 * @create 2021-10-31 20:10
 * @description Channel信息处理器
 */
public class ChannelHandler {
    /**
     * 用于存放用户Channel信息，也可以建立map结构模拟不同的消息群
     */
    public static ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
}
