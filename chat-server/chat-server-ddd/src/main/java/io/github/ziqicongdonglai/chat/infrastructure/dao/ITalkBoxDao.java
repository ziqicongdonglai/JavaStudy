package io.github.ziqicongdonglai.chat.infrastructure.dao;

import io.github.ziqicongdonglai.chat.infrastructure.po.TalkBox;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author ke_zhang
 * @create 2021-11-08 0:21
 * @description
 */
@Mapper
public interface ITalkBoxDao {

    List<TalkBox> queryTalkBoxList(String userId);

    void addTalkBox(TalkBox talkBox);

    void deleteUserTalk(String userId, String talkId);

    TalkBox queryTalkBox(String userId, String talkId);

    List<String> queryTalkBoxGroupsIdList(String userId);

}
