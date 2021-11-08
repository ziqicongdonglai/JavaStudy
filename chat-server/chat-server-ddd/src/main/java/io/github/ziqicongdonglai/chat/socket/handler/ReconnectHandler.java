package io.github.ziqicongdonglai.chat.socket.handler;

import io.netty.channel.Channel;
import io.github.ziqicongdonglai.chat.application.UserService;
import io.github.ziqicongdonglai.chat.infrastructure.common.SocketChannelUtil;
import io.github.ziqicongdonglai.chat.protocol.login.ReconnectRequest;
import io.github.ziqicongdonglai.chat.socket.MyBizHandler;

import java.util.List;

/**
 * @author ke_zhang
 * @create 2021-11-08 0:41
 * @description 重连处理
 */
public class ReconnectHandler extends MyBizHandler<ReconnectRequest> {

    public ReconnectHandler(UserService userService) {
        super(userService);
    }

    @Override
    public void channelRead(Channel channel, ReconnectRequest msg) {
        logger.info("客户端断线重连处理。userId：{}", msg.getUserId());
        // 添加用户Channel
        SocketChannelUtil.removeUserChannelByUserId(msg.getUserId());
        SocketChannelUtil.addChannel(msg.getUserId(), channel);
        // 添加群组Channel
        List<String> groupsIdList = userService.queryTalkBoxGroupsIdList(msg.getUserId());
        for (String groupsId : groupsIdList) {
            SocketChannelUtil.addChannelGroup(groupsId, channel);
        }
    }

}
