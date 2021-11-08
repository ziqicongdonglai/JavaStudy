package io.github.ziqicongdonglai.chat.client.socket.handler;

import io.github.ziqicongdonglai.chat.client.application.UIService;
import io.github.ziqicongdonglai.chat.client.socket.MyBizHandler;
import io.github.ziqicongdonglai.chat.protocol.friend.AddFriendResponse;
import io.github.ziqicongdonglai.chat.ui.view.chat.IChatMethod;
import io.netty.channel.Channel;
import javafx.application.Platform;

/**
 * @author ke_zhang
 * @create 2021-11-06 23:43
 * @description
 */
public class AddFriendHandler extends MyBizHandler<AddFriendResponse> {

    public AddFriendHandler(UIService uiService) {
        super(uiService);
    }

    @Override
    public void channelRead(Channel channel, AddFriendResponse msg) {
        IChatMethod chat = uiService.getChat();
        Platform.runLater(() -> chat.addFriendUser(true, msg.getFriendId(), msg.getFriendNickName(), msg.getFriendHead()));
    }

}
