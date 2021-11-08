package io.github.ziqicongdonglai.chat.ui.view.chat.group_bar_chat;

import io.github.ziqicongdonglai.chat.ui.Main;
import io.github.ziqicongdonglai.chat.ui.util.AutoSizeTool;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.util.Objects;

/**
 * @author ke_zhang
 * @create 2021-10-24 19:18
 * @description  聊天框对话信息
 */
public class ElementInfoBox {

    private Pane pane;

    /**
     * 头像
     */
    private Pane head;
    /**
     * 昵称区
     */
    private Label nickName;
    /**
     * 内容箭头
     */
    private Label infoContentArrow;
    /**
     * 内容
     */
    private TextArea infoContent;

    /**
     * 左侧消息列表
     *
     * @param userNickName 昵称
     * @param userHead     头像
     * @param msg          消息
     * @return Pane
     */
    public Pane left(String userNickName, String userHead, String msg, Integer msgType) {

        double autoHeight = AutoSizeTool.getHeight(msg);
        double autoWidth = AutoSizeTool.getWidth(msg);

        pane = new Pane();
        pane.setPrefSize(500, 50 + autoHeight);
        pane.getStyleClass().add("infoBoxElement");
        ObservableList<Node> children = pane.getChildren();

        // 头像
        head = new Pane();
        head.setPrefSize(50, 50);
        head.setLayoutX(15);
        head.setLayoutY(15);
        head.getStyleClass().add("box_head");
        head.setStyle(String.format("-fx-background-image: url('%s')", userHead));
        children.add(head);

        // 昵称
        nickName = new Label();
        nickName.setPrefSize(450, 20);
        nickName.setLayoutX(75);
        nickName.setLayoutY(5);
        nickName.setText(userNickName);
        nickName.getStyleClass().add("box_nikeName");
        children.add(nickName);

        // 箭头
        infoContentArrow = new Label();
        infoContentArrow.setPrefSize(5, 20);
        infoContentArrow.setLayoutX(75);
        infoContentArrow.setLayoutY(30);
        infoContentArrow.getStyleClass().add("box_infoContent_arrow");
        children.add(infoContentArrow);

        switch (msgType) {
            case 0:
                // 内容
                infoContent = new TextArea();
                infoContent.setPrefWidth(autoWidth);
                infoContent.setPrefHeight(autoHeight);
                infoContent.setLayoutX(80);
                infoContent.setLayoutY(30);
                infoContent.setWrapText(true);
                infoContent.setEditable(false);
                infoContent.setText(msg);
                infoContent.getStyleClass().add("box_infoContent_left");
                children.add(infoContent);
                break;
            case 1:
                Label infoContentFace = new Label();
                infoContentFace.setPrefWidth(60);
                infoContentFace.setPrefHeight(40);
                infoContentFace.setLayoutX(80);
                infoContentFace.setLayoutY(30);
                Image image = new Image(Objects.requireNonNull(Main.class.getResourceAsStream("view/face/img/" + msg + ".png")));
                ImageView imageView = new ImageView(image);
                imageView.setFitWidth(30);
                imageView.setFitHeight(30);
                infoContentFace.setGraphic(imageView);
                //infoContentFace.setStyle(String.format("-fx-background-image: url('%s');-fx-background-position: center center;-fx-background-repeat: no-repeat;-fx-background-color: #ffffff;-fx-border-width: 0 1px 1px 0;-fx-border-radius: 2px;-fx-background-radius: 2px;", msg));
                children.add(infoContentFace);
                break;
            default:
                break;
        }

        return pane;
    }

    public Pane right(String userNickName, String userHead, String msg, int msgType) {

        double autoHeight = AutoSizeTool.getHeight(msg);
        double autoWidth = AutoSizeTool.getWidth(msg);

        pane = new Pane();
        pane.setPrefSize(500, 50 + autoHeight);
        pane.setLayoutX(853);
        pane.setLayoutY(0);
        pane.getStyleClass().add("infoBoxElement");
        ObservableList<Node> children = pane.getChildren();

        // 头像
        head = new Pane();
        head.setPrefSize(50, 50);
        head.setLayoutX(770);
        head.setLayoutY(15);
        head.getStyleClass().add("box_head");
        head.setStyle(String.format("-fx-background-image: url('%s')", userHead));
        children.add(head);

        // 箭头
        infoContentArrow = new Label();
        infoContentArrow.setPrefSize(5, 20);
        infoContentArrow.setLayoutX(755);
        infoContentArrow.setLayoutY(15);
        infoContentArrow.getStyleClass().add("box_infoContent_arrow");
        children.add(infoContentArrow);

        switch (msgType) {
            case 0:
                // 内容：文字
                infoContent = new TextArea();
                infoContent.setPrefWidth(autoWidth);
                infoContent.setPrefHeight(autoHeight);
                infoContent.setLayoutX(755 - autoWidth);
                infoContent.setLayoutY(15);
                infoContent.setWrapText(true);
                infoContent.setEditable(false);
                infoContent.setText(msg);
                infoContent.getStyleClass().add("box_infoContent_right");
                children.add(infoContent);
                break;
            case 1:
                Label infoContentFace = new Label();
                infoContentFace.setPrefWidth(60);
                infoContentFace.setPrefHeight(40);
                infoContentFace.setLayoutX(755 - 60);
                infoContentFace.setLayoutY(15);
                Image image = new Image(Objects.requireNonNull(Main.class.getResourceAsStream("view/face/img/" + msg + ".png")));
                ImageView imageView = new ImageView(image);
                imageView.setFitWidth(30);
                imageView.setFitHeight(30);
                infoContentFace.setGraphic(imageView);
                //infoContentFace.setStyle(String.format("-fx-background-image: url('%s');-fx-background-position: center center;-fx-background-repeat: no-repeat;-fx-background-color: #9eea6a;-fx-border-width: 0 1px 1px 0;-fx-border-radius: 2px;-fx-background-radius: 2px;", msg));
                children.add(infoContentFace);
                break;
            default:
                break;
        }
        return pane;
    }

}
