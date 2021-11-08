package io.github.ziqicongdonglai.chat.protocol.login.dto;

import lombok.Data;

import java.util.Date;

/**
 * @author ke_zhang
 * @create 2021-11-07 23:32
 * @description 聊天记录Dto
 */
@Data
public class ChatRecordDto {

    private String talkId;
    private String userId;
    private String userNickName;
    private String userHead;
    /**
     * 消息类型[0自己/1好友]
     */
    private Integer msgUserType;
    private String msgContent;
    /**
     * 消息类型；0文字消息、1固定表情
     */
    private Integer msgType;
    private Date msgDate;

}
