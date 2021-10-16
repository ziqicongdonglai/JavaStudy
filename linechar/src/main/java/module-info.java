module io.github.ziqicongdonglai.linechar {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens io.github.ziqicongdonglai.linechar to javafx.fxml;
    exports io.github.ziqicongdonglai.linechar;
}