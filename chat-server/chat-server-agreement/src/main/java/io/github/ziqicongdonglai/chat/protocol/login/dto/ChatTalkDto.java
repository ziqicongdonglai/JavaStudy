package io.github.ziqicongdonglai.chat.protocol.login.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author ke_zhang
 * @create 2021-11-07 23:33
 * @description 网络数据传输对象：聊天对话框
 */
@Data
public class ChatTalkDto {
    /**
     * 对话框ID
     */
    private String talkId;
    /**
     * 对话框类型；0好友、1群组
     */
    private Integer talkType;
    private String talkName;
    private String talkHead;
    /**
     * 消息简述
     */
    private String talkSketch;
    private Date talkDate;

    /**
     * 聊天记录
     */
    private List<ChatRecordDto> chatRecordList;

}
