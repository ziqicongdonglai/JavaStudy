package io.github.ziqicongdonglai.chat.ui.view.chat.data;

import java.util.Date;

/**
 * @author ke_zhang
 * @create 2021-10-24 0:25
 * @description TalkBoxData
 */
public class TalkBoxData {
    private int talkIdx;
    private Integer talkType;
    private String talkId;
    private String talkName;
    private String talkHead;
    private String talkSketch;
    private Date talkDate;
    private Boolean selected;

    public TalkBoxData(String talkId, Integer talkType, String talkName, String talkHead) {
        this.talkType = talkType;
        this.talkId = talkId;
        this.talkName = talkName;
        this.talkHead = talkHead;
    }

    public TalkBoxData() {
    }

    public int getTalkIdx() {
        return talkIdx;
    }

    public void setTalkIdx(int talkIdx) {
        this.talkIdx = talkIdx;
    }

    public Integer getTalkType() {
        return talkType;
    }

    public void setTalkType(Integer talkType) {
        this.talkType = talkType;
    }

    public String getTalkId() {
        return talkId;
    }

    public void setTalkId(String talkId) {
        this.talkId = talkId;
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

    public String getTalkSketch() {
        return talkSketch;
    }

    public void setTalkSketch(String talkSketch) {
        this.talkSketch = talkSketch;
    }

    public Date getTalkDate() {
        return talkDate;
    }

    public void setTalkDate(Date talkDate) {
        this.talkDate = talkDate;
    }

    public Boolean getSelected() {
        return selected;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }

    @Override
    public String toString() {
        return "TalkBoxData{" +
                "talkIdx=" + talkIdx +
                ", talkType=" + talkType +
                ", talkId='" + talkId + '\'' +
                ", talkName='" + talkName + '\'' +
                ", talkHead='" + talkHead + '\'' +
                ", talkSketch='" + talkSketch + '\'' +
                ", talkDate=" + talkDate +
                ", selected=" + selected +
                '}';
    }
}
