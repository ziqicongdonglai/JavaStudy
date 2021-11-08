package io.github.ziqicongdonglai.chat.protocol.talk;

import io.github.ziqicongdonglai.chat.protocol.Command;
import io.github.ziqicongdonglai.chat.protocol.Packet;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @author ke_zhang
 * @create 2021-11-07 23:42
 * @description 对话通知应答
 */
@Getter
@Setter
@ToString
public class TalkNoticeResponse extends Packet {

    /**
     * 对话框ID[好友ID、群ID]
     */
    private String talkId;
    /**
     * 对话框名称[好友名称、群名称]
     */
    private String talkName;
    /**
     * 对话框头像[好友头像、群头像]
     */
    private String talkHead;
    /**
     * 消息简讯
     */
    private String talkSketch;
    /**
     * 消息时间
     */
    private Date talkDate;


    @Override
    public Byte getCommand() {
        return Command.TalkNoticeResponse;
    }

}
