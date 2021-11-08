package io.github.ziqicongdonglai.chat.client.application;

import io.github.ziqicongdonglai.chat.ui.view.chat.IChatMethod;
import io.github.ziqicongdonglai.chat.ui.view.login.ILoginMethod;

/**
 * @author ke_zhang
 * @create 2021-11-06 23:39
 * @description 网络服务
 */
public class UIService {


    private ILoginMethod login;
    private IChatMethod chat;

    public ILoginMethod getLogin() {
        return login;
    }

    public void setLogin(ILoginMethod login) {
        this.login = login;
    }

    public IChatMethod getChat() {
        return chat;
    }

    public void setChat(IChatMethod chat) {
        this.chat = chat;
    }
}
