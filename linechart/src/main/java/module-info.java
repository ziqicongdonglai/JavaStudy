module io.github.ziqicongdonglai.linechart {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens io.github.ziqicongdonglai.linechart to javafx.fxml;
    exports io.github.ziqicongdonglai.linechart;
}