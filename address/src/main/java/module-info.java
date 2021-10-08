module io.github.ziqicongdonglai.address {
    requires javafx.controls;
    requires javafx.fxml;

    opens io.github.ziqicongdonglai.address to javafx.fxml;
    exports io.github.ziqicongdonglai.address;
    exports io.github.ziqicongdonglai.address.view;
    opens io.github.ziqicongdonglai.address.view to javafx.fxml;
}