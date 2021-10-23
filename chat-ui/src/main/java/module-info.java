module io.github.ziqicongdonglai.chatui {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.ikonli.materialdesign;

    opens io.github.ziqicongdonglai.chat.ui to javafx.fxml;
    exports io.github.ziqicongdonglai.chat.ui;

    opens io.github.ziqicongdonglai.chat.ui.view to javafx.fxml;
    exports io.github.ziqicongdonglai.chat.ui.view;

    opens io.github.ziqicongdonglai.chat.ui.view.login to javafx.fxml;
    exports io.github.ziqicongdonglai.chat.ui.view.login;
}