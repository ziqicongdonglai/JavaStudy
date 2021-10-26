package io.github.ziqicongdonglai.java.jfx.basic.animate;

import javafx.animation.Animation;
import javafx.animation.Transition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * @author ke_zhang
 * @create 2021-10-26 20:11
 * @description 打字动画
 */
public class TransitionSample extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Scene scene = new Scene(new Group());
        stage.setTitle("TransitionSample");
        stage.setWidth(500);
        stage.setHeight(400);

        VBox vBox = new VBox();
        vBox.setLayoutX(20);
        vBox.setLayoutY(20);

        final String content = "Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum";
        final Text text = new Text(10, 20, "");

        final Animation animation = new Transition() {
            {
                setCycleDuration(Duration.millis(2000));
            }
            @Override
            protected void interpolate(double frac) {
                final int length = content.length();
                final int n = Math.round(length * (float) frac);
                text.setText(content.substring(0, n));
            }
        };
        animation.play();

        vBox.getChildren().add(text);
        vBox.setSpacing(10);
        ((Group)scene.getRoot()).getChildren().add(vBox);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
