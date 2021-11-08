package io.github.ziqicongdonglai.chat.protocol.friend;

import io.github.ziqicongdonglai.chat.protocol.Command;
import io.github.ziqicongdonglai.chat.protocol.Packet;

/**
 * @author ke_zhang
 * @create 2021-11-07 23:28
 * @description 添加好友请求
 */
public class AddFriendRequest extends Packet {

    /**
     * 用户ID[自己的ID]
     */
    private String userId;
    /**
     * 好友ID
     */
    private String friendId;

    public AddFriendRequest() {
    }

    public AddFriendRequest(String userId, String friendId) {
        this.userId = userId;
        this.friendId = friendId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFriendId() {
        return friendId;
    }

    public void setFriendId(String friendId) {
        this.friendId = friendId;
    }

    @Override
    public Byte getCommand() {
        return Command.AddFriendRequest;
    }

}
