package io.github.ziqicongdonglai.chat.domain.inet.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ke_zhang
 * @create 2021-11-08 0:05
 * @description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChannelUserInfo {

    private String userId;
    private String userNickName;
    private String userHead;
    /**
     * 状态[true在线、false不在线]
     */
    private boolean status;


}