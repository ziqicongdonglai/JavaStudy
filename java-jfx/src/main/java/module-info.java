module java.jfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens io.github.ziqicongdonglai.java.jfx.ctrl to javafx.fxml;
    exports io.github.ziqicongdonglai.java.jfx;
}