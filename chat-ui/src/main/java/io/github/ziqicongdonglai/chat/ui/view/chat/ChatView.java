package io.github.ziqicongdonglai.chat.ui.view.chat;

/**
 * @author ke_zhang
 * @create 2021-10-23 1:26
 * @description 窗体的展示
 */
public class ChatView {

    private ChatInit chatInit;
    private IChatEvent chatEvent;

    public ChatView(ChatInit chatInit, IChatEvent chatEvent) {
        this.chatInit = chatInit;
        this.chatEvent = chatEvent;
    }

    public ChatView() {
    }

    public ChatInit getChatInit() {
        return chatInit;
    }

    public void setChatInit(ChatInit chatInit) {
        this.chatInit = chatInit;
    }

    public IChatEvent getChatEvent() {
        return chatEvent;
    }

    public void setChatEvent(IChatEvent chatEvent) {
        this.chatEvent = chatEvent;
    }
}
