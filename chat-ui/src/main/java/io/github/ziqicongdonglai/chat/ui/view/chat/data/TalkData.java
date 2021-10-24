package io.github.ziqicongdonglai.chat.ui.view.chat.data;

/**
 * @author ke_zhang
 * @create 2021-10-24 19:18
 * @description 对话框用户数据
 */
public class TalkData {

    private String talkName;
    private String talkHead;

    public TalkData() {
    }

    public TalkData(String talkName, String talkHead) {
        this.talkName = talkName;
        this.talkHead = talkHead;
    }

    public String getTalkName() {
        return talkName;
    }

    public void setTalkName(String talkName) {
        this.talkName = talkName;
    }

    public String getTalkHead() {
        return talkHead;
    }

    public void setTalkHead(String talkHead) {
        this.talkHead = talkHead;
    }

}
