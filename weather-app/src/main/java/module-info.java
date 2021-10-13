module io.github.ziqicongdonglai.weather.app {
    requires javafx.controls;
    requires javafx.fxml;
    requires json.simple;

    opens io.github.ziqicongdonglai.weather to javafx.fxml;
    exports io.github.ziqicongdonglai.weather;
    exports io.github.ziqicongdonglai.weather.view;
    opens io.github.ziqicongdonglai.weather.view to javafx.fxml;

    exports io.github.ziqicongdonglai.weather.util;
}