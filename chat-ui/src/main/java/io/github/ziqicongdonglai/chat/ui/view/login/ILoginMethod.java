package io.github.ziqicongdonglai.chat.ui.view.login;

/**
 * @author ke_zhang
 * @create 2021-10-22 20:11
 * @description
 * 方法接口类，桌面程序的开发基本都是事件触发和等待回调，那么我们给外部提供接口主要用于类似登录
 * 来执行相应方法进行窗体切换或者数据填充
 */
public interface ILoginMethod {

    /**
     * 打开登陆窗口
     */
    void doShow();

    /**
     * 登陆失败
     */
    void doLoginError();

    /**
     * 登陆成功；跳转聊天窗口（关闭登陆窗口，打开新窗口）
     */
    void doLoginSuccess();

}
