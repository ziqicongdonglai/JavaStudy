package io.github.ziqicongdonglai.netty.demo.aio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;

/**
 * @author ke_zhang
 * @create 2021-10-30 23:26
 * @description Channle适配器模仿Netty
 */
public abstract class ChannelAdapter implements CompletionHandler<Integer, Object> {

    private final AsynchronousSocketChannel channel;
    private final Charset charset;

    public ChannelAdapter(AsynchronousSocketChannel channel, Charset charset) {
        this.channel = channel;
        this.charset = charset;
        if (channel.isOpen()) {
            channelActive(new ChannelHandler(channel, charset));
        }
    }

    @Override
    public void completed(Integer result, Object attachment) {
        try {
            final ByteBuffer buffer = ByteBuffer.allocate(1024);
            final long timeout = 60 * 60L;
            channel.read(buffer, timeout, TimeUnit.SECONDS, null, new CompletionHandler<>() {
                @Override
                public void completed(Integer result, Object attachment) {
                    if (result == -1) {
                        try {
                            channelInactive(new ChannelHandler(channel, charset));
                            channel.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        return;
                    }
                    buffer.flip();
                    channelRead(new ChannelHandler(channel, charset), charset.decode(buffer));
                    buffer.clear();
                    channel.read(buffer, timeout, TimeUnit.SECONDS, null, this);
                }

                @Override
                public void failed(Throwable exc, Object attachment) {
                    exc.printStackTrace();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void failed(Throwable exc, Object attachment) {
        exc.getStackTrace();
    }


    public abstract void channelActive(ChannelHandler ctx);

    public abstract void channelInactive(ChannelHandler ctx);

    /**
     * 读取消息抽象类
     *
     * @param ctx 上下文
     * @param msg 消息
     */
    public abstract void channelRead(ChannelHandler ctx, Object msg);

}
