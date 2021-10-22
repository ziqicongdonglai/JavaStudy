package io.github.ziqicongdonglai.chat.ui.view.login;

/**
 * @author ke_zhang
 * @create 2021-10-22 20:12
 * @description
 * 窗体的展示，主要用于扩展一些随着用户操作新展示的元素，例如后续在聊天窗体新增的消息提醒等
 */
public class LoginView {
    private LoginInit loginInit;
    private ILoginEvent loginEvent;

    public LoginView(LoginInit loginInit, ILoginEvent loginEvent) {
        this.loginInit = loginInit;
        this.loginEvent = loginEvent;
    }

    public LoginView() {
    }

    public LoginInit getLoginInit() {
        return loginInit;
    }

    public void setLoginInit(LoginInit loginInit) {
        this.loginInit = loginInit;
    }

    public ILoginEvent getLoginEvent() {
        return loginEvent;
    }

    public void setLoginEvent(ILoginEvent loginEvent) {
        this.loginEvent = loginEvent;
    }
}
