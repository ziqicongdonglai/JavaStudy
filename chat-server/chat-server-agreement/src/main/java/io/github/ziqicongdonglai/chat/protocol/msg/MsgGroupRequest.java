package io.github.ziqicongdonglai.chat.protocol.msg;

import io.github.ziqicongdonglai.chat.protocol.Command;
import io.github.ziqicongdonglai.chat.protocol.Packet;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @author ke_zhang
 * @create 2021-11-07 23:40
 * @description 群组消息请求
 */
@Getter
@Setter
@ToString
public class MsgGroupRequest extends Packet {

    /**
     * 对话框ID
     */
    private String talkId;
    /**
     * 群员ID
     */
    private String userId;
    /**
     * 传输消息内容
     */
    private String msgText;
    /**
     * 消息类型；0文字消息、1固定表情
     */
    private Integer msgType;
    /**
     * 消息时间
     */
    private Date msgDate;

    public MsgGroupRequest() {
    }

    public MsgGroupRequest(String talkId, String userId, String msgText, Integer msgType, Date msgDate) {
        this.talkId = talkId;
        this.userId = userId;
        this.msgText = msgText;
        this.msgType = msgType;
        this.msgDate = msgDate;
    }


    @Override
    public Byte getCommand() {
        return Command.MsgGroupRequest;
    }

}
