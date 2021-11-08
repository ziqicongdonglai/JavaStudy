package io.github.ziqicongdonglai.chat.domain.user.model;

import io.github.ziqicongdonglai.chat.infrastructure.common.Constants;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * @author ke_zhang
 * @create 2021-11-08 0:11
 * @description 聊天记录
 */
@Data
@Builder
public class ChatRecordInfo {

    /**
     * 用户ID
     */
    private String userId;
    /**
     * 好友ID
     */
    private String friendId;
    /**
     * 消息内容
     */
    private String msgContent;
    /**
     * 消息类型；0文字消息、1固定表情
     */
    private Integer msgType;
    /**
     * 消息时间
     */
    private Date msgDate;
    /**
     * 对话框类型；0好友、1群组
     */
    private Integer talkType;

    public ChatRecordInfo() {
    }

    public ChatRecordInfo(String userId, String friendId, String msgContent, Integer msgType, Date msgDate) {
        this.friendId = friendId;
        this.userId = userId;
        this.msgContent = msgContent;
        this.msgType = msgType;
        this.msgDate = msgDate;
        this.talkType = Constants.TalkType.Friend.getCode();
    }

    public ChatRecordInfo(String userId, String friendId, String msgContent, Integer msgType, Date msgDate, Integer talkType) {
        this.friendId = friendId;
        this.userId = userId;
        this.msgContent = msgContent;
        this.msgType = msgType;
        this.msgDate = msgDate;
        this.talkType = talkType;
    }

}
