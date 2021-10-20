module io.github.ziqicongdonglai.notepad {
    requires javafx.controls;
    requires javafx.fxml;

    opens io.github.ziqicongdonglai.notepad to javafx.fxml;
    exports io.github.ziqicongdonglai.notepad;
    exports io.github.ziqicongdonglai.notepad.view;
    opens io.github.ziqicongdonglai.notepad.view to javafx.fxml;
}