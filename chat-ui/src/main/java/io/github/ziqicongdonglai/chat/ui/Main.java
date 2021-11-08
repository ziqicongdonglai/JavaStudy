package io.github.ziqicongdonglai.chat.ui;

import io.github.ziqicongdonglai.chat.ui.view.chat.ChatController;
import io.github.ziqicongdonglai.chat.ui.view.chat.IChatEvent;
import io.github.ziqicongdonglai.chat.ui.view.chat.IChatMethod;
import io.github.ziqicongdonglai.chat.ui.view.chat.group_bar_friend.ElementFriendNewUser;
import javafx.application.Application;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Date;

/**
 * 启动主类
 */
public class Main extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        //ILoginMethod login = new LoginController(((userId, userPassword) -> {
        //    if ("zk".equals(userId) && "123321".equals(userPassword)) {
        //        // 登录成功，弹框
        //        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        //        alert.titleProperty().set("提示");
        //        alert.headerTextProperty().set("登录成功！");
        //        alert.showAndWait();
        // 事件类实现并注入
        IChatMethod chat = new ChatController(new IChatEvent() {
            @Override
            public void doQuit() {
                System.out.println("退出操作！");
            }

            @Override
            public void doSendMsg(String userId, String talkId, Integer talkType, String msg, Integer msgType, Date msgDate) {
                System.out.println("发送消息");
                System.out.println("userId：" + userId);
                System.out.println("talkType[0好友/1群组]：" + talkType);
                System.out.println("talkId：" + talkId);
                System.out.println("msg：" + msg);
                System.out.println("msgType[0文字消息/1固定表情]：" + msgType);
            }

            @Override
            public void doEventAddTalkUser(String userId, String userFriendId) {
                System.out.println("填充到聊天窗口[好友] userFriendId：" + userFriendId);
            }

            @Override
            public void doEventAddTalkGroup(String userId, String groupId) {
                System.out.println("填充到聊天窗口[群组] groupId：" + groupId);
            }

            @Override
            public void doEventDelTalkUser(String userId, String talkId) {
                System.out.println("删除对话框：" + talkId);
            }

            @Override
            public void addFriendNew(String userId, ListView<Pane> listView) {
                System.out.println("新的朋友");
                // 添加朋友
                listView.getItems().add(new ElementFriendNewUser("1000007", "陈蓉琪", "https://cdn.jsdelivr.net/gh/ziqicongdonglai/blogpic/img/2021/crq.jpg", 0).pane());
                listView.getItems().add(new ElementFriendNewUser("1000008", "姜新雨", "https://cdn.jsdelivr.net/gh/ziqicongdonglai/blogpic/img/2021/jxy.jpg", 2).pane());
                listView.getItems().add(new ElementFriendNewUser("1000009", "刘一飞", "https://cdn.jsdelivr.net/gh/ziqicongdonglai/blogpic/img/2021/lyf.jpg", 1).pane());
                listView.getItems().add(new ElementFriendNewUser("10000010", "刘佳君", "https://cdn.jsdelivr.net/gh/ziqicongdonglai/blogpic/img/2021/ljj.jpg", 1).pane());
            }

            @Override
            public void doFriendNewSearch(String userId, String text) {
                System.out.println("搜索好友：" + text);
            }

            @Override
            public void doEventAddNewUser(String userId, String friendId) {
                System.out.println("添加好友：" + friendId);
            }
        });
        chat.doShow();
        chat.setUserInfo("1000001", "zk", "https://cdn.jsdelivr.net/gh/ziqicongdonglai/blogpic/img/2021/avatar.jpg");
        // 好友
        chat.addFriendUser(false, "1000002", "陶然然", "https://cdn.jsdelivr.net/gh/ziqicongdonglai/blogpic/img/2021/t_mqxu.jpg");
        chat.addFriendUser(false, "1000003", "糖1 fans", "https://cdn.jsdelivr.net/gh/ziqicongdonglai/blogpic/img/2021/tang1.jpg");
        chat.addFriendUser(false, "1000004", "糖2 fans", "https://cdn.jsdelivr.net/gh/ziqicongdonglai/blogpic/img/2021/tang2.jpg");
        chat.addFriendUser(false, "1000005", "糖3 fans", "https://cdn.jsdelivr.net/gh/ziqicongdonglai/blogpic/img/2021/tang3.jpg");
        chat.addFriendUser(false, "1000006", "糖4 fans", "https://cdn.jsdelivr.net/gh/ziqicongdonglai/blogpic/img/2021/tang4.jpg");

        // 群组
        chat.addFriendGroup("2000001", "软件2126", "https://cdn.jsdelivr.net/gh/ziqicongdonglai/blogpic/img/2021/qqgroup.png");
        chat.addFriendGroup("2000002", "糖团粉丝应援群", "https://cdn.jsdelivr.net/gh/ziqicongdonglai/blogpic/img/2021/tangzhi.jpg");

        //好友 - 对话框
        chat.addTalkBox(-1, 0, "1000003", "糖1 fans", "https://cdn.jsdelivr.net/gh/ziqicongdonglai/blogpic/img/2021/tang1.jpg", "", new Date(), false);
        chat.addTalkMsgUserLeft("1000003", "糖团第一名", 0, new Date(), true, false, false);
        chat.addTalkMsgRight("1000003", "xlnyg，是糖团出道第一名", 0, new Date(), true, true, false);
        chat.addTalkMsgUserLeft("1000003", "你好", 0, new Date(), true, false, true);


        chat.addTalkBox(-1, 0, "1000004", "糖2 fans", "https://cdn.jsdelivr.net/gh/ziqicongdonglai/blogpic/img/2021/tang2.jpg", "", new Date(), false);
        chat.addTalkMsgUserLeft("1000004", "糖团第二名", 0, new Date(), true, false, false);
        chat.addTalkMsgRight("1000004", "zy，是糖团出道第二名", 0, new Date(), true, true, false);
        chat.addTalkMsgUserLeft("1000004", "你好", 0, new Date(), true, false, true);

        chat.addTalkBox(-1, 0, "1000005", "糖3 fans", "https://cdn.jsdelivr.net/gh/ziqicongdonglai/blogpic/img/2021/tang3.jpg", "", new Date(), false);
        chat.addTalkMsgUserLeft("1000005", "糖团第三名", 0, new Date(), true, false, false);
        chat.addTalkMsgRight("1000005", "wyj，是糖团出道第三名", 0, new Date(), true, true, false);
        chat.addTalkMsgUserLeft("1000005", "你好", 0, new Date(), true, false, true);

        chat.addTalkBox(-1, 0, "1000006", "糖4 fans", "https://cdn.jsdelivr.net/gh/ziqicongdonglai/blogpic/img/2021/tang4.jpg", "", new Date(), false);
        chat.addTalkMsgUserLeft("1000006", "糖团第四名", 0, new Date(), true, false, false);
        chat.addTalkMsgRight("1000006", "czx，是糖团出道第四名", 0, new Date(), true, true, false);
        chat.addTalkMsgUserLeft("1000006", "你好", 0, new Date(), true, false, true);

        chat.addTalkBox(0, 0, "1000002", "陶然然", "https://cdn.jsdelivr.net/gh/ziqicongdonglai/blogpic/img/2021/t_mqxu.jpg", "", new Date(), false);
        chat.addTalkMsgUserLeft("1000002", "每日打卡 Day35 1.chat-ui : group_bar_friend 2.Daily Reading", 0, new Date(), true, false, false);
        chat.addTalkMsgRight("1000002", "收到，今日的卡已经打完了！", 0, new Date(), true, true, false);
        chat.addTalkMsgUserLeft("1000002", "你好", 0, new Date(), true, false, true);

        // 群组 - 对话框
        chat.addTalkBox(0, 1, "2000001", "糖团粉丝应援群", "https://cdn.jsdelivr.net/gh/ziqicongdonglai/blogpic/img/2021/tangzhi.jpg", "", new Date(), false);
        chat.addTalkMsgRight("2000001", "有没有看最新的团的vlog", 0, new Date(), true, true, false);
        chat.addTalkMsgGroupLeft("2000001", "1000003", "糖1 fans", "https://cdn.jsdelivr.net/gh/ziqicongdonglai/blogpic/img/2021/tang1.jpg", "yj模仿口音还是看一次笑一次", 0, new Date(), true, false, true);
        chat.addTalkMsgGroupLeft("2000001", "1000004", "糖2 fans", "https://cdn.jsdelivr.net/gh/ziqicongdonglai/blogpic/img/2021/tang2.jpg", "xlnyg，还是那么好看", 0, new Date(), true, false, true);
        chat.addTalkMsgGroupLeft("2000001", "1000005", "糖3 fans", "https://cdn.jsdelivr.net/gh/ziqicongdonglai/blogpic/img/2021/tang3.jpg", "2 和 3 的 cp真好ke", 0, new Date(), true, false, true);
        chat.addTalkMsgGroupLeft("2000001", "1000006", "糖4 fans", "https://cdn.jsdelivr.net/gh/ziqicongdonglai/blogpic/img/2021/tang4.jpg", "zx不亏为狂小璇", 0, new Date(), true, false, true);
    }


    public static void main(String[] args) {
        launch(args);
    }
}