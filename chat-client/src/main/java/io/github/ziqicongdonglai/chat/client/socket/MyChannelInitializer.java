package io.github.ziqicongdonglai.chat.client.socket;

import io.github.ziqicongdonglai.chat.client.application.UIService;
import io.github.ziqicongdonglai.chat.client.socket.handler.*;
import io.github.ziqicongdonglai.chat.codec.ObjDecoder;
import io.github.ziqicongdonglai.chat.codec.ObjEncoder;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;

/**
 * @author ke_zhang
 * @create 2021-11-06 23:45
 * @description
 */
public class MyChannelInitializer extends ChannelInitializer<SocketChannel> {

    private final UIService uiService;

    public MyChannelInitializer(UIService uiService) {
        this.uiService = uiService;
    }

    @Override
    protected void initChannel(SocketChannel channel) throws Exception {
        //对象传输处理[解码]
        channel.pipeline().addLast(new ObjDecoder());
        // 在管道中添加我们自己的接收数据实现方法
        channel.pipeline().addLast(new AddFriendHandler(uiService));
        channel.pipeline().addLast(new LoginHandler(uiService));
        channel.pipeline().addLast(new MsgGroupHandler(uiService));
        channel.pipeline().addLast(new MsgHandler(uiService));
        channel.pipeline().addLast(new SearchFriendHandler(uiService));
        channel.pipeline().addLast(new TalkNoticeHandler(uiService));
        //对象传输处理[编码]
        channel.pipeline().addLast(new ObjEncoder());
    }

}
