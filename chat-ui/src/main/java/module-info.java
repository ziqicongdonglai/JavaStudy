module io.github.ziqicongdonglai.chatui {
    requires javafx.controls;
    requires javafx.fxml;

    opens io.github.ziqicongdonglai.chat.ui to javafx.fxml;
    exports io.github.ziqicongdonglai.chat.ui;

    opens io.github.ziqicongdonglai.chat.ui.view to javafx.fxml;
    exports io.github.ziqicongdonglai.chat.ui.view;

    opens io.github.ziqicongdonglai.chat.ui.view.login to javafx.fxml;
    exports io.github.ziqicongdonglai.chat.ui.view.login;

    //opens io.github.ziqicongdonglai.chat.ui.view.chat to javafx.fxml;
    //exports io.github.ziqicongdonglai.chat.ui.view.chat;
}