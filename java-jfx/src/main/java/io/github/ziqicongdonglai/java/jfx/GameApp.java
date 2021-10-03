package io.github.ziqicongdonglai.java.jfx;

import io.github.ziqicongdonglai.java.jfx.config.AppConfig;
import io.github.ziqicongdonglai.java.jfx.ctrl.GameCtrl;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.Objects;

/**
 * @author ke_zhang
 * @create 2021-09-30 17:41
 * @description 主类
 */
public class GameApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(GameApp.class.getResource("fxml/game.fxml")));
        // 加载并创建主场景
        Parent root = loader.load();
        // 加载外部样式，这样窗口中所有组件可用，绑定在fxml组件上的样式只能本组件可用
        root.getStylesheets().add(Objects.requireNonNull(GameApp.class.getResource("css/game.css")).toExternalForm());

        GameCtrl controller = loader.getController();
        controller.setStage(stage);
        Scene scene = new Scene(root, AppConfig.stageWidth, AppConfig.stageHeight);
        // 设置窗口信息
        stage.setScene(scene);
        stage.setResizable(AppConfig.stageResizable);
        stage.getIcons().add(new Image(Objects.requireNonNull(GameApp.class.getResourceAsStream(AppConfig.icon))));

        stage.initStyle(StageStyle.TRANSPARENT);
        stage.show();
    }

    public static void main(String[] args) {
        AppConfig.init();
        launch();
    }
}
