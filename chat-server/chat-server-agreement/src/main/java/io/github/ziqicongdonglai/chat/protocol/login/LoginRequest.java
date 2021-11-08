package io.github.ziqicongdonglai.chat.protocol.login;

import io.github.ziqicongdonglai.chat.protocol.Command;
import io.github.ziqicongdonglai.chat.protocol.Packet;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author ke_zhang
 * @create 2021-11-07 23:36
 * @description 登录请求
 */
@Getter
@Setter
@ToString
public class LoginRequest extends Packet {

    private String userId;
    private String userPassword;

    public LoginRequest(String userId, String userPassword) {
        this.userId = userId;
        this.userPassword = userPassword;
    }


    @Override
    public Byte getCommand() {
        return Command.LoginRequest;
    }

}
