package io.github.ziqicongdonglai.chat.client.socket.handler;

import io.github.ziqicongdonglai.chat.client.application.UIService;
import io.github.ziqicongdonglai.chat.protocol.msg.MsgGroupResponse;
import io.github.ziqicongdonglai.chat.ui.view.chat.IChatMethod;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import javafx.application.Platform;

/**
 * @author ke_zhang
 * @create 2021-11-06 23:44
 * @description
 */
public class MsgGroupHandler extends SimpleChannelInboundHandler<MsgGroupResponse> {

    private final UIService uiService;

    public MsgGroupHandler(UIService uiService) {
        this.uiService = uiService;
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MsgGroupResponse msg) throws Exception {
        IChatMethod chat = uiService.getChat();
        Platform.runLater(() -> {
            chat.addTalkMsgGroupLeft(msg.getTalkId(), msg.getUserId(), msg.getUserNickName(), msg.getUserHead(), msg.getMsg(), msg.getMsgType(), msg.getMsgDate(), true, false, true);
        });
    }

}
