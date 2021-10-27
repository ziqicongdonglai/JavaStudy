package io.github.ziqicongdonglai.chat.ui.view;

import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * @author ke_zhang
 * @create 2021-10-22 20:14
 * @description
 * UI 父类定义，这是一个抽象类，提供了基础的初始化内容和接口，以及定义抽象方法
 */
public abstract class UIObject extends Stage {

    protected Parent root;
    private double xOffset;
    private double yOffset;

    public <T> T $(String id,Class<T> clazz) {
        return (T) root.lookup("#" + id);
    }

    /**
     * 窗体拖拽移动
     */
    public void move() {
        root.setOnMousePressed(event -> {
            xOffset = getX() - event.getScreenX();
            yOffset = getY() - event.getScreenY();
            root.setCursor(Cursor.CLOSED_HAND);
        });
        root.setOnMouseDragged(event -> {
            System.out.println("移动窗体");
            setX(event.getScreenX() + xOffset);
            setY(event.getScreenY() + yOffset);
        });
        root.setOnMouseReleased(event -> {
            root.setCursor(Cursor.DEFAULT);
        });
    }

    public double x() {
        return getX();
    }

    public double y() {
        return getY();
    }

    public double width() {
        return getWidth();
    }

    public double height() {
        return getHeight();
    }

    /**
     * 初始化页面：抽象方法
     */
    public abstract void initView();

    /**
     * 初始化事件定义：抽象方法
     */
    public abstract void initEventDefine();

    @SafeVarargs
    public final void clearViewListSelectedAll(ListView<Pane>... listViews) {
        for (ListView<Pane> listView : listViews) {
            listView.getSelectionModel().clearSelection();
        }
    }

}
