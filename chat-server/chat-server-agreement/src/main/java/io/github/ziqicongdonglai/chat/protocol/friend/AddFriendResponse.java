package io.github.ziqicongdonglai.chat.protocol.friend;

import io.github.ziqicongdonglai.chat.protocol.Command;
import io.github.ziqicongdonglai.chat.protocol.Packet;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author ke_zhang
 * @create 2021-11-07 23:28
 * @description 添加好友应答
 */
@Getter
@Setter
@ToString
public class AddFriendResponse extends Packet {

    private String friendId;
    private String friendNickName;
    private String friendHead;

    public AddFriendResponse() {
    }

    public AddFriendResponse(String friendId, String friendNickName, String friendHead) {
        this.friendId = friendId;
        this.friendNickName = friendNickName;
        this.friendHead = friendHead;
    }

    @Override
    public Byte getCommand() {
        return Command.AddFriendResponse;
    }
}
