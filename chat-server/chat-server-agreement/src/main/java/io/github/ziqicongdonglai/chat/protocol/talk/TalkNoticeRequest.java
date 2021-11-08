package io.github.ziqicongdonglai.chat.protocol.talk;

import io.github.ziqicongdonglai.chat.protocol.Command;
import io.github.ziqicongdonglai.chat.protocol.Packet;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author ke_zhang
 * @create 2021-11-07 23:42
 * @description 对话通知请求
 */
@Getter
@Setter
@ToString
public class TalkNoticeRequest extends Packet {

    private String userId;
    private String friendUserId;
    /**
     * 对话框类型[0好友、1群组]
     */
    private Integer talkType;

    public TalkNoticeRequest() {
    }

    public TalkNoticeRequest(String userId, String friendUserId, Integer talkType) {
        this.userId = userId;
        this.friendUserId = friendUserId;
        this.talkType = talkType;
    }

    @Override
    public Byte getCommand() {
        return Command.TalkNoticeRequest;
    }
}
