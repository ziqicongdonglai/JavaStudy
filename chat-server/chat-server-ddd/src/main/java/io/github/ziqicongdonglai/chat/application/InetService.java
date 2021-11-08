package io.github.ziqicongdonglai.chat.application;

import io.github.ziqicongdonglai.chat.domain.inet.model.ChannelUserInfo;
import io.github.ziqicongdonglai.chat.domain.inet.model.ChannelUserReq;
import io.github.ziqicongdonglai.chat.domain.inet.model.InetServerInfo;

import java.util.List;

/**
 * @author ke_zhang
 * @create 2021-11-08 0:01
 * @description 网络信息查询
 */
public interface InetService {

    /**
     * 查询Netty服务器信息
     *
     * @return InetServerInfo
     */
    InetServerInfo queryNettyServerInfo();

    /**
     * @param req 请求
     * @return Channel用户数
     */
    Long queryChannelUserCount(ChannelUserReq req);

    /**
     * @param req 请求
     * @return List<ChannelUserInfo>
     */
    List<ChannelUserInfo> queryChannelUserList(ChannelUserReq req);

}
