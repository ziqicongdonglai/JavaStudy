package io.github.ziqicongdonglai.chat.client.event;

import io.github.ziqicongdonglai.chat.client.infrastructure.util.BeanUtil;
import io.github.ziqicongdonglai.chat.client.infrastructure.util.CacheUtil;
import io.github.ziqicongdonglai.chat.protocol.login.LoginRequest;
import io.github.ziqicongdonglai.chat.ui.view.login.ILoginEvent;
import io.netty.channel.Channel;
import lombok.extern.slf4j.Slf4j;

/**
 * @author ke_zhang
 * @create 2021-11-06 23:41
 * @description
 */
@Slf4j
public class LoginEvent implements ILoginEvent {

    @Override
    public void doLoginCheck(String userId, String userPassword) {
        Channel channel = BeanUtil.getBean("channel", Channel.class);
        channel.writeAndFlush(new LoginRequest(userId, userPassword));
        CacheUtil.userId = userId;
    }

}
