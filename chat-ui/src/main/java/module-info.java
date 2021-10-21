module io.github.ziqicongdonglai.chatui {
    requires javafx.controls;
    requires javafx.fxml;

    opens io.github.ziqicongdonglai.chat.ui to javafx.fxml;
    exports io.github.ziqicongdonglai.chat.ui;
}