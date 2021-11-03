package io.github.ziqicongdonglai.netty.demo.client;

import io.github.ziqicongdonglai.netty.demo.codec.ObjDecoder;
import io.github.ziqicongdonglai.netty.demo.codec.ObjEncoder;
import io.github.ziqicongdonglai.netty.demo.domain.MsgInfo;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;

/**
 * @author ke_zhang
 * @create 2021-11-03 20:18
 * @description MyChannelInitializer
 */
public class MyChannelInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel channel) throws Exception {
        //对象传输处理
        channel.pipeline().addLast(new ObjDecoder(MsgInfo.class));
        channel.pipeline().addLast(new ObjEncoder(MsgInfo.class));
        // 在管道中添加我们自己的接收数据实现方法
        channel.pipeline().addLast(new MyClientHandler());
    }

}
