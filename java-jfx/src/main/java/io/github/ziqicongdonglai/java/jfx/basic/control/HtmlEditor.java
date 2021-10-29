package io.github.ziqicongdonglai.java.jfx.basic.control;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.TilePane;
import javafx.scene.web.HTMLEditor;
import javafx.stage.Stage;

/**
 * @author ke_zhang
 * @create 2021-10-29 23:22
 * @description
 */
public class HtmlEditor extends Application {
    @Override
    public void start(Stage stage) {
        // set title for the stage
        stage.setTitle("HTMLEditor");
        // HTML text
        String text = "<html><body><h1>学习之路</h1></body></html>";
        // create a tile pane
        TilePane tilepane = new TilePane();
        // HTML editor
        HTMLEditor htmleditor = new HTMLEditor();
        // set html text
        htmleditor.setHtmlText(text);
        // add html editor
        tilepane.getChildren().add(htmleditor);
        // create a scene
        Scene scene = new Scene(tilepane, 600, 500);
        // set the scene
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
