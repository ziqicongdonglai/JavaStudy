package io.github.ziqicongdonglai.chat.infrastructure.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author ke_zhang
 * @create 2021-11-08 0:25
 * @description 聊天记录
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChatRecord {

    private Long id;
    private String userId;
    private String friendId;
    private String msgContent;
    private Integer msgType;
    private Date msgDate;
    private Integer talkType;
    private Date createTime;
    private Date updateTime;

}
