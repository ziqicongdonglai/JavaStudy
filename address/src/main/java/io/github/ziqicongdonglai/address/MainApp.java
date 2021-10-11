package io.github.ziqicongdonglai.address;


import io.github.ziqicongdonglai.address.config.AppConfig;
import io.github.ziqicongdonglai.address.model.Person;
import io.github.ziqicongdonglai.address.view.BirthdayStatisticsController;
import io.github.ziqicongdonglai.address.view.PersonController;
import io.github.ziqicongdonglai.address.view.PersonEditController;
import io.github.ziqicongdonglai.address.view.RootController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Objects;

public class MainApp extends Application {
    private final ObservableList<Person> personData = FXCollections.observableArrayList();

    private Stage stage;

    private BorderPane rootLayout;

    public MainApp() {
        personData.add(new Person("王林", "软件2126", "男", "江苏南京",
                LocalDate.of(2000, 10, 24), new Image("https://cdn.jsdelivr.net/gh/ziqicongdonglai/blogpic/img/2021/tang1.jpg")));
        personData.add(new Person("彭海洋", "软件2126", "男", "江苏扬州",
                LocalDate.of(1999, 10, 24), new Image("https://cdn.jsdelivr.net/gh/ziqicongdonglai/blogpic/img/2021/tang2.jpg")));
        personData.add(new Person("郭佳", "软件2126", "女", "江苏苏州",
                LocalDate.of(2001, 11, 24), new Image("https://cdn.jsdelivr.net/gh/ziqicongdonglai/blogpic/img/2021/tang3.jpg")));
        personData.add(new Person("黄志伟", "软件2126", "男", "江苏泰州",
                LocalDate.of(2000, 10, 24), new Image("https://cdn.jsdelivr.net/gh/ziqicongdonglai/blogpic/img/2021/tang4.jpg")));
        personData.add(new Person("张珂", "软件2126", "女", "江苏徐州",
                LocalDate.of(2001, 9, 11), new Image("https://cdn.jsdelivr.net/gh/ziqicongdonglai/blogpic/img/2021/tang5.jpg")));
        personData.add(new Person("赵丹", "软件2136", "女", "江苏南通",
                LocalDate.of(2000, 10, 24), new Image("https://cdn.jsdelivr.net/gh/ziqicongdonglai/blogpic/img/2021/tang6.jpg")));
        personData.add(new Person("张建凤", "软件2136", "女", "江苏无锡",
                LocalDate.of(2001, 2, 24), new Image("https://cdn.jsdelivr.net/gh/ziqicongdonglai/blogpic/img/2021/tang7.jpg")));
        personData.add(new Person("杨阳", "软件1851", "男", "江苏南京",
                LocalDate.of(2000, 10, 23), new Image("https://cdn.jsdelivr.net/gh/ziqicongdonglai/blogpic/img/2021/tangzhi.jpg")));
        personData.add(new Person("尚宇驰", "软件1851", "女", "江苏徐州",
                LocalDate.of(2000, 10, 24), new Image("https://cdn.jsdelivr.net/gh/ziqicongdonglai/blogpic/img/2021/cartoon.jpg")));
        personData.add(new Person("陈蓉琪", "软件1851", "女", "江苏南京",
                LocalDate.of(2000, 3, 21), new Image("https://cdn.jsdelivr.net/gh/ziqicongdonglai/blogpic/img/2021/relation.jpg")));
    }

    public Stage getStage() {
        return this.stage;
    }

    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;
        stage.setTitle("AddressBook");
        initRootLayout();
        showPerson();
    }

    public void initRootLayout() {
        try {
            // 加载根布局
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(MainApp.class.getResource("view/root-layout.fxml"));
            rootLayout = fxmlLoader.load();
            RootController controller = fxmlLoader.getController();
            controller.setMainApp(this);
            // 创建以根布局为内容的场景
            Scene scene = new Scene(rootLayout, AppConfig.stageWidth, AppConfig.stageHeight);
            // 加载全局样式
            scene.getStylesheets().add(Objects.requireNonNull(MainApp.class.getResource("css/style.css")).toExternalForm());
            // 主窗体加入根布局
            stage.setScene(scene);
            stage.setResizable(AppConfig.stageResizable);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showPerson() {
        try {
            // 加载人员显示面板
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(MainApp.class.getResource("view/person.fxml"));
            AnchorPane personPane = fxmlLoader.load();
            // 根布局中间部分加入人员显示面板
            rootLayout.setCenter(personPane);
            // 获得PersonController控制器
            PersonController controller = fxmlLoader.getController();
            // 向控制器传参
            controller.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showEditPerson(Person person, String type) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(MainApp.class.getResource("view/person-edit.fxml"));
            AnchorPane editPersonPane = fxmlLoader.load();
            // 根布局中间部分加入人员编辑面板
            rootLayout.setCenter(editPersonPane);
            // 获得PersonEditController控制器
            PersonEditController controller = fxmlLoader.getController();
            // 向控制器传参
            controller.setArgs(person, type);
            controller.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void showBirthdayStatistics() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/birthday-statistics.fxml"));
            AnchorPane page = loader.load();
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Birthday Statistics");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(stage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            BirthdayStatisticsController controller = loader.getController();
            controller.setPersonData(personData);
            dialogStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 得到Main定义的集合
     * @return
     */
    public ObservableList<Person> getPersonData() {
        return personData;
    }

    public static void main(String[] args) {
        launch();
    }
}