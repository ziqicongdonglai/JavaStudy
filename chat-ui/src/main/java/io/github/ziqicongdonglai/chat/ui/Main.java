package io.github.ziqicongdonglai.chat.ui;

import io.github.ziqicongdonglai.chat.ui.view.chat.ChatController;
import io.github.ziqicongdonglai.chat.ui.view.chat.IChatEvent;
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
                IChatMethod chat = new ChatController(new IChatEvent() {
                });
                chat.doShow();
                chat.setUserInfo("1000001", "zk", "https://cdn.jsdelivr.net/gh/ziqicongdonglai/blogpic/img/2021/avatar.jpg");
                //好友 - 对话框
                chat.addTalkBox(-1, 0, "1000001", "糖1 fans", "https://cdn.jsdelivr.net/gh/ziqicongdonglai/blogpic/img/2021/tang1.jpg", "", new Date(), false);
                chat.addTalkMsgRight("1000001", "xlnyg，是糖团出道第一名", new Date(), true, true, false);
                chat.addTalkMsgUserLeft("1000001", "糖团第一名", new Date(), true, false, true);

                chat.addTalkBox(-1, 0, "1000002", "糖2 fans", "https://cdn.jsdelivr.net/gh/ziqicongdonglai/blogpic/img/2021/tang2.jpg", "", new Date(), false);
                chat.addTalkMsgRight("1000002", "zy，是糖团出道第二名", new Date(), true, false, false);
                chat.addTalkMsgUserLeft("1000002", "糖团第二名", new Date(), true, false, true);

                chat.addTalkBox(-1, 0, "1000003", "糖3 fans", "https://cdn.jsdelivr.net/gh/ziqicongdonglai/blogpic/img/2021/tang3.jpg", "", new Date(), false);
                chat.addTalkMsgRight("1000003", "wyj，是糖团出道第三名", new Date(), true, false, false);
                chat.addTalkMsgUserLeft("1000003", "糖团第三名", new Date(), true, false, true);

                chat.addTalkBox(-1, 0, "1000004", "糖4 fans", "https://cdn.jsdelivr.net/gh/ziqicongdonglai/blogpic/img/2021/tang4.jpg", "", new Date(), false);
                chat.addTalkMsgRight("1000004", "czx，是糖团出道第四名", new Date(), true, false, false);
                chat.addTalkMsgUserLeft("1000004", "糖团第四名", new Date(), true, false, true);

                // 群组 - 对话框
                chat.addTalkBox(0, 1, "5307397", "糖团粉丝应援群", "https://cdn.jsdelivr.net/gh/ziqicongdonglai/blogpic/img/2021/tangzhi.jpg", "", new Date(), true);
                chat.addTalkMsgRight("5307397", "有没有看最新的团的vlog", new Date(), true, true, false);
                chat.addTalkMsgGroupLeft("5307397", "1000003", "糖1 fans", "https://cdn.jsdelivr.net/gh/ziqicongdonglai/blogpic/img/2021/tang1.jpg", "xlnyg，还是那么好看", new Date(), true, false, true);
                chat.addTalkMsgGroupLeft("5307397", "1000004", "糖2 fans", "https://cdn.jsdelivr.net/gh/ziqicongdonglai/blogpic/img/2021/tang2.jpg", "2 和 3 的 cp真好ke", new Date(), true, false, true);
                chat.addTalkMsgGroupLeft("5307397", "1000002", "糖3 fans", "https://cdn.jsdelivr.net/gh/ziqicongdonglai/blogpic/img/2021/tang3.jpg", "yj模仿口音还是看一次笑一次", new Date(), true, false, true);
                chat.addTalkMsgGroupLeft("5307397", "1000005", "糖4 fans", "https://cdn.jsdelivr.net/gh/ziqicongdonglai/blogpic/img/2021/tang4.jpg", "zx不亏为狂小璇", new Date(), true, false, true);
            }
        }));
        login.doShow();
    }


    public static void main(String[] args) {
        launch(args);
    }
}