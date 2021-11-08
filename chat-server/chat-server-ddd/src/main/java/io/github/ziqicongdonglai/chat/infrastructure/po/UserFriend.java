package io.github.ziqicongdonglai.chat.infrastructure.po;

import lombok.Data;

import java.util.Date;

/**
 * @author ke_zhang
 * @create 2021-11-08 0:27
 * @description 用户好友
 */
@Data
public class UserFriend {

    private Long id;
    private String userId;
    private String userFriendId;
    private Date createTime;
    private Date updateTime;

    public UserFriend() {
    }

    public UserFriend(String userId, String userFriendId) {
        this.userId = userId;
        this.userFriendId = userFriendId;
    }

}
