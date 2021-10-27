package io.github.ziqicongdonglai.chat.ui.view.chat.group_bar_friend;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;

/**
 * @author ke_zhang
 * @create 2021-10-27 22:33
 * @description 群组列表
 */
public class ElementFriendGroupList {

    private final Pane pane;
    /**
     * 群组列表
     */
    private ListView<Pane> groupListView;

    public ElementFriendGroupList() {
        pane = new Pane();
        pane.setId("friendGroupList");
        pane.setPrefWidth(314);
        pane.setPrefHeight(0);
        pane.setLayoutX(-10);
        pane.getStyleClass().add("elementFriendGroupList");
        ObservableList<Node> children = pane.getChildren();

        groupListView = new ListView<>();
        groupListView.setId("groupListView");
        groupListView.setPrefWidth(314);
        groupListView.setPrefHeight(0);
        groupListView.setLayoutX(-10);
        groupListView.getStyleClass().add("elementFriendGroupList_listView");
        children.add(groupListView);
    }

    public Pane pane() {
        return pane;
    }
}
