package io.github.ziqicongdonglai.chat.ui.view.chat.group_bar_friend;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

/**
 * @author ke_zhang
 * @create 2021-10-27 22:34
 * @description 添加好友
 */
public class ElementFriendUser {

    /**
     * 用户底板(存储用户ID)
     */
    private final Pane pane;

    /**
     * 头像
     */
    private final Label headLabel;
    /**
     * 名称
     */
    private final Label nameLabel;

    public ElementFriendUser(String userId, String userNickName, String userHead) {
        // 用户底板(存储用户ID)
        pane = new Pane();
        pane.setId(userId);
        pane.setPrefWidth(250);
        pane.setPrefHeight(70);
        pane.getStyleClass().add("elementFriendUser");
        ObservableList<Node> children = pane.getChildren();
        // 头像区域
        headLabel = new Label();
        headLabel.setPrefSize(50, 50);
        headLabel.setLayoutX(15);
        headLabel.setLayoutY(10);
        headLabel.getStyleClass().add("elementFriendUser_head");
        headLabel.setStyle(String.format("-fx-background-image: url('%s')", userHead));
        children.add(headLabel);
        // 名称区域
        nameLabel = new Label();
        nameLabel.setPrefSize(200, 40);
        nameLabel.setLayoutX(80);
        nameLabel.setLayoutY(15);
        nameLabel.setText(userNickName);
        nameLabel.getStyleClass().add("elementFriendUser_name");
        children.add(nameLabel);
    }

    public Pane pane() {
        return pane;
    }

}
