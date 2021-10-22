package io.github.ziqicongdonglai.chat.ui;

import io.github.ziqicongdonglai.chat.ui.view.chat.ChatController;
import io.github.ziqicongdonglai.chat.ui.view.chat.IChatMethod;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * 启动主类
 */
public class Main extends Application {

    //@Override
    //public void start(Stage stage) throws IOException {
    //    ILoginMethod login = new LoginController((userId, userPassword) -> {
    //        System.out.println("登录 userId：" + userId + "userPassword：" + userPassword);
    //    });
    //
    //    login.doShow();
    //}

    @Override
    public void start(Stage stage) throws IOException {
        IChatMethod chat = new ChatController();
        chat.doShow();
    }


    public static void main(String[] args) {
        launch(args);
    }
}