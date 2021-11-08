package io.github.ziqicongdonglai.chat.infrastructure.dao;

import io.github.ziqicongdonglai.chat.infrastructure.po.Groups;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author ke_zhang
 * @create 2021-11-08 0:20
 * @description
 */
@Mapper
public interface IGroupsDao {

    Groups queryGroupsById(String groupsId);

}
