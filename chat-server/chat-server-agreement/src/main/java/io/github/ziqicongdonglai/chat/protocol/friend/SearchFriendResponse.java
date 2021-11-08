package io.github.ziqicongdonglai.chat.protocol.friend;

import io.github.ziqicongdonglai.chat.protocol.Command;
import io.github.ziqicongdonglai.chat.protocol.Packet;
import io.github.ziqicongdonglai.chat.protocol.friend.dto.UserDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * @author ke_zhang
 * @create 2021-11-07 23:28
 * @description 搜索好友应答
 */
@Getter
@Setter
@ToString
public class SearchFriendResponse extends Packet {

    private List<UserDto> list;

    @Override
    public Byte getCommand() {
        return Command.SearchFriendResponse;
    }
}
