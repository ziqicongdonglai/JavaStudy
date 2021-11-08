package io.github.ziqicongdonglai.chat.protocol.friend.dto;

import lombok.Data;

/**
 * @author ke_zhang
 * @create 2021-11-07 23:31
 * @description UserDto
 */
@Data
public class UserDto {

    private String userId;
    private String userNickName;
    private String userHead;
    private Integer status;

    public UserDto() {
    }

    public UserDto(String userId, String userNickName, String userHead) {
        this.userId = userId;
        this.userNickName = userNickName;
        this.userHead = userHead;
    }

}
