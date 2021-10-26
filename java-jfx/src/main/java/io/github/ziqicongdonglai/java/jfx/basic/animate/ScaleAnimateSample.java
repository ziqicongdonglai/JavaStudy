package io.github.ziqicongdonglai.java.jfx.basic.animate;

import javafx.animation.ScaleTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * @author ke_zhang
 * @create 2021-10-26 19:52
 * @description JavaFX缩放动画
 */
public class ScaleAnimateSample extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Group root = new Group();
        Parent root1;
        Scene scene = new Scene(root, 600, 500);
        stage.setScene(scene);

        Rectangle rect1 = new Rectangle(100, 100, 100, 100);
        rect1.setArcHeight(50);
        rect1.setArcWidth(50);
        rect1.setFill(Color.VIOLET);

        Rectangle rect2 = new Rectangle(100, 100, 100, 100);
        rect2.setArcHeight(100);
        rect2.setArcWidth(100);
        rect2.setFill(Color.BLUE);

        ScaleTransition st1 = new ScaleTransition(Duration.millis(2000), rect1);
        st1.setByX(1.5f);
        st1.setByY(1.5f);
        st1.setAutoReverse(true);

        st1.play();
        root.getChildren().add(rect1);
        stage.show();

        ScaleTransition st2 = new ScaleTransition(Duration.millis(3000), rect2);
        st2.setByX(1.5f);
        st2.setByY(1.5f);
        st2.setAutoReverse(true);

        st2.play();
        root.getChildren().add(rect2);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
