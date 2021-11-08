package io.github.ziqicongdonglai.chat.protocol.login.dto;

import lombok.Data;

/**
 * @author ke_zhang
 * @create 2021-11-07 23:33
 * @description 用户好友Dto
 */
@Data
public class UserFriendDto {

    private String friendId;
    private String friendName;
    private String friendHead;

}
