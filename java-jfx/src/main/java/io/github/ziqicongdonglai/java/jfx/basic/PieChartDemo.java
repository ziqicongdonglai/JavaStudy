package io.github.ziqicongdonglai.java.jfx.basic;

import com.alibaba.fastjson.JSONObject;
import io.github.ziqicongdonglai.java.jfx.basic.util.SystemInfoUtil;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * @author ke_zhang
 * @create 2021-10-17 20:52
 * @description 饼图
 */
public class PieChartDemo extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        javafx.scene.chart.PieChart pieChart = new
                javafx.scene.chart.PieChart();
        pieChart.setData(getChartData());
        pieChart.setTitle("内存使用情况");
        pieChart.setLegendSide(Side.LEFT);
        pieChart.setClockwise(false);
        pieChart.setLabelsVisible(false);

        StackPane root = new StackPane();
        root.getChildren().add(pieChart);
        stage.setScene(new Scene(root, 800, 500));
        stage.show();
    }

    private ObservableList<javafx.scene.chart.PieChart.Data> getChartData() {
        ObservableList<javafx.scene.chart.PieChart.Data> answer =
                FXCollections.observableArrayList();
        JSONObject memInfo = SystemInfoUtil.getMemInfo();
        System.out.println(memInfo);
        String used = memInfo.getString("used").toString();
        String free = memInfo.getString("free").toString();
        answer.addAll(new javafx.scene.chart.PieChart.Data("Used", Double.parseDouble(used.substring(0, used.length() - 2))),
                new javafx.scene.chart.PieChart.Data("Free", Double.parseDouble(free.substring(0, free.length() - 2)))
                );
        return answer;
    }

    public static void main(String[] args) {
        launch();
    }
}
