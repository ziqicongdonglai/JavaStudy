package io.github.ziqicongdonglai.chat.domain.user.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ke_zhang
 * @create 2021-11-08 0:13
 * @description 好友信息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserFriendInfo {

    private String friendId;
    private String friendName;
    private String friendHead;

}
