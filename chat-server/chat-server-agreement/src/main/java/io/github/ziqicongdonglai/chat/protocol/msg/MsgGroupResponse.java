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
 * @description 群组消息响应
 */
@Getter
@Setter
@ToString
public class MsgGroupResponse extends Packet {
    /**
     * 对话框ID
     */
    private String talkId;
    /**
     * 群员用户ID
     */
    private String userId;
    /**
     * 群员用户昵称
     */
    private String userNickName;
    /**
     * 群员用户头像
     */
    private String userHead;
    /**
     * 群员用户发送消息内容
     */
    private String msg;
    /**
     * 消息类型；0文字消息、1固定表情
     */
    private Integer msgType;
    /**
     * 群员用户发送消息时间
     */
    private Date msgDate;

    public MsgGroupResponse() {
    }


    @Override
    public Byte getCommand() {
        return Command.MsgGroupResponse;
    }
}
