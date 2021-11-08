package io.github.ziqicongdonglai.chat.infrastructure.dao;

import io.github.ziqicongdonglai.chat.infrastructure.po.UserFriend;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author ke_zhang
 * @create 2021-11-08 0:22
 * @description
 */
@Mapper
public interface IUserFriendDao {

    List<String> queryUserFriendIdList(String userId);

    UserFriend queryUserFriendById(UserFriend req);

    void addUserFriendList(List<UserFriend> list);

}
