package io.github.ziqicongdonglai.chat.ui.view.chat.group_bar_friend;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

/**
 * @author ke_zhang
 * @create 2021-10-27 22:33
 * @description 好友 | 添加好友
 */
public class ElementFriendNew {

    private final Pane pane;

    private Label head;
    private Label name;

    /**
     * 用户面板
     */
    private final Pane friendPane;
    /**
     * 用户搜索
     */
    private final TextField friendSearch;
    /**
     * 用户列表[待添加好友用户]
     */
    private final ListView<Pane> friendListView;

    public ElementFriendNew() {
        pane = new Pane();
        pane.setId("elementFriendNew");
        pane.setPrefSize(270, 70);
        pane.getStyleClass().add("elementFriendNew");
        ObservableList<Node> children = pane.getChildren();

        // 头像区域
        head = new Label();
        head.setPrefSize(50, 50);
        head.setLayoutX(15);
        head.setLayoutY(10);
        head.getStyleClass().add("elementFriendNew_head");
        children.add(head);

        // 名称区域
        name = new Label();
        name.setPrefSize(200, 40);
        name.setLayoutX(80);
        name.setLayoutY(15);
        name.setText("新的朋友");
        name.getStyleClass().add("elementFriendNew_name");
        children.add(name);

        // 初始化框体区域[搜索好友框、展现框]
        friendPane = new Pane();
        friendPane.setPrefSize(850, 560);
        friendPane.getStyleClass().add("friendNewPane");
        ObservableList<Node> friendLuckPaneChildren = friendPane.getChildren();

        friendSearch = new TextField();
        friendSearch.setPrefSize(600, 50);
        friendSearch.setLayoutX(125);
        friendSearch.setLayoutY(25);
        friendSearch.setPromptText("搜一搜");
        friendSearch.setPadding(new Insets(10));
        friendSearch.getStyleClass().add("friendNewSearch");
        friendLuckPaneChildren.add(friendSearch);

        // 用户列表框[初始化，未装载]
        friendListView = new ListView<>();
        friendListView.setId("friendLuckListView");
        friendListView.setPrefSize(850, 460);
        friendListView.setLayoutY(75);
        friendListView.getStyleClass().add("friendListView");
        friendLuckPaneChildren.add(friendListView);

    }

    public Pane pane() {
        return pane;
    }

    public Pane friendPane() {
        return friendPane;
    }

    public TextField friendSearch() {
        return friendSearch;
    }

    public ListView<Pane> friendListView() {
        return friendListView;
    }
}
