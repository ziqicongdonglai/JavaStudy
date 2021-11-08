package io.github.ziqicongdonglai.chat.infrastructure.repository;

import io.github.ziqicongdonglai.chat.domain.inet.model.ChannelUserInfo;
import io.github.ziqicongdonglai.chat.domain.inet.model.ChannelUserReq;
import io.github.ziqicongdonglai.chat.domain.inet.repository.IInetRepository;
import io.github.ziqicongdonglai.chat.infrastructure.dao.IUserDao;
import io.github.ziqicongdonglai.chat.infrastructure.po.User;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ke_zhang
 * @create 2021-11-08 0:30
 * @description
 */
@Repository("inetRepository")
public class InetRepository implements IInetRepository {

    @Resource
    private IUserDao userDao;

    @Override
    public Long queryChannelUserCount(ChannelUserReq req) {
        return userDao.queryChannelUserCount(req);
    }

    @Override
    public List<ChannelUserInfo> queryChannelUserList(ChannelUserReq req) {
        List<ChannelUserInfo> channelUserInfoList = new ArrayList<>();
        List<User> userList = userDao.queryChannelUserList(req);
        for (User user : userList) {
            ChannelUserInfo channelUserInfo = new ChannelUserInfo();
            channelUserInfo.setUserId(user.getUserId());
            channelUserInfo.setUserNickName(user.getUserNickName());
            channelUserInfo.setUserHead(user.getUserHead());
            channelUserInfoList.add(channelUserInfo);
        }
        return channelUserInfoList;
    }
}