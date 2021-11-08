package io.github.ziqicongdonglai.chat.domain.user.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ke_zhang
 * @create 2021-11-08 0:13
 * @description 用户群组信息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserGroupInfo {

    private String userId;
    private String userNickName;
    private String userHead;

}
