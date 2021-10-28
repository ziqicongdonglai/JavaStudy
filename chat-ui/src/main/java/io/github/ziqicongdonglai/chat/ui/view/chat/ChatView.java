package io.github.ziqicongdonglai.chat.ui.view.chat;

import io.github.ziqicongdonglai.chat.ui.param.AppConst;
import io.github.ziqicongdonglai.chat.ui.view.chat.data.RemindCount;
import io.github.ziqicongdonglai.chat.ui.view.chat.data.TalkBoxData;
import io.github.ziqicongdonglai.chat.ui.view.chat.group_bar_friend.*;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;

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

        //1. 好友列表添加工具方法‘新的朋友’
        initAddFriendNew();
        //2. 好友列表添加‘公众号’
        addFriendSubscription();
        //3. 好友群组框体
        addFriendGroupList();
        //4. 好友框体
        addFriendUserList();

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

    /**
     * 消息提醒功能
     *
     * @param msgRemindLabel 消息提醒标签
     * @param talkType       消息类型
     * @param isRemind       是否要提醒
     */
    private void isRemind(Label msgRemindLabel, int talkType, Boolean isRemind) {
        if (!isRemind) return;
        msgRemindLabel.setVisible(true);
        // 群组直接展示小红点
        if (1 == talkType) {
            return;
        }
        RemindCount remindCount = (RemindCount) msgRemindLabel.getUserData();
        // 超过 10 个展示省略号
        if (remindCount.getCount() > 99) {
            msgRemindLabel.setText("···");
            return;
        }
        int count = remindCount.getCount() + 1;
        msgRemindLabel.setUserData(new RemindCount(count));
        msgRemindLabel.setText(String.valueOf(count));
    }

    /**
     * 清空消息提醒
     *
     * @param msgRemindLabel 消息提醒标签
     */
    private void clearRemind(Label msgRemindLabel) {
        msgRemindLabel.setVisible(false);
        msgRemindLabel.setUserData(new RemindCount(0));
    }

    /**
     * 更新对话框列表元素位置指定并选中[在聊天消息发送时触达]
     *
     * @param talkType        对话框类型[0好友、1群组]
     * @param talkElementPane 对话框元素面板
     * @param msgRemindLabel  消息提醒标签
     * @param idxFirst        是否设置首位
     * @param selected        是否选中
     * @param isRemind        是否提醒
     */
    void updateTalkListIdxAndSelected(int talkType, Pane talkElementPane, Label msgRemindLabel, Boolean idxFirst, Boolean selected, Boolean isRemind) {
        // 对话框ID、好友ID
        TalkBoxData talkBoxData = (TalkBoxData) talkElementPane.getUserData();
        // 填充到对话框
        ListView<Pane> talkList = chatInit.$("talkList", ListView.class);
        // 对话空为空，初始化[置顶、选中、提醒]
        if (talkList.getItems().isEmpty()) {
            if (idxFirst) {
                talkList.getItems().add(0, talkElementPane);
            }
            if (selected) {
                // 设置对话框[√选中]
                talkList.getSelectionModel().select(talkElementPane);
            }
            isRemind(msgRemindLabel, talkType, isRemind);
            return;
        }
        // 对话空不为空，判断第一个元素是否当前聊天Pane
        Pane firstPane = talkList.getItems().get(0);
        // 判断元素是否在首位，如果是首位可返回不需要重新设置首位
        if (talkBoxData.getTalkId().equals(((TalkBoxData) firstPane.getUserData()).getTalkId())) {
            Pane selectedItem = talkList.getSelectionModel().getSelectedItem();
            // 选中判断；如果第一个元素已经选中[说明正在会话]，那么清空消息提醒
            if (null == selectedItem) {
                isRemind(msgRemindLabel, talkType, isRemind);
                return;
            }
            TalkBoxData selectedItemUserData = (TalkBoxData) selectedItem.getUserData();
            if (null != selectedItemUserData && talkBoxData.getTalkId().equals(selectedItemUserData.getTalkId())) {
                clearRemind(msgRemindLabel);
            } else {
                isRemind(msgRemindLabel, talkType, isRemind);
            }
            return;
        }
        if (idxFirst) {
            talkList.getItems().remove(talkElementPane);
            talkList.getItems().add(0, talkElementPane);
        }
        if (selected) {
            // 设置对话框[√选中]
            talkList.getSelectionModel().select(talkElementPane);
        }
        isRemind(msgRemindLabel, talkType, isRemind);
    }

    /**
     * 好友列表，搜索、添加新朋友
     */
    private void initAddFriendNew() {
        ListView<Pane> friendList = chatInit.$("friendList", ListView.class);
        ObservableList<Pane> items = friendList.getItems();

        ElementFriendTag elementFriendTag = new ElementFriendTag("新的朋友");
        items.add(elementFriendTag.pane());

        ElementFriendNew element = new ElementFriendNew();
        Pane pane = element.pane();
        items.add(pane);

        // 面板填充和事件
        pane.setOnMousePressed(event -> {
            Pane friendNewPane = element.friendPane();
            setContentPaneBox("chat-ui-chat-friend-new", "新的朋友", friendNewPane);
            chatInit.clearViewListSelectedAll(chatInit.$("userListView", ListView.class), chatInit.$("groupListView", ListView.class));
            ListView<Pane> listView = element.friendListView();
            listView.getItems().clear();
            System.out.println("添加好友");
        });

        // 搜索框事件
        TextField friendLuckSearch = element.friendSearch();

        // 键盘事件；搜索好友
        friendLuckSearch.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
                String text = friendLuckSearch.getText();
                if (null == text) {
                    text = "";
                }
                if (text.length() > AppConst.TALK_SKETCH_LENGTH) {
                    text = text.substring(0, AppConst.TALK_SKETCH_LENGTH);
                }
                text = text.trim();
                System.out.println("搜索好友：" + text);
                // 搜索清空元素
                element.friendListView().getItems().clear();
                // 添加朋友
                element.friendListView().getItems().add(new ElementFriendNewUser("1000007", "陈蓉琪", "https://cdn.jsdelivr.net/gh/ziqicongdonglai/blogpic/img/2021/crq.jpg", 0).pane());
                element.friendListView().getItems().add(new ElementFriendNewUser("1000008", "姜新雨", "https://cdn.jsdelivr.net/gh/ziqicongdonglai/blogpic/img/2021/jxy.jpg", 2).pane());
                element.friendListView().getItems().add(new ElementFriendNewUser("1000009", "刘一飞", "https://cdn.jsdelivr.net/gh/ziqicongdonglai/blogpic/img/2021/lyf.jpg", 1).pane());
                element.friendListView().getItems().add(new ElementFriendNewUser("10000010", "刘佳君", "https://cdn.jsdelivr.net/gh/ziqicongdonglai/blogpic/img/2021/ljj.jpg", 1).pane());
            }
        });
    }

    /**
     * 好友列表添加公众号
     */
    private void addFriendSubscription() {
        ListView<Pane> friendList = chatInit.$("friendList", ListView.class);
        ObservableList<Pane> items = friendList.getItems();

        ElementFriendTag elementFriendTag = new ElementFriendTag("公众号");
        items.add(elementFriendTag.pane());

        ElementFriendSubscription element = new ElementFriendSubscription();
        Pane pane = element.pane();
        items.add(pane);

        pane.setOnMousePressed(event -> {
            chatInit.clearViewListSelectedAll(chatInit.$("userListView", ListView.class), chatInit.$("groupListView", ListView.class));
            Pane subPane = element.subPane();
            setContentPaneBox("userListView", "公众号", subPane);
        });
    }

    /**
     * 好友群组
     */
    private void addFriendGroupList() {
        ListView<Pane> friendList = chatInit.$("friendList", ListView.class);
        ObservableList<Pane> items = friendList.getItems();

        ElementFriendTag elementFriendTag = new ElementFriendTag("群聊");
        items.add(elementFriendTag.pane());

        ElementFriendGroupList element = new ElementFriendGroupList();
        Pane pane = element.pane();
        items.add(pane);
    }

    /**
     * 好友列表
     */
    private void addFriendUserList() {
        ListView<Pane> friendList = chatInit.$("friendList", ListView.class);
        ObservableList<Pane> items = friendList.getItems();

        ElementFriendTag elementFriendTag = new ElementFriendTag("好友");
        items.add(elementFriendTag.pane());

        ElementFriendUserList element = new ElementFriendUserList();
        Pane pane = element.pane();
        items.add(pane);
    }

    /**
     * group_bar_chat：填充对话列表 & 对话框名称
     *
     * @param id   用户、群组等ID
     * @param name 用户、群组等名称
     * @param node 展现面板
     */
    void setContentPaneBox(String id, String name, Node node) {
        // 填充对话列表
        Pane contentPaneBox = chatInit.$("content_pane_box", Pane.class);
        contentPaneBox.setUserData(id);
        contentPaneBox.getChildren().clear();
        contentPaneBox.getChildren().add(node);
        // 对话框名称
        Label infoName = chatInit.$("content_name", Label.class);
        infoName.setText(name);
    }
}
