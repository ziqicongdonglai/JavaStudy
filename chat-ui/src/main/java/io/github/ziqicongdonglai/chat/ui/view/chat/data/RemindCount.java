package io.github.ziqicongdonglai.chat.ui.view.chat.data;

/**
 * @author ke_zhang
 * @create 2021-10-24 19:18
 * @description 消息提醒
 */
public class RemindCount {

    /**
     * 消息提醒条数
     */
    private int count = 0;

    public RemindCount() {
    }

    public RemindCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
