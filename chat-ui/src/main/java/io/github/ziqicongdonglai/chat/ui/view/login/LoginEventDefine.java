package io.github.ziqicongdonglai.chat.ui.view.login;

/**
 * @author ke_zhang
 * @create 2021-10-22 20:12
 * @description 窗体事件定义，例如将登录、最小化、退出等在这里完成定义
 */
public class LoginEventDefine {
    private final LoginInit loginInit;
    private final ILoginEvent loginEvent;
    private ILoginMethod loginMethod;

    public LoginEventDefine(LoginInit loginInit, ILoginEvent loginEvent, ILoginMethod loginMethod) {
        this.loginInit = loginInit;
        this.loginEvent = loginEvent;
        this.loginMethod = loginMethod;

        loginInit.move();
        min();
        quit();
        doEventLogin();
    }

    /**
     * 最小化
     */
    private void min() {
        loginInit.loginMin.setOnAction(event -> {
            loginInit.setIconified(true);
        });
    }


    /**
     * 退出
     */
    private void quit() {
        loginInit.loginClose.setOnAction(event -> {
            loginInit.close();
            System.exit(0);
        });
    }

    /**
     * 登录
     */
    private void doEventLogin() {
        loginInit.loginButton.setOnAction(event -> {
            loginEvent.doLoginCheck(loginInit.userId.getText(), loginInit.userPassword.getText());
        });
    }
}
