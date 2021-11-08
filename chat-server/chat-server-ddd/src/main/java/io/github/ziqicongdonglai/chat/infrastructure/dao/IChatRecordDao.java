package io.github.ziqicongdonglai.chat.infrastructure.dao;

import io.github.ziqicongdonglai.chat.infrastructure.po.ChatRecord;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author ke_zhang
 * @create 2021-11-08 0:20
 * @description
 */
@Mapper
public interface IChatRecordDao {

    void appendChatRecord(ChatRecord req);

    List<ChatRecord> queryUserChatRecordList(String talkId, String userId);

    List<ChatRecord> queryGroupsChatRecordList(String talkId, String userId);

}
