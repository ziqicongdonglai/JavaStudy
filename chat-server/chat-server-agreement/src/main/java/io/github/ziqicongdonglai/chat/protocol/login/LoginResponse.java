package io.github.ziqicongdonglai.chat.protocol.login;

import io.github.ziqicongdonglai.chat.protocol.Command;
import io.github.ziqicongdonglai.chat.protocol.Packet;
import io.github.ziqicongdonglai.chat.protocol.login.dto.ChatTalkDto;
import io.github.ziqicongdonglai.chat.protocol.login.dto.GroupsDto;
import io.github.ziqicongdonglai.chat.protocol.login.dto.UserFriendDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ke_zhang
 * @create 2021-11-07 23:36
 * @description 登录响应
 */
@Getter
@Setter
@ToString
public class LoginResponse extends Packet {
    /**
     * 登陆反馈
     */
    private boolean success;
    private String userId;
    private String userHead;
    private String userNickName;
    /**
     * 聊天对话框数据[success is true]
     */
    private List<ChatTalkDto> chatTalkList = new ArrayList<>();
    /**
     * 群组列表
     */
    private List<GroupsDto> groupsList = new ArrayList<>();
    /**
     * 好友列表
     */
    private List<UserFriendDto> userFriendList = new ArrayList<>();

    public LoginResponse() {
    }

    public LoginResponse(boolean success) {
        this.success = success;
    }


    @Override
    public Byte getCommand() {
        return Command.LoginResponse;
    }

}
