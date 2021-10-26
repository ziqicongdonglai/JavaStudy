package io.github.ziqicongdonglai.java.jfx.basic.animate;

import javafx.animation.FillTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * @author ke_zhang
 * @create 2021-10-26 20:03
 * @description 过渡动画举例
 */
public class FillTransitionSample extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("");
        Group root = new Group();
        Scene scene = new Scene(root, 500, 400, Color.WHITE);
        Group g = new Group();

        DropShadow ds = new DropShadow();
        ds.setOffsetY(3.0);
        ds.setColor(Color.color(0.4, 0.4, 0.4));

        Ellipse ellipse = new Ellipse();
        ellipse.setCenterX(250.0f);
        ellipse.setCenterY(150.0f);
        ellipse.setRadiusX(100.0f);
        ellipse.setRadiusY(50.0f);
        ellipse.setEffect(ds);

        FillTransition ft = new FillTransition(Duration.millis(4000), ellipse, Color.YELLOW, Color.ORANGE);
        ft.setAutoReverse(true);
        ft.play();

        g.getChildren().add(ellipse);

        root.getChildren().add(g);
        stage.setScene(scene);
        stage.show();
    }
}
