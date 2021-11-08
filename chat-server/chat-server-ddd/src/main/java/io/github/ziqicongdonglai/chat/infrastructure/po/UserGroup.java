package io.github.ziqicongdonglai.chat.infrastructure.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author ke_zhang
 * @create 2021-11-08 0:27
 * @description 用户群组
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserGroup {

    private Long id;
    private String userId;
    private String groupId;
    private Date createTime;
    private Date updateTime;
}
