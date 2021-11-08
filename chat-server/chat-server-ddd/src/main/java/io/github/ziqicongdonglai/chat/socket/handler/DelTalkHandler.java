package io.github.ziqicongdonglai.chat.socket.handler;

import io.netty.channel.Channel;
import io.github.ziqicongdonglai.chat.application.UserService;
import io.github.ziqicongdonglai.chat.protocol.talk.DelTalkRequest;
import io.github.ziqicongdonglai.chat.socket.MyBizHandler;

/**
 * @author ke_zhang
 * @create 2021-11-08 0:41
 * @description
 */
public class DelTalkHandler extends MyBizHandler<DelTalkRequest> {

    public DelTalkHandler(UserService userService) {
        super(userService);
    }

    @Override
    public void channelRead(Channel channel, DelTalkRequest msg) {
        userService.deleteUserTalk(msg.getUserId(), msg.getTalkId());
    }
}
