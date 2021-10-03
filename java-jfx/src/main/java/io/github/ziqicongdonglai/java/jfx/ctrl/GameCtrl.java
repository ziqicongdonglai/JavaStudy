package io.github.ziqicongdonglai.java.jfx.ctrl;

import animatefx.animation.FadeIn;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author ke_zhang
 * @create 2021-10-03 23:12
 * @description 主界面控制器
 */
public class GameCtrl implements Initializable {
    public StackPane root;
    public VBox firstPane;
    public GridPane secondPane;
    
    private Stage stage;
    
    private double xOffset = 0;
    private double y0ffset = 0;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }

    /**
     * 接收主方法传递的stage对象
     * 
     * @param stage
     */
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    /**
     * 顶部标题栏鼠标按下事件，获得当前鼠标位置
     * 
     * @param event
     */
    public void onPressed(MouseEvent event) {
        xOffset = event.getScreenX();
        y0ffset = event.getScreenX();
    }

    /**
     * 顶部标题栏拖拽事件，根据鼠标位置和偏移重置窗体位置
     * 
     * @param event
     */
    public void onDragged(MouseEvent event) {
        stage.setX(event.getScreenX() - xOffset);
        if (event.getScreenY() - y0ffset < 0) {
            stage.setY(0);
        } else {
            stage.setY(event.getScreenY() - y0ffset);
        }
    }

    /**
     * 最小化窗体
     * 
     * @param event
     */
    public void onMinClicked(MouseEvent event) {
        stage.setIconified(true);
    }

    /**
     * 关闭窗体
     * 
     * @param event
     */
    public void onCloseClicked(MouseEvent event) {
        stage.close();
    }


    /**
     * 显示右侧第一个面板
     * 
     * @param actionEvent
     */
    public void showFirstPane(ActionEvent actionEvent) {
        new FadeIn(firstPane).play();
        firstPane.setVisible(true);
        secondPane.setVisible(false);
    }

    /**
     * 显示右侧第二个面板
     * 
     * @param actionEvent
     */
    public void showSecondPane(ActionEvent actionEvent) {
        new FadeIn(secondPane).play();
        secondPane.setVisible(true);
        firstPane.setVisible(false);
    }
}
