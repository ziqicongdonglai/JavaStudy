package io.github.ziqicongdonglai.chat.infrastructure.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author ke_zhang
 * @create 2021-11-08 0:26
 * @description 用户
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    private Long id;
    private String userId;
    private String userNickName;
    private String userHead;
    private String userPassword;
    private Date createTime;
    private Date updateTime;

}
