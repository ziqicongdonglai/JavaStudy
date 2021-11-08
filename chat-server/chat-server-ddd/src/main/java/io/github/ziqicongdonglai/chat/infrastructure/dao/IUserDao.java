package io.github.ziqicongdonglai.chat.infrastructure.dao;

import io.github.ziqicongdonglai.chat.domain.inet.model.ChannelUserReq;
import io.github.ziqicongdonglai.chat.infrastructure.po.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author ke_zhang
 * @create 2021-11-08 0:21
 * @description
 */
@Mapper
public interface IUserDao {

    String queryUserPassword(String userId);

    User queryUserById(String userId);

    List<User> queryFuzzyUserList(String userId, String searchKey);

    Long queryChannelUserCount(ChannelUserReq req);

    List<User> queryChannelUserList(ChannelUserReq req);

}
