package io.github.ziqicongdonglai.chat.protocol;

/**
 * @author ke_zhang
 * @create 2021-11-06 23:26
 * @description 常量
 */
public interface Command {

    Byte LoginRequest = 1;
    Byte LoginResponse = 2;

    Byte MsgRequest = 3;
    Byte MsgResponse = 4;

    Byte TalkNoticeRequest = 5;
    Byte TalkNoticeResponse = 6;

    Byte SearchFriendRequest = 7;
    Byte SearchFriendResponse = 8;

    Byte AddFriendRequest = 9;
    Byte AddFriendResponse = 10;

    Byte DelTalkRequest = 11;

    Byte MsgGroupRequest = 12;
    Byte MsgGroupResponse = 13;

    Byte ReconnectRequest = 14;

}
