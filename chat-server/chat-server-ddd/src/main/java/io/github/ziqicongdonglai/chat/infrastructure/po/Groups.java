package io.github.ziqicongdonglai.chat.infrastructure.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author ke_zhang
 * @create 2021-11-08 0:26
 * @description 群组
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Groups {

    private Long id;
    private String groupId;
    private String groupName;
    private String groupHead;
    private Date createTime;
    private Date updateTime;

}
