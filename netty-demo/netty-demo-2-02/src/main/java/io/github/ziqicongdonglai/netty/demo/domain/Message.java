package io.github.ziqicongdonglai.netty.demo.domain;

import java.io.Serializable;

/**
 * @author ke_zhang
 * @create 2021-11-02 23:31
 * @description 消息对象
 */
public class Message implements Serializable {

    /**
     * 消息类型
     */
    private byte type;

    /**
     * 消息长度
     */
    private int length;

    /**
     * 消息体
     */
    private String msgBody;

    public Message(byte type, int length, String msgBody) {
        this.type = type;
        this.length = length;
        this.msgBody = msgBody;
    }

    public Message() {
    }

    public byte getType() {
        return type;
    }

    public void setType(byte type) {
        this.type = type;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getMsgBody() {
        return msgBody;
    }

    public void setMsgBody(String msgBody) {
        this.msgBody = msgBody;
    }

}
