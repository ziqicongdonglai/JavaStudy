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
     * 填充对话框列表
     *
     * @param talkIdx    对话框位置；首位 0、默认 -1
     * @param talkType   对话框类型；好友 0、群组 1
     * @param talkId     对话框 ID，1v1 聊天 ID、1vn 聊天 ID
     * @param talkName   对话框名称
     * @param talkHead   对话框头像
     * @param talkSketch 对话框通信简述 (聊天内容最后一组信息)
     * @param talkDate   对话框通信时间
     * @param selected   选中 [true/false]
     */
    void addTalkBox(int talkIdx, Integer talkType, String talkId, String talkName, String talkHead,
                    String talkSketch, Date talkDate, Boolean selected);

}
