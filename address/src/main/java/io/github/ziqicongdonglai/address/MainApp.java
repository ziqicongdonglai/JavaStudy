package io.github.ziqicongdonglai.address;


import io.github.ziqicongdonglai.address.model.Person;
import io.github.ziqicongdonglai.address.view.PersonController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class MainApp extends Application {
    private final ObservableList<Person> personData = FXCollections.observableArrayList();
    public MainApp() {
        personData.add(new Person("王林", "软件2026", "男", "江苏南京",
                LocalDate.of(2000, 10, 24), new Image("https://cdn.jsdelivr.net/gh/ziqicongdonglai/blogpic/img/2021/tang1.jpg")));
        personData.add(new Person("彭海洋", "软件2026", "男", "江苏扬州",
                LocalDate.of(1999, 10, 24), new Image("https://cdn.jsdelivr.net/gh/ziqicongdonglai/blogpic/img/2021/tang2.jpg")));
        personData.add(new Person("郭佳", "软件2026", "女", "江苏苏州",
                LocalDate.of(2001, 11, 24), new Image("https://cdn.jsdelivr.net/gh/ziqicongdonglai/blogpic/img/2021/tang3.jpg")));
        personData.add(new Person("黄志伟", "软件2026", "男", "江苏泰州",
                LocalDate.of(2000, 10, 24), new Image("https://cdn.jsdelivr.net/gh/ziqicongdonglai/blogpic/img/2021/tang4.jpg")));
        personData.add(new Person("张珂", "软件2026", "女", "江苏徐州",
                LocalDate.of(2001, 9, 11), new Image("https://cdn.jsdelivr.net/gh/ziqicongdonglai/blogpic/img/2021/tang5.jpg")));
        personData.add(new Person("赵丹", "软件2036", "女", "江苏南通",
                LocalDate.of(2000, 10, 24), new Image("https://cdn.jsdelivr.net/gh/ziqicongdonglai/blogpic/img/2021/tang6.jpg")));
        personData.add(new Person("张建凤", "软件2036", "女", "江苏无锡",
                LocalDate.of(2001, 2, 24), new Image("https://cdn.jsdelivr.net/gh/ziqicongdonglai/blogpic/img/2021/tang7.jpg")));
        personData.add(new Person("杨阳", "软件1851", "男", "江苏南京",
                LocalDate.of(2000, 10, 23), new Image("https://cdn.jsdelivr.net/gh/ziqicongdonglai/blogpic/img/2021/tangzhi.jpg")));
        personData.add(new Person("尚宇驰", "软件1851", "女", "江苏徐州",
                LocalDate.of(2000, 10, 24), new Image("https://cdn.jsdelivr.net/gh/ziqicongdonglai/blogpic/img/2021/cartoon.jpg")));
        personData.add(new Person("陈蓉琪", "软件1851", "女", "江苏南京",
                LocalDate.of(2000, 3, 21), new Image("https://cdn.jsdelivr.net/gh/ziqicongdonglai/blogpic/img/2021/relation.jpg")));
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("view/person.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 980, 600);
        PersonController controller = fxmlLoader.getController();
        controller.setMainApp(this);
        stage.setTitle("Address");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * 得到Main定义的集合
     * @return
     */
    public ObservableList<Person> getPersonDate() {
        return personData;
    }

    public static void main(String[] args) {
        launch();
    }
}