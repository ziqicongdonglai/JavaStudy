package io.github.ziqicongdonglai.java.jfx.basic;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


/**
 * @author ke_zhang
 * @create 2021-10-06 20:45
 * @description
 */
public class ColorExample extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        // Drawing a Circle
        Circle circle = new Circle();
        circle.setCenterX(300.0f);
        circle.setCenterY(100.0f);
        circle.setRadius(90.0f);

        // Setting color and stroke to the circle
        circle.setFill(Color.DARKRED);
        circle.setStrokeWidth(3);
        circle.setStroke(Color.DARKSLATEBLUE);

        // Drawing a text
        Text text = new Text("This is a colored circle");
        text.setFont(Font.font("Edwardian Script ITC", 50));
        text.setX(155);
        text.setY(50);
        text.setFill(Color.BEIGE);
        text.setStrokeWidth(2);
        text.setStroke(Color.DARKSLATEBLUE);

        // Creating a Group object
        Group root = new Group(circle, text);
        Scene scene = new Scene(root, 700, 400);
        stage.setTitle("Color Example");
        stage.setScene(scene);
        stage.show();
    }
}
