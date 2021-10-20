package io.github.ziqicongdonglai.netty.demo;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.bytes.ByteArrayDecoder;
import io.netty.handler.codec.bytes.ByteArrayEncoder;
import lombok.extern.slf4j.Slf4j;

/**
 * @author ke_zhang
 * @create 2021-10-20 22:45
 * @description TcpServer
 */
@Slf4j
public class TcpServer {

    public void bind(int port) {
        try {
            // 配置服务器的 NIO 线程租
            ServerBootstrap bootstrap = new ServerBootstrap();

            EventLoopGroup bossGroup = new NioEventLoopGroup(1);
            EventLoopGroup workerGroup = new NioEventLoopGroup(1);
            bootstrap.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {

                        @Override
                        protected void initChannel(SocketChannel arg0) {
                            //注册解码器,将 ByteBuffer 转换为 byte 数组
                            arg0.pipeline().addLast(new ByteArrayDecoder());
                            //注册编码器,将 byte 数组转换为 ByteBuffer
                            arg0.pipeline().addLast(new ByteArrayEncoder());
                            //注册事件处理器
                            arg0.pipeline().addLast(new ByteArrayHandler());
                        }
                    });
            // 绑定端口，同步等待成功，默认绑定所有网卡
            ChannelFuture f = bootstrap.bind(port).sync();
            f.addListener((ChannelFutureListener) arg0 -> log.info("打开监听端口：" + port));
            f.channel().closeFuture().addListener((ChannelFutureListener) future -> {
                //释放资源退出
                log.info(future.channel().toString() + " 链路关闭");
                bossGroup.shutdownGracefully();
                workerGroup.shutdownGracefully();
            });
            f.channel();
        } catch (Exception e) {
            log.error("", e);
        }
    }

    public static void main(String[] args) {
        int port = 9000;
        if (args != null && args.length > 0) {
            try {
                port = Integer.parseInt(args[0]);
            } catch (Exception e) {
                log.error(String.valueOf(e));
            }
        }
        new TcpServer().bind(port);
    }

}
