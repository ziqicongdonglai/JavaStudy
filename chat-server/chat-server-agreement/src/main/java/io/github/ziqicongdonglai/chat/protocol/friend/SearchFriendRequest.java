package io.github.ziqicongdonglai.chat.protocol.friend;

import io.github.ziqicongdonglai.chat.protocol.Command;
import io.github.ziqicongdonglai.chat.protocol.Packet;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author ke_zhang
 * @create 2021-11-07 23:28
 * @description 搜索好友请求
 */
@Getter
@Setter
@ToString
public class SearchFriendRequest extends Packet {

    /**
     * 用户ID
     */
    private String userId;
    /**
     * 搜索字段
     */
    private String searchKey;

    public SearchFriendRequest() {
    }

    public SearchFriendRequest(String userId, String searchKey) {
        this.userId = userId;
        this.searchKey = searchKey;
    }


    @Override
    public Byte getCommand() {
        return Command.SearchFriendRequest;
    }

}
