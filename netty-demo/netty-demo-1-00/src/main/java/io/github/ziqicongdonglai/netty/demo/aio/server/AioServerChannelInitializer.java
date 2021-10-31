package io.github.ziqicongdonglai.netty.demo.aio.server;

import io.github.ziqicongdonglai.netty.demo.aio.ChannelInitializer;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;

/**
 * @author ke_zhang
 * @create 2021-10-30 23:26
 * @description 服务端初始化
 */
public class AioServerChannelInitializer extends ChannelInitializer {

    @Override
    protected void initChannel(AsynchronousSocketChannel channel) throws Exception {
        channel.read(ByteBuffer.allocate(1024), 10, TimeUnit.SECONDS, null, new AioServerHandler(channel, StandardCharsets.UTF_8));
    }

}
