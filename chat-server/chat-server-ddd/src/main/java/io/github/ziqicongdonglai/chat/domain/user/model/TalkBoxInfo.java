package io.github.ziqicongdonglai.chat.domain.user.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author ke_zhang
 * @create 2021-11-08 0:12
 * @description 对话框信息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TalkBoxInfo {

    /**
     * 对话框类型；0好友、1群组
     */
    private Integer talkType;
    /**
     * 对话框ID(好友ID、群组ID)
     */
    private String talkId;
    /**
     * 对话框名称
     */
    private String talkName;
    /**
     * 对话框头像
     */
    private String talkHead;
    /**
     * 消息简述
     */
    private String talkSketch;
    /**
     * 消息时间
     */
    private Date talkDate;

}
