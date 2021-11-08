package io.github.ziqicongdonglai.chat.domain.inet.model;

import io.github.ziqicongdonglai.chat.infrastructure.common.PageReq;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author ke_zhang
 * @create 2021-11-08 0:05
 * @description
 */
@Getter
@Setter
@ToString
public class ChannelUserReq extends PageReq {

    private String userId;
    private String userNickName;

}
