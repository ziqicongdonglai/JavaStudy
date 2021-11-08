package io.github.ziqicongdonglai.chat.infrastructure.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Repository;
import io.github.ziqicongdonglai.chat.domain.user.model.*;
import io.github.ziqicongdonglai.chat.domain.user.repository.IUserRepository;
import io.github.ziqicongdonglai.chat.infrastructure.dao.*;
import io.github.ziqicongdonglai.chat.infrastructure.po.*;

import java.util.ArrayList;
import java.util.List;

import static io.github.ziqicongdonglai.chat.infrastructure.common.Constants.TalkType.Friend;
import static io.github.ziqicongdonglai.chat.infrastructure.common.Constants.TalkType.Group;

/**
 * @author ke_zhang
 * @create 2021-11-08 0:31
 * @description
 */
@Repository("userRepository")
public class UserRepository implements IUserRepository {

    @Autowired
    private IChatRecordDao chatRecordDao;
    @Autowired
    private IGroupsDao groupsDao;
    @Autowired
    private ITalkBoxDao talkBoxDao;
    @Autowired
    private IUserDao userDao;
    @Autowired
    private IUserFriendDao userFriendDao;
    @Autowired
    private IUserGroupDao userGroupDao;

    @Override
    public String queryUserPassword(String userId) {
        return userDao.queryUserPassword(userId);
    }

    @Override
    public UserInfo queryUserInfo(String userId) {
        User user = userDao.queryUserById(userId);
        return new UserInfo(user.getUserId(), user.getUserNickName(), user.getUserHead());
    }

    @Override
    public List<TalkBoxInfo> queryTalkBoxInfoList(String userId) {
        List<TalkBoxInfo> talkBoxInfoList = new ArrayList<>();
        List<TalkBox> talkBoxList = talkBoxDao.queryTalkBoxList(userId);
        for (TalkBox talkBox : talkBoxList) {
            TalkBoxInfo talkBoxInfo = new TalkBoxInfo();
            if (Friend.getCode().equals(talkBox.getTalkType())) {
                User user = userDao.queryUserById(talkBox.getTalkId());
                talkBoxInfo.setTalkType(Friend.getCode());
                talkBoxInfo.setTalkId(user.getUserId());
                talkBoxInfo.setTalkName(user.getUserNickName());
                talkBoxInfo.setTalkHead(user.getUserHead());
            } else if (Group.getCode().equals(talkBox.getTalkType())) {
                Groups groups = groupsDao.queryGroupsById(talkBox.getTalkId());
                talkBoxInfo.setTalkType(Group.getCode());
                talkBoxInfo.setTalkId(groups.getGroupId());
                talkBoxInfo.setTalkName(groups.getGroupName());
                talkBoxInfo.setTalkHead(groups.getGroupHead());
            }
            talkBoxInfoList.add(talkBoxInfo);
        }
        return talkBoxInfoList;
    }

    @Override
    public void addTalkBoxInfo(String userId, String talkId, Integer talkType) {
        try {
            if (null != talkBoxDao.queryTalkBox(userId, talkId)) {
                return;
            }
            TalkBox talkBox = new TalkBox();
            talkBox.setUserId(userId);
            talkBox.setTalkId(talkId);
            talkBox.setTalkType(talkType);
            talkBoxDao.addTalkBox(talkBox);
        } catch (DuplicateKeyException ignored) {
        }
    }

    @Override
    public List<UserFriendInfo> queryUserFriendInfoList(String userId) {
        List<UserFriendInfo> userFriendInfoList = new ArrayList<>();
        List<String> friendIdList = userFriendDao.queryUserFriendIdList(userId);
        for (String friendId : friendIdList) {
            User user = userDao.queryUserById(friendId);
            UserFriendInfo friendInfo = new UserFriendInfo();
            friendInfo.setFriendId(user.getUserId());
            friendInfo.setFriendName(user.getUserNickName());
            friendInfo.setFriendHead(user.getUserHead());
            userFriendInfoList.add(friendInfo);
        }
        return userFriendInfoList;
    }

    @Override
    public List<GroupsInfo> queryUserGroupInfoList(String userId) {
        List<GroupsInfo> groupsInfoList = new ArrayList<>();
        List<String> groupsIdList = userGroupDao.queryUserGroupsIdList(userId);
        for (String groupsId : groupsIdList) {
            Groups groups = groupsDao.queryGroupsById(groupsId);
            GroupsInfo groupsInfo = new GroupsInfo();
            groupsInfo.setGroupId(groups.getGroupId());
            groupsInfo.setGroupName(groups.getGroupName());
            groupsInfo.setGroupHead(groups.getGroupHead());
            groupsInfoList.add(groupsInfo);
        }
        return groupsInfoList;
    }

    @Override
    public List<NewUserInfo> queryFuzzyUserInfoList(String userId, String searchKey) {
        List<NewUserInfo> newUserInfoList = new ArrayList<>();
        List<User> userList = userDao.queryFuzzyUserList(userId, searchKey);
        for (User user : userList) {
            NewUserInfo userInfo = new NewUserInfo(user.getUserId(), user.getUserNickName(), user.getUserHead(), 0);
            UserFriend req = new UserFriend();
            req.setUserId(userId);
            req.setUserFriendId(user.getUserId());
            UserFriend userFriend = userFriendDao.queryUserFriendById(req);
            if (null != userFriend) {
                userInfo.setStatus(2);
            }
            newUserInfoList.add(userInfo);
        }
        return newUserInfoList;
    }

    @Override
    public void addUserFriend(List<UserFriend> userFriendList) {
        try {
            userFriendDao.addUserFriendList(userFriendList);
        } catch (DuplicateKeyException ignored) {
        }
    }

    @Override
    public void appendChatRecord(ChatRecordInfo chatRecordInfo) {
        ChatRecord chatRecord = new ChatRecord();
        chatRecord.setUserId(chatRecordInfo.getUserId());
        chatRecord.setFriendId(chatRecordInfo.getFriendId());
        chatRecord.setMsgContent(chatRecordInfo.getMsgContent());
        chatRecord.setMsgType(chatRecordInfo.getMsgType());
        chatRecord.setMsgDate(chatRecordInfo.getMsgDate());
        chatRecord.setTalkType(chatRecordInfo.getTalkType());
        chatRecordDao.appendChatRecord(chatRecord);
    }

    @Override
    public List<ChatRecordInfo> queryChatRecordInfoList(String talkId, String userId, Integer talkType) {
        List<ChatRecordInfo> chatRecordInfoList = new ArrayList<>();
        List<ChatRecord> list = new ArrayList<>();
        if (Friend.getCode().equals(talkType)) {
            list = chatRecordDao.queryUserChatRecordList(talkId, userId);
        } else if (Group.getCode().equals(talkType)) {
            list = chatRecordDao.queryGroupsChatRecordList(talkId, userId);
        }
        for (ChatRecord chatRecord : list) {
            ChatRecordInfo chatRecordInfo = new ChatRecordInfo();
            chatRecordInfo.setUserId(chatRecord.getUserId());
            chatRecordInfo.setFriendId(chatRecord.getFriendId());
            chatRecordInfo.setMsgContent(chatRecord.getMsgContent());
            chatRecordInfo.setMsgType(chatRecord.getMsgType());
            chatRecordInfo.setMsgDate(chatRecord.getMsgDate());
            chatRecordInfoList.add(chatRecordInfo);
        }
        return chatRecordInfoList;
    }

    @Override
    public void deleteUserTalk(String userId, String talkId) {
        talkBoxDao.deleteUserTalk(userId, talkId);
    }

    @Override
    public List<String> queryUserGroupsIdList(String userId) {
        return userGroupDao.queryUserGroupsIdList(userId);
    }

    @Override
    public List<String> queryTalkBoxGroupsIdList(String userId) {
        return talkBoxDao.queryTalkBoxGroupsIdList(userId);
    }

}
