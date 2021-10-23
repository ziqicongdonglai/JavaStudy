package io.github.ziqicongdonglai.chat.ui;

import io.github.ziqicongdonglai.chat.ui.view.chat.ChatController;
import io.github.ziqicongdonglai.chat.ui.view.chat.IChatMethod;
import io.github.ziqicongdonglai.chat.ui.view.login.ILoginMethod;
import io.github.ziqicongdonglai.chat.ui.view.login.LoginController;
import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Date;

/**
 * 启动主类
 */
public class Main extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        ILoginMethod login = new LoginController(((userId, userPassword) -> {
            if ("zk".equals(userId) && "123321".equals(userPassword)) {
                // 登录成功，弹框
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.titleProperty().set("提示");
                alert.headerTextProperty().set("登录成功！");
                alert.showAndWait();
                IChatMethod chat = new ChatController();
                chat.doShow();
                // 填充对话框测试数据
                chat.addTalkBox(-1, 0, "1000001", "糖1", "https://cdn.jsdelivr.net/gh/ziqicongdonglai/blogpic/img/2021/tang1.jpg", "我是该团第一", new Date(), true);
                chat.addTalkBox(-1, 0, "1000002", "糖2", "https://cdn.jsdelivr.net/gh/ziqicongdonglai/blogpic/img/2021/tang2.jpg", "我是该团第二", new Date(), false);
                chat.addTalkBox(-1, 0, "1000003", "糖3", "https://cdn.jsdelivr.net/gh/ziqicongdonglai/blogpic/img/2021/tang3.jpg", "我是该团第三", new Date(), false);
                chat.addTalkBox(-1, 0, "1000004", "糖4", "https://cdn.jsdelivr.net/gh/ziqicongdonglai/blogpic/img/2021/tang4.jpg", "我是该团第四", new Date(), false);
                chat.addTalkBox(-1, 0, "1000005", "糖5", "https://cdn.jsdelivr.net/gh/ziqicongdonglai/blogpic/img/2021/tang5.jpg", "我是该团第五", new Date(), false);
                chat.addTalkBox(-1, 0, "1000006", "糖6", "https://cdn.jsdelivr.net/gh/ziqicongdonglai/blogpic/img/2021/tang6.jpg", "我是该团第六", new Date(), false);
                chat.addTalkBox(-1, 0, "1000007", "zk", "https://cdn.jsdelivr.net/gh/ziqicongdonglai/blogpic/img/2021/avatar.jpg", "破坏队形，路过打酱油~", new Date(), false);
                chat.addTalkBox(-1, 0, "1000008", "糖7", "https://cdn.jsdelivr.net/gh/ziqicongdonglai/blogpic/img/2021/tangzhi.jpg", "我是该团第七", new Date(), false);
                chat.addTalkBox(-1, 0, "1000009", "糖纸", "https://cdn.jsdelivr.net/gh/ziqicongdonglai/blogpic/img/2021/tangzhi.jpg", "我们是应援一个糊团的粉丝...", new Date(), false);
                chat.addTalkBox(0, 1, "5307397", "软件2126", "https://cdn.jsdelivr.net/gh/ziqicongdonglai/blogpic/img/2021/qqgroup.png", "我的班级", new Date(), false);
            }
        }));
        login.doShow();
    }


    public static void main(String[] args) {
        launch(args);
    }
}