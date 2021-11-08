package io.github.ziqicongdonglai.chat.client.socket.handler;

import io.github.ziqicongdonglai.chat.client.application.UIService;
import io.github.ziqicongdonglai.chat.protocol.friend.SearchFriendResponse;
import io.github.ziqicongdonglai.chat.protocol.friend.dto.UserDto;
import io.github.ziqicongdonglai.chat.ui.view.chat.IChatMethod;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import javafx.application.Platform;

import java.util.List;

/**
 * @author ke_zhang
 * @create 2021-11-06 23:44
 * @description
 */
public class SearchFriendHandler extends SimpleChannelInboundHandler<SearchFriendResponse> {

    private final UIService uiService;

    public SearchFriendHandler(UIService uiService) {
        this.uiService = uiService;
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, SearchFriendResponse msg) throws Exception {
        List<UserDto> list = msg.getList();
        if (null == list || list.isEmpty()) {
            return;
        }
        IChatMethod chat = uiService.getChat();
        Platform.runLater(() -> {
            for (UserDto user : list) {
                chat.addNewFriend(user.getUserId(), user.getUserNickName(), user.getUserHead(), user.getStatus());
            }
        });
    }

}
