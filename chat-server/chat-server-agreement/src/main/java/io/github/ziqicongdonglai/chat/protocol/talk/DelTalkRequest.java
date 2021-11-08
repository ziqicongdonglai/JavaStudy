package io.github.ziqicongdonglai.chat.protocol.talk;

import io.github.ziqicongdonglai.chat.protocol.Command;
import io.github.ziqicongdonglai.chat.protocol.Packet;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author ke_zhang
 * @create 2021-11-07 23:42
 * @description 删除对话框请求
 */
@Getter
@Setter
@ToString
public class DelTalkRequest extends Packet {

    private String userId;
    private String talkId;

    public DelTalkRequest() {
    }

    public DelTalkRequest(String userId, String talkId) {
        this.userId = userId;
        this.talkId = talkId;
    }

    @Override
    public Byte getCommand() {
        return Command.DelTalkRequest;
    }
}
