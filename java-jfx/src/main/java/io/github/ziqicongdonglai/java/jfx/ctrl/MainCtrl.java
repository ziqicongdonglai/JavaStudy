package io.github.ziqicongdonglai.java.jfx.ctrl;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author ke_zhang
 * @create 2021-09-30 17:40
 * @description 主界面控制器
 */
public class MainCtrl implements Initializable {
    public Pane rootPane;

    public Button btnAlert;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("initialize：" + location.getPath());
    }

    public void onBtnAlertClick(ActionEvent actionEvent) {
        Alert.AlertType alertAlertType;
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setContentText("你好");
        alert.show();
    }
}
