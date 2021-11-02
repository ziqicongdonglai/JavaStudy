package io.github.ziqicongdonglai.netty.demo.client;

import io.github.ziqicongdonglai.netty.demo.util.MsgUtil;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @author ke_zhang
 * @create 2021-11-02 23:46
 * @description
 */
public class NettyClient {

    public static void main(String[] args) {
        new NettyClient().connect("127.0.0.1", 7397);
    }

    private void connect(String host, int port) {
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(workerGroup);
            b.channel(NioSocketChannel.class);
            b.option(ChannelOption.AUTO_READ, true);
            b.handler(new MyChannelInitializer());
            ChannelFuture f = b.connect(host, port).sync();
            System.out.println("Netty客户端启动！");

            f.channel().writeAndFlush(MsgUtil.buildMsg(f.channel().id().toString(), "使用protobuf通信格式的服务端，紫气从东来"));
            f.channel().writeAndFlush(MsgUtil.buildMsg(f.channel().id().toString(), "使用protobuf通信格式的服务端，紫气从东来"));
            f.channel().writeAndFlush(MsgUtil.buildMsg(f.channel().id().toString(), "使用protobuf通信格式的服务端，紫气从东来"));
            f.channel().writeAndFlush(MsgUtil.buildMsg(f.channel().id().toString(), "使用protobuf通信格式的服务端，紫气从东来"));
            f.channel().writeAndFlush(MsgUtil.buildMsg(f.channel().id().toString(), "使用protobuf通信格式的服务端，紫气从东来"));
            f.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            workerGroup.shutdownGracefully();
        }
    }

}
