package io.github.ziqicongdonglai.chat.protocol.login;

import io.github.ziqicongdonglai.chat.protocol.Command;
import io.github.ziqicongdonglai.chat.protocol.Packet;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author ke_zhang
 * @create 2021-11-07 23:36
 * @description 重连请求
 */
@Getter
@Setter
@ToString
public class ReconnectRequest extends Packet {

    private String userId;

    public ReconnectRequest(String userId) {
        this.userId = userId;
    }

    @Override
    public Byte getCommand() {
        return Command.ReconnectRequest;
    }
}
