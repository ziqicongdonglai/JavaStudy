package io.github.ziqicongdonglai.netty.demo;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.bytes.ByteArrayDecoder;
import io.netty.handler.codec.bytes.ByteArrayEncoder;
import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

/**
 * @author ke_zhang
 * @create 2021-10-20 22:45
 * @description TcpClient
 */
@Slf4j
public class TcpClient {

    public Channel connect(String ip, int port) {
        try {
            Bootstrap b = new Bootstrap();
            EventLoopGroup group = new NioEventLoopGroup(1);
            b.group(group).channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel arg0)
                                throws Exception {
                            //注册解码器,将 ByteBuffer 转换为 byte 数组
                            arg0.pipeline().addLast(new ByteArrayDecoder());
                            //注册编码器,将 byte 数组转换为 ByteBuffer
                            arg0.pipeline().addLast(new ByteArrayEncoder());
                            //注册事件处理器
                            arg0.pipeline().addLast(new ByteArrayHandler());
                        }
                    });
            // 发起同步连接操作
            ChannelFuture f;
            f = b.connect(ip, port).sync();
            log.debug("连接创建成功，IP:" + ip + "端口：" + port);

            f.channel().closeFuture().addListener((ChannelFutureListener) future -> {
                //释放资源退出
                log.info(future.channel().toString() + " 链路关闭");
                group.shutdownGracefully();
            });
            return f.channel();

        } catch (Exception e) {
            log.error("连接创建失败，IP:" + ip + "端口：" + port, e);
            return null;
        }
    }

    public static void main(String[] args) {
        String ip = "localhost";
        int port = 9000;
        if (args != null && args.length > 0) {
            try {
                ip = args[0];
                port = Integer.parseInt(args[1]);
            } catch (Exception e) {
                log.error(String.valueOf(e));
            }
        }
        TcpClient activeConn = new TcpClient();
        Channel channel = activeConn.connect(ip, port);
        Scanner scan = new Scanner(System.in);
        while (true) {
            log.info("请输入要发送的报文：");
            String report = scan.nextLine();
            try {
                if (null != channel) {
                    channel.writeAndFlush(BytesUtils.hexStrToBuff(report)).sync();
                    log.info("发送成功：" + report);
                }
            } catch (Exception e) {
                log.error("", e);
            }
        }
    }

}
