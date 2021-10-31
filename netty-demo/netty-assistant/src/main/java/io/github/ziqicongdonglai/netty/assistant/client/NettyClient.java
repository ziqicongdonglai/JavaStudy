package io.github.ziqicongdonglai.netty.assistant.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;

/**
 * @author ke_zhang
 * @create 2021-10-31 19:12
 * @description NettyClient
 */
public class NettyClient {
    private int port;
    private String host;
    private SocketChannel socketChannel;

    public NettyClient(int port, String host) {
        this.port = port;
        this.host = host;
        new Thread(() -> {
            try {
                NettyClient.this.start();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }).start();
    }

    public void close() {
        socketChannel.close();
    }
    public void write(String msg) {
        socketChannel.writeAndFlush(msg+"\r\n");
    }

    private void start() throws InterruptedException {
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.channel(NioSocketChannel.class);
            bootstrap.option(ChannelOption.SO_KEEPALIVE, true);
            bootstrap.group(eventLoopGroup);
            bootstrap.remoteAddress(host, port);
            bootstrap.handler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel ch) {
                    final ChannelPipeline pipeline = ch.pipeline();
                    // Decoders
                    pipeline.addLast("frameDecoder", new LineBasedFrameDecoder(80));
                    pipeline.addLast("stringDecoder", new StringDecoder(CharsetUtil.UTF_8));

                    // Encoder
                    pipeline.addLast("stringEncoder", new StringEncoder(CharsetUtil.UTF_8));
                    pipeline.addLast(new NettyClientHandler());
                }
            });
            ChannelFuture future = bootstrap.connect(host, port).sync();
            if (future.isSuccess()) {
                socketChannel = (SocketChannel) future.channel();
                System.out.println("------connect server success------");
            }
            future.channel().closeFuture().sync();
        } finally {
            eventLoopGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) {
        //new NettyClient(21868, "localhost");
    }
}
