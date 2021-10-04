package io.github.ziqicongdonglai.java.jfx.layout;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

/**
 * @author ke_zhang
 * @create 2021-10-04 19:35
 * @description 文本流
 */
public class TextFlowExample extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Text text1 = new Text("Welcome to JavaFX~");
        text1.setFont(new Font(15));
        text1.setFill(Color.DARKSLATEBLUE);
        Text text2 = new Text("We provide free tutorials for readers in various technologies");
        text2.setFont(new Font(15));
        text2.setFill(Color.DARKGOLDENROD);
        Text text3 = new Text("\n Recently we started free video tutorials too ");
        text3.setFont(new Font(15));
        Text text4 = new Text("We believe in easy learning");
        text4.setFont(new Font(15));
        text4.setFill(Color.MEDIUMVIOLETRED);

        TextFlow textFlowPane = new TextFlow();
        textFlowPane.setTextAlignment(TextAlignment.JUSTIFY);
        textFlowPane.setPrefSize(600, 300);
        textFlowPane.setLineSpacing(5.0);

        textFlowPane.getChildren().addAll(text1, text2, text3, text4);
        Scene scene = new Scene(textFlowPane, 400, 300);
        stage.setTitle("TextFlow Pane Example");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
