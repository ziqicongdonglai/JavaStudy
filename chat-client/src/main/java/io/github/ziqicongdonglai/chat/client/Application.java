package io.github.ziqicongdonglai.chat.client;

import io.netty.channel.Channel;
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;
import io.github.ziqicongdonglai.chat.client.application.UIService;
import io.github.ziqicongdonglai.chat.client.event.ChatEvent;
import io.github.ziqicongdonglai.chat.client.event.LoginEvent;
import io.github.ziqicongdonglai.chat.client.infrastructure.util.CacheUtil;
import io.github.ziqicongdonglai.chat.client.socket.NettyClient;
import io.github.ziqicongdonglai.chat.protocol.login.ReconnectRequest;
import io.github.ziqicongdonglai.chat.ui.view.chat.ChatController;
import io.github.ziqicongdonglai.chat.ui.view.chat.IChatMethod;
import io.github.ziqicongdonglai.chat.ui.view.login.ILoginMethod;
import io.github.ziqicongdonglai.chat.ui.view.login.LoginController;

import java.util.concurrent.*;

/**
 * @author ke_zhang
 * @create 2021-11-06 23:46
 * @description
 */
@Slf4j
public class Application extends javafx.application.Application {

    /**
     * 默认线程池
     */
    private static final ExecutorService executorService = Executors.newFixedThreadPool(2);
    private final ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

    @Override
    public void start(Stage primaryStage) throws Exception {
        // 1. 启动窗口
        IChatMethod chat = new ChatController(new ChatEvent());
        ILoginMethod login = new LoginController(new LoginEvent(), chat);
        login.doShow();

        UIService uiService = new UIService();
        uiService.setChat(chat);
        uiService.setLogin(login);

        // 2. 启动socket连接
        log.info("NettyClient连接服务开始 inetHost：{} inetPort：{}", "127.0.0.1", 7397);
        NettyClient nettyClient = new NettyClient(uiService);
        Future<Channel> future = executorService.submit(nettyClient);
        Channel channel = future.get();
        if (null == channel) {
            throw new RuntimeException("netty client start error channel is null");
        }

        while (!nettyClient.isActive()) {
            log.info("NettyClient启动服务 ...");
            Thread.sleep(500);
        }
        log.info("NettyClient连接服务完成 {}", channel.localAddress());

        // Channel状态定时巡检；3秒后每5秒执行一次
        scheduledExecutorService.scheduleAtFixedRate(() -> {
            while (!nettyClient.isActive()) {
                log.info("通信管道巡检：通信管道状态 " + nettyClient.isActive());
                try {
                    log.info("通信管道巡检：断线重连[Begin]");
                    Channel freshChannel = executorService.submit(nettyClient).get();
                    if (null == CacheUtil.userId) {
                        continue;
                    }
                    freshChannel.writeAndFlush(new ReconnectRequest(CacheUtil.userId));
                } catch (InterruptedException | ExecutionException e) {
                    log.error("通信管道巡检：断线重连[Error]");
                }
            }
        }, 3, 5, TimeUnit.SECONDS);
    }

    public static void main(String[] args) {
        launch(args);
    }

}
