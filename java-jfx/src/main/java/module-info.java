module java.jfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.jfoenix;
    requires javafx.web;
    requires AnimateFX;


    opens io.github.ziqicongdonglai.java.jfx.ctrl to javafx.fxml;
    exports io.github.ziqicongdonglai.java.jfx;

    opens io.github.ziqicongdonglai.java.jfx.layout to javafx.fxml;
    exports io.github.ziqicongdonglai.java.jfx.layout;
}