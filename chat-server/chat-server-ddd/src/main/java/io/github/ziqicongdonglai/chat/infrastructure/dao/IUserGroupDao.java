package io.github.ziqicongdonglai.chat.infrastructure.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author ke_zhang
 * @create 2021-11-08 0:22
 * @description
 */
@Mapper
public interface IUserGroupDao {

    List<String> queryUserGroupsIdList(String userId);

}
