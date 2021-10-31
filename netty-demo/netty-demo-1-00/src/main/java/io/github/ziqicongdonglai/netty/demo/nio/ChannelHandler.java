package io.github.ziqicongdonglai.netty.demo.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

/**
 * @author ke_zhang
 * @create 2021-10-30 23:30
 * @description ChannelHandler
 */
public class ChannelHandler {

    private final SocketChannel channel;
    private final Charset charset;

    public ChannelHandler(SocketChannel channel, Charset charset) {
        this.channel = channel;
        this.charset = charset;
    }

    public void writeAndFlush(Object msg) {
        try {
            byte[] bytes = msg.toString().getBytes(charset);
            ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);
            writeBuffer.put(bytes);
            writeBuffer.flip();
            channel.write(writeBuffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public SocketChannel channel() {
        return channel;
    }
}
