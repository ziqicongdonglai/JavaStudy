package io.github.ziqicongdonglai.chat.ui.view.login;

import io.github.ziqicongdonglai.chat.ui.Main;
import io.github.ziqicongdonglai.chat.ui.view.UIObject;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.Objects;

/**
 * @author ke_zhang
 * @create 2021-10-22 20:12
 * @description
 * 窗体的初始化操作，可以创建一些待填充的元素
 */
public abstract class LoginInit extends UIObject {

    private static final String RESOURCE_NAME = "view/login/login.fxml";

    protected ILoginEvent loginEvent;

    public Button loginMin;
    public Button loginClose;
    public Button loginButton;
    public TextField userId;
    public PasswordField userPassword;

    LoginInit(ILoginEvent loginEvent) {
        this.loginEvent = loginEvent;
        try {
            root = FXMLLoader.load(Objects.requireNonNull(Main.class.getResource(RESOURCE_NAME)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);
        setScene(scene);
        initStyle(StageStyle.TRANSPARENT);
        setResizable(false);
        obtain();
        initView();
        initEventDefine();
    }

    private void obtain() {
        loginMin = $("loginMin");
        loginClose = $("loginClose");
        loginButton = $("loginButton");
        userId = $("userId");
        userPassword = $("userPassword");
    }

}
