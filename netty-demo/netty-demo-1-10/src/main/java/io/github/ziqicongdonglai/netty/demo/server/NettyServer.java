package io.github.ziqicongdonglai.netty.demo.server;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioDatagramChannel;

/**
 * @author ke_zhang
 * @create 2021-11-01 19:05
 * @description
 */
public class NettyServer {

    public static void main(String[] args) throws InterruptedException {
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(group)
                    .channel(NioDatagramChannel.class)
                    //广播
                    .option(ChannelOption.SO_BROADCAST, true)
                    // 设置UDP读缓冲区为2M
                    .option(ChannelOption.SO_RCVBUF, 2048 * 1024)
                    // 设置UDP写缓冲区为1M
                    .option(ChannelOption.SO_SNDBUF, 1024 * 1024)
                    .handler(new MyChannelInitializer());
            ChannelFuture f = b.bind(7397).sync();
            System.out.println("Netty服务器启动成功～");
            f.channel().closeFuture().sync();
        } finally {
            //关闭释放内存
            group.shutdownGracefully();
        }
    }
}
