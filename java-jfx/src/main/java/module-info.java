module java.jfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.jfoenix;
    requires javafx.web;
    requires AnimateFX;
    requires com.github.oshi;
    requires fastjson;
    requires java.desktop;


    opens io.github.ziqicongdonglai.java.jfx.ctrl to javafx.fxml;
    exports io.github.ziqicongdonglai.java.jfx;

    opens io.github.ziqicongdonglai.java.jfx.layout to javafx.fxml;
    exports io.github.ziqicongdonglai.java.jfx.layout;

    opens io.github.ziqicongdonglai.java.jfx.basic to javafx.fxml;
    exports io.github.ziqicongdonglai.java.jfx.basic;

    opens io.github.ziqicongdonglai.java.jfx.effect to javafx.fxml;
    exports io.github.ziqicongdonglai.java.jfx.effect;

    opens io.github.ziqicongdonglai.java.jfx.basic.trayicon to javafx.fxml;
    exports io.github.ziqicongdonglai.java.jfx.basic.trayicon;
}