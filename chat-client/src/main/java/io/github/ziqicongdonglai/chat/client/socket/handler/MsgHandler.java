package io.github.ziqicongdonglai.chat.client.socket.handler;

import io.github.ziqicongdonglai.chat.client.application.UIService;
import io.github.ziqicongdonglai.chat.protocol.msg.MsgResponse;
import io.github.ziqicongdonglai.chat.ui.view.chat.IChatMethod;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import javafx.application.Platform;

/**
 * @author ke_zhang
 * @create 2021-11-06 23:44
 * @description
 */
public class MsgHandler extends SimpleChannelInboundHandler<MsgResponse> {

    private final UIService uiService;

    public MsgHandler(UIService uiService) {
        this.uiService = uiService;
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MsgResponse msg) throws Exception {
        IChatMethod chat = uiService.getChat();
        Platform.runLater(() -> {
            chat.addTalkMsgUserLeft(msg.getFriendId(), msg.getMsgText(), msg.getMsgType(), msg.getMsgDate(), true, false, true);
        });
    }

}
