package io.github.ziqicongdonglai.chat.ui.view.face;

import io.github.ziqicongdonglai.chat.ui.Main;
import io.github.ziqicongdonglai.chat.ui.param.AppConst;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.util.Objects;

/**
 * @author ke_zhang
 * @create 2021-10-25 21:25
 * @description 初始化表情
 */
public class FaceView {
    private final FaceInit faceInit;

    public FaceView(FaceInit faceInit) {
        this.faceInit = faceInit;
        initFaces();
    }

    /**
     * 初始化表情
     */
    private void initFaces() {
        Pane rootPane = faceInit.rootPane;
        //表情列表
        ObservableList<Node> children = rootPane.getChildren();
        //循环生成若干Label标签，并给其设置对应编号的图标，设置其userDate，添加样式，然后加入表情列表
        for (int i = 1; i < AppConst.FACE_COUNT; i++) {
            Label label = new Label();
            label.setUserData("f_" + i);
            Image image = new Image(Objects.requireNonNull(Main.class.getResourceAsStream("view/face/img/f_" + i + ".png")));
            ImageView imageView = new ImageView(image);
            imageView.setFitWidth(30);
            imageView.setFitHeight(30);
            label.setGraphic(imageView);
            label.getStyleClass().add("look");
            children.add(label);
            // 每个表情的鼠标点击事件
            label.setOnMouseClicked(event -> {
                Object userData = label.getUserData();
                System.out.println("选择了表情：" + userData);
            });
        }
    }
}
