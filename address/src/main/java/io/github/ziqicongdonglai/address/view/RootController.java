package io.github.ziqicongdonglai.address.view;

import io.github.ziqicongdonglai.address.MainApp;
import javafx.fxml.FXML;

/**
 * @author ke_zhang
 * @create 2021-10-11 20:18
 * @description
 */
public class RootController {

    private MainApp mainApp;

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    private void handleShowBirthdayStatistics() {
        mainApp.showBirthdayStatistics();
    }
}
