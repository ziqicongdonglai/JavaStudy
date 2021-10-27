package io.github.ziqicongdonglai.chat.ui.view.chat;

import java.util.Date;

/**
 * @author ke_zhang
 * @create 2021-10-23 1:26
 * @description 方法接口
 */
public interface IChatMethod {

    /**
     * 打开窗口
     */
    void doShow();

    /**
     * 设置登陆用户头像
     *
     * @param userId       用户ID
     * @param userNickName 用户昵称
     * @param userHead     头像图片名称
     */
    void setUserInfo(String userId, String userNickName, String userHead);


    /**
     * 填充对话框列表
     *
     * @param talkIdx    对话框位置；首位 0、默认 -1
     * @param talkType   对话框类型；好友 0、群组 1
     * @param talkId     对话框ID，1v1 聊天ID、1vn 聊天ID
     * @param talkName   对话框名称
     * @param talkHead   对话框头像
     * @param talkSketch 对话框通信简述 (聊天内容最后一组信息)
     * @param talkDate   对话框通信时间
     * @param selected   选中 [true/false]
     */
    void addTalkBox(int talkIdx, Integer talkType, String talkId, String talkName, String talkHead, String talkSketch, Date talkDate, Boolean selected);

    /**
     * 填充对话框消息 - 好友 [别人的消息]
     *
     * @param talkId   对话框 ID[用户 ID]
     * @param msg      消息
     * @param msgData  时间
     * @param idxFirst 是否设置首位
     * @param selected 是否选中
     * @param isRemind 是否提醒
     */
    void addTalkMsgUserLeft(String talkId, String msg, Date msgData, Boolean idxFirst, Boolean selected, Boolean isRemind);

    /**
     * 填充对话框消息 - 群组 [别人的消息]
     *
     * @param talkId       对话框 ID[群组 ID]
     * @param userId       用户 ID[群员]
     * @param userNickName 用户昵称
     * @param userHead     用户头像
     * @param msg          消息
     * @param msgDate      时间
     * @param idxFirst     是否设置首位
     * @param selected     是否选中
     * @param isRemind     是否提醒
     */
    void addTalkMsgGroupLeft(String talkId, String userId, String userNickName, String userHead, String msg, Date msgDate, Boolean idxFirst, Boolean selected, Boolean isRemind);

    /**
     * 填充对话框消息 [自己的消息]
     *
     * @param talkId   对话框 ID[用户 ID]
     * @param msg      消息
     * @param msgData  时间
     * @param idxFirst 是否设置首位
     * @param selected 是否选中
     * @param isRemind 是否提醒
     */
    void addTalkMsgRight(String talkId, String msg, Date msgData, Boolean idxFirst, Boolean selected, Boolean isRemind);

    /**
     * 工具栏表情框体位置：X
     *
     * @return X
     */
    double getToolFaceX();

    /**
     * 工具栏表情框体位置：Y
     *
     * @return Y
     */
    double getToolFaceY();

    /**
     * 好友列表添加群组
     *
     * @param groupId   群组ID
     * @param groupName 群组名称
     * @param groupHead 群组头像
     */
    void addFriendGroup(String groupId, String groupName, String groupHead);

    /**
     * 好友列表添加用户
     *
     * @param selected     选中;true/false
     * @param userId       好友ID
     * @param userNickName 好友昵称
     * @param userHead     好友头像
     */
    void addFriendUser(boolean selected, String userId, String userNickName, String userHead);

}
