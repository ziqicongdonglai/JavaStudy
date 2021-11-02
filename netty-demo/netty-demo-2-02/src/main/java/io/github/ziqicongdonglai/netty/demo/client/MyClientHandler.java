package io.github.ziqicongdonglai.netty.demo.client;

import com.googlecode.protobuf.format.JsonFormat;
import io.github.ziqicongdonglai.netty.demo.domain.MsgBody;
import io.github.ziqicongdonglai.netty.demo.util.MsgUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.socket.SocketChannel;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author ke_zhang
 * @create 2021-11-02 23:46
 * @description
 */
public class MyClientHandler extends ChannelInboundHandlerAdapter {

    /**
     * 当客户端主动连接服务端的连接后，这个通道就是活跃的了
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        SocketChannel channel = (SocketChannel) ctx.channel();
        System.out.println("报告信息：本客户端接到服务端。channelId：" + channel.id());
        System.out.println("连接IP:" + channel.localAddress().getHostString());
        System.out.println("连接Port:" + channel.localAddress().getPort());
        String str = "服务器，我和你连接成功啦～" + " " + new Date() + " " + channel.localAddress().getHostString();
        ctx.writeAndFlush(MsgUtil.buildMsg(channel.id().toString(), str));
    }

    /**
     * 当客户端主动断开服务端的连接后，这个通道就是不活跃的。也就是说客户端与服务端的关闭了通信通道并且不可以传输数据
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("断开连接" + ctx.channel().localAddress().toString());
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + " 接收到消息类型：" + msg.getClass());
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + " 接收到消息内容：" + JsonFormat.printToString((MsgBody) msg));
    }

    /**
     * 捕获异常，当发生异常的时候，可以做一些相应的处理，比如打印日志、关闭连接
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
        System.out.println("异常信息：\r\n" + cause.getMessage());
    }

}
