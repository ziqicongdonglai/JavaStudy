package io.github.ziqicongdonglai.java.jfx.effect;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * @author ke_zhang
 * @create 2021-10-07 19:10
 * @description 颜色调整效果
 */
public class ColorAdjustEffectExample extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        // 自己找张图片
        Image image = new Image("https://cdn.jsdelivr.net/gh/ziqicongdonglai/blogpic/img/2021/avatar.jpg");
        ImageView imageView = new ImageView(image);
        imageView.setX(100);
        imageView.setY(70);
        imageView.setFitWidth(400);
        imageView.setFitHeight(200);

        // Setting the preserve ratio of the image view
        imageView.setPreserveRatio(true);
        // Instantiating the ColorAdjust class
        ColorAdjust colorAdjust = new ColorAdjust();
        // Setting the contrast value
        colorAdjust.setContrast(0.4);
        // Setting the hue value
        colorAdjust.setHue(-0.05);
        // Setting the brightness value
        colorAdjust.setBrightness(0.9);
        // Setting the saturation value
        colorAdjust.setSaturation(0.8);
        // Applying color adjust effect to the ImageView node
        imageView.setEffect(colorAdjust);

        // Creating a Group object
        Group root = new Group(imageView);

        // Creating a scene object
        Scene scene = new Scene(root, 400, 300);
        stage.setTitle("Color Adjust effect example");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
