package io.github.ziqicongdonglai.chat.infrastructure.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author ke_zhang
 * @create 2021-11-08 0:26
 * @description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TalkBox {

    private Long id;
    private String userId;
    private String talkId;
    private Integer talkType;
    private Date createTime;
    private Date updateTime;

}
