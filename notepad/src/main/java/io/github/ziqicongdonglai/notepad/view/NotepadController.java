package io.github.ziqicongdonglai.notepad.view;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class NotepadController {

    @FXML
    private TextArea textArea;

    private String filePath;


    @FXML
    void openFile(ActionEvent actionEvent) {
        Stage stage = (Stage) textArea.getScene().getWindow();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose File");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("TXT Files", "*.txt"));
        File file = fileChooser.showOpenDialog(stage);
        if (file != null) {
            System.out.println("加载文件:" + file.getAbsolutePath());
            if (file.exists()) {
                try {
                    //读取数据  放进多行文本框
                    FileInputStream in = new FileInputStream(file);
                    byte[] bs = new byte[(int) file.length()];
                    in.read(bs);
                    //将内容设置到多行文本框
                    textArea.setText(new String(bs));
                    in.close();
                    //将文件路径保存 到成员变量 path 中
                    filePath = file.getPath();
                    //更改窗口标题
                    stage.setTitle(file.getName() + "-JavaFX 记事本");
                } catch (Exception ignored) {
                }
            }
        }
    }

    @FXML
    void saveFile(ActionEvent actionEvent) {
        try {
            if (null != filePath) {
                //创建输出流
                FileOutputStream out = new FileOutputStream(filePath);
                //将文本域内容写出
                out.write(textArea.getText().getBytes());
                out.close();
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.titleProperty().set("信息");
                alert.headerTextProperty().set("请先加载文件！");
                alert.showAndWait();
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    @FXML
    void close(ActionEvent actionEvent) {
        Platform.exit();
    }

    @FXML
    void about(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.titleProperty().set("信息");
        alert.headerTextProperty().set("学习之路");
        alert.showAndWait();
    }
}