package io.github.ziqicongdonglai.chat.domain.inet.repository;

import io.github.ziqicongdonglai.chat.domain.inet.model.ChannelUserInfo;
import io.github.ziqicongdonglai.chat.domain.inet.model.ChannelUserReq;

import java.util.List;

/**
 * @author ke_zhang
 * @create 2021-11-08 0:07
 * @description
 */
public interface IInetRepository {

    /**
     * queryChannelUserCount
     *
     * @param req req
     * @return long
     */
    Long queryChannelUserCount(ChannelUserReq req);

    /**
     * queryChannelUserList
     *
     * @param req req
     * @return List
     */
    List<ChannelUserInfo> queryChannelUserList(ChannelUserReq req);

}
