package io.github.ziqicongdonglai.chat.client.socket;

import io.github.ziqicongdonglai.chat.client.application.UIService;
import io.github.ziqicongdonglai.chat.client.infrastructure.util.BeanUtil;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;

/**
 * @author ke_zhang
 * @create 2021-11-06 23:45
 * @description
 */
@Slf4j
public class NettyClient implements Callable<Channel> {

    private final String serverHost = "127.0.0.1";
    private final int serverPort = 7397;

    private final EventLoopGroup workerGroup = new NioEventLoopGroup();
    private Channel channel;

    private final UIService uiService;

    public NettyClient(UIService uiService) {
        this.uiService = uiService;
    }

    @Override
    public Channel call() throws Exception {
        ChannelFuture channelFuture = null;
        try {
            Bootstrap b = new Bootstrap();
            b.group(workerGroup);
            b.channel(NioSocketChannel.class);
            b.option(ChannelOption.AUTO_READ, true);
            b.handler(new MyChannelInitializer(uiService));
            channelFuture = b.connect(serverHost, serverPort).syncUninterruptibly();
            this.channel = channelFuture.channel();
            BeanUtil.addBean("channel", channel);
        } catch (Exception e) {
            log.error("socket client start error ${}", e.getMessage());
        } finally {
            if (null != channelFuture && channelFuture.isSuccess()) {
                log.info("socket client start done. ");
            } else {
                log.error("socket client start error. ");
            }
        }
        return channel;
    }

    public void destroy() {
        if (null == channel) {
            return;
        }
        channel.close();
        workerGroup.shutdownGracefully();
    }

    public boolean isActive() {
        return channel.isActive();
    }

    public Channel channel() {
        return channel;
    }

}
