package io.github.ziqicongdonglai.netty.demo.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.nio.charset.Charset;

/**
 * @author ke_zhang
 * @create 2021-10-30 23:28
 * @description 适配器
 */
public abstract class ChannelAdapter extends Thread {

    private final Socket socket;
    private final ChannelHandler channelHandler;
    private final Charset charset;

    public ChannelAdapter(Socket socket, Charset charset) {
        this.socket = socket;
        this.charset = charset;
        while (!socket.isConnected()) {
            break;
        }
        channelHandler = new ChannelHandler(this.socket, charset);
        channelActive(channelHandler);
    }

    @Override
    public void run() {
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(this.socket.getInputStream(), charset));
            String str;
            while ((str = input.readLine()) != null) {
                channelRead(channelHandler, str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *  通知抽象方法
     * @param ctx 上下文
     */
    public abstract void channelActive(ChannelHandler ctx);

    /**
     * 读取消息抽象方法
     * @param ctx 上下文
     * @param msg 消息
     */
    public abstract void channelRead(ChannelHandler ctx, Object msg);

}
