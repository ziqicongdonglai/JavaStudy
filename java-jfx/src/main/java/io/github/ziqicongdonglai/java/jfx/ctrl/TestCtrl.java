package io.github.ziqicongdonglai.java.jfx.ctrl;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;

/**
 * @author ke_zhang
 * @create 2021-10-02 13:38
 * @description
 */
public class TestCtrl {

    //public Button btn;
    public DatePicker datePicker;
    public JFXButton btn;

    public void onBtnClick(ActionEvent actionEvent) {
        datePicker.setVisible(!datePicker.isVisible());
    }
}
