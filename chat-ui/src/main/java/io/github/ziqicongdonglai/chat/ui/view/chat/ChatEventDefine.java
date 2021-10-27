package io.github.ziqicongdonglai.chat.ui.view.chat;

import io.github.ziqicongdonglai.chat.ui.view.chat.data.TalkBoxData;
import io.github.ziqicongdonglai.chat.ui.view.face.FaceController;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;

import java.util.Date;

/**
 * @author ke_zhang
 * @create 2021-10-23 1:26
 * @description 窗体事件定义
 */
public class ChatEventDefine {

    private final ChatInit chatInit;
    private final IChatEvent chatEvent;
    private final IChatMethod chatMethod;

    public ChatEventDefine(ChatInit chatInit, IChatEvent chatEvent, IChatMethod chatMethod) {
        this.chatInit = chatInit;
        this.chatEvent = chatEvent;
        this.chatMethod = chatMethod;

        chatInit.move();     //移动
        min();               // 最小化
        quit();              // 退出
        this.barChat();
        this.barFriend();
        this.barLocation();
        this.barSet();
        doEventTextSend();   // 发送消息事件[键盘]
        doEventTouchSend();  // 发送消息事件[按钮]
        doEventToolFace(); // 处理表情框事件
    }

    /**
     * 最小化
     */
    private void min() {
        chatInit.$("group_bar_chat_min", Button.class).setOnAction(event -> {
            chatInit.setIconified(true);
        });
        chatInit.$("group_bar_friend_min", Button.class).setOnAction(event -> {
            chatInit.setIconified(true);
        });
    }

    /**
     * 退出
     */
    private void quit() {
        chatInit.$("group_bar_chat_close", Button.class).setOnAction(event -> {
            chatInit.close();
            System.exit(0);
        });
        chatInit.$("group_bar_friend_close", Button.class).setOnAction(event -> {
            chatInit.close();
            System.exit(0);
        });
    }

    private void switchBarChat(Button barChat, Pane groupBarChat, boolean toggle) {
        if (toggle) {
            groupBarChat.setVisible(true);
            barChat.getGraphic().setStyle("-fx-icon-color:'#A8DC61'");
        } else {
            groupBarChat.setVisible(false);
            barChat.getGraphic().setStyle("-fx-icon-color:'#6F6F70'");
        }
    }

    private void switchBarFriend(Button barFriend, Pane groupBarFriend, boolean toggle) {
        if (toggle) {
            groupBarFriend.setVisible(true);
            barFriend.getGraphic().setStyle("-fx-icon-color:'#A8DC61'");
        } else {
            groupBarFriend.setVisible(false);
            barFriend.getGraphic().setStyle("-fx-icon-color:'#6F6F70'");

        }
    }

    private void switchBarLocation(Button barLocation, Pane groupBarLocation, boolean toggle) {
        if (toggle) {
            groupBarLocation.setVisible(true);
            barLocation.getGraphic().setStyle("-fx-icon-color:'#A8DC61'");
        } else {
            groupBarLocation.setVisible(false);
            barLocation.getGraphic().setStyle("-fx-icon-color:'#6F6F70'");
        }
    }

    private void switchBarSet(Button barSet, Pane groupBarSet, boolean toggle) {
        if (toggle) {
            groupBarSet.setVisible(true);
            barSet.getGraphic().setStyle("-fx-icon-color:'#A8DC61'");
        } else {
            groupBarSet.setVisible(false);
            barSet.getGraphic().setStyle("-fx-icon-color:'#6F6F70'");
        }
    }

    private void barChat() {
        Button barChat = chatInit.$("barChat", Button.class);
        Pane groupBarChat = chatInit.$("groupBarChat", Pane.class);
        barChat.setOnAction(event -> {
            switchBarChat(barChat, groupBarChat, true);
            switchBarFriend(chatInit.$("barFriend", Button.class), chatInit.$("groupBarFriend", Pane.class), false);
            switchBarLocation(chatInit.$("barLocation", Button.class), chatInit.$("groupBarLocation", Pane.class), false);
            switchBarSet(chatInit.$("barSet", Button.class), chatInit.$("groupBarSet", Pane.class), false);
        });

        barChat.setOnMouseEntered(event -> {
            boolean visible = groupBarChat.isVisible();
            if (visible) {
                return;
            }
            barChat.getGraphic().setStyle("-fx-icon-color:'#F6F6F6'");
        });
        barChat.setOnMouseExited(event -> {
            boolean visible = groupBarChat.isVisible();
            if (visible) {
                return;
            }
            barChat.getGraphic().setStyle("-fx-icon-color:'#6F6F70'");
        });
    }

    private void barFriend() {
        Button barFriend = chatInit.$("barFriend", Button.class);
        Pane groupBarFriend = chatInit.$("groupBarFriend", Pane.class);
        barFriend.setOnAction(event -> {
                    switchBarChat(chatInit.$("barChat", Button.class), chatInit.$("groupBarChat", Pane.class), false);
                    switchBarFriend(barFriend, groupBarFriend, true);
                    switchBarLocation(chatInit.$("barLocation", Button.class), chatInit.$("groupBarLocation", Pane.class), false);
                    switchBarSet(chatInit.$("barSet", Button.class), chatInit.$("groupBarSet", Pane.class), false);
                }
        );
        barFriend.setOnMouseEntered(event -> {
            boolean visible = groupBarFriend.isVisible();
            if (visible) {
                return;
            }
            barFriend.getGraphic().setStyle("-fx-icon-color:'#F6F6F6'");
        });
        barFriend.setOnMouseExited(event -> {
            boolean visible = groupBarFriend.isVisible();
            if (visible) {
                return;
            }
            barFriend.getGraphic().setStyle("-fx-icon-color:'#6F6F70'");
        });
    }

    private void barLocation() {
        Button barLocation = chatInit.$("barLocation", Button.class);
        Pane groupBarLocation = chatInit.$("groupBarLocation", Pane.class);
        barLocation.setOnAction(event -> {
                    switchBarChat(chatInit.$("barChat", Button.class), chatInit.$("groupBarChat", Pane.class), false);
                    switchBarFriend(chatInit.$("barFriend", Button.class), chatInit.$("groupBarFriend", Pane.class), false);
                    switchBarLocation(barLocation, groupBarLocation, true);
                    switchBarSet(chatInit.$("barSet", Button.class), chatInit.$("groupBarSet", Pane.class), false);
                }
        );
        barLocation.setOnMouseEntered(event -> {
            boolean visible = groupBarLocation.isVisible();
            if (visible) {
                return;
            }
            barLocation.getGraphic().setStyle("-fx-icon-color:'#F6F6F6'");
        });
        barLocation.setOnMouseExited(event -> {
            boolean visible = groupBarLocation.isVisible();
            if (visible) {
                return;
            }
            barLocation.getGraphic().setStyle("-fx-icon-color:'#6F6F70'");
        });
    }

    private void barSet() {
        Button barSet = chatInit.$("barSet", Button.class);
        Pane groupBarSet = chatInit.$("groupBarSet", Pane.class);
        barSet.setOnAction(event -> {
            switchBarChat(chatInit.$("barChat", Button.class), chatInit.$("groupBarChat", Pane.class), false);
            switchBarFriend(chatInit.$("barFriend", Button.class), chatInit.$("groupBarFriend", Pane.class), false);
            switchBarLocation(chatInit.$("barLocation", Button.class), chatInit.$("groupBarLocation", Pane.class), false);
            switchBarSet(barSet, groupBarSet, true);
        });

        barSet.setOnMouseEntered(event -> {
            boolean visible = groupBarSet.isVisible();
            if (visible) {
                return;
            }
            barSet.getGraphic().setStyle("-fx-icon-color:'#F6F6F6'");
        });
        barSet.setOnMouseExited(event -> {
            boolean visible = groupBarSet.isVisible();
            if (visible) {
                return;
            }
            barSet.getGraphic().setStyle("-fx-icon-color:'#6F6F70'");
        });
    }

    /**
     * 发送消息
     */
    private void doEventTouchSend() {
        Label touch_send = chatInit.$("touch_send", Label.class);
        touch_send.setOnMousePressed(event -> {
            doEventSendMsg();
        });
    }


    /**
     * 发送消息快捷键
     */
    private void doEventTextSend() {
        TextArea txt_input = chatInit.$("txt_input", TextArea.class);
        txt_input.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
                doEventSendMsg();
            }
        });
    }

    private void doEventSendMsg() {
        TextArea txt_input = chatInit.$("txt_input", TextArea.class);
        MultipleSelectionModel selectionModel = chatInit.$("talkList", ListView.class).getSelectionModel();
        Pane selectedItem = (Pane) selectionModel.getSelectedItem();
        // 对话信息
        TalkBoxData talkBoxData = (TalkBoxData) selectedItem.getUserData();
        String msg = txt_input.getText();
        if (null == msg || "".equals(msg) || "".equals(msg.trim())) {
            return;
        }
        Date msgDate = new Date();
        // 发送消息
        System.out.println("发送消息：" + msg);
        // 发送事件给自己添加消息
        chatMethod.addTalkMsgRight(talkBoxData.getTalkId(), msg, msgDate, true, true, false);
        txt_input.clear();
    }

    /**
     * 处理表情框事件
     */
    private void doEventToolFace() {
        FaceController face = new FaceController(chatInit, chatInit, chatEvent, chatMethod);
        Button tool_face = chatInit.$("tool_face", Button.class);
        tool_face.setOnMousePressed(event -> {
            face.doShowFace(chatMethod.getToolFaceX(), chatMethod.getToolFaceY());
        });
    }
}