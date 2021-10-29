package io.github.ziqicongdonglai.java.jfx.basic.control;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * @author ke_zhang
 * @create 2021-10-29 22:08
 * @description
 */
public class ProgressbarApp extends Application {
    private Task createWorker(final int numFiles) {
        return new Task() {
            @Override
            protected Object call() throws Exception {
                for (int i = 0; i < numFiles; i++) {
                    long elapsedTime = System.currentTimeMillis();
                    Thread.sleep(1 * 1000);
                    elapsedTime = System.currentTimeMillis() - elapsedTime;
                    String status = elapsedTime + " milliseconds";
                    updateMessage(status);
                    updateProgress(i + 1, numFiles);
                }
                return true;
            }
        };
    }

    private Task copyWorker;
    private int numFiles = 20;

    @Override
    public void start(Stage primaryStage) {
        final Label label = new Label("Progress:");
        final ProgressBar progressBar = new ProgressBar(0);
        final ProgressIndicator progressIndicator = new ProgressIndicator(0);
        final Button startButton = new Button("Start");
        final Button cancelButton = new Button("Cancel");
        final TextArea textArea = new TextArea();
        startButton.setOnAction((ActionEvent event) -> {
            startButton.setDisable(true);
            progressBar.setProgress(0);
            progressIndicator.setProgress(0);
            textArea.setText("");
            cancelButton.setDisable(false);
            copyWorker = createWorker(numFiles);
            progressBar.progressProperty().unbind();
            progressBar.progressProperty().bind(copyWorker.progressProperty());
            progressIndicator.progressProperty().unbind();
            progressIndicator.progressProperty().bind(copyWorker.progressProperty());
            copyWorker.messageProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
                textArea.appendText(newValue + "\n");
            });
            new Thread(copyWorker).start();
        });
        cancelButton.setOnAction((ActionEvent event) -> {
            startButton.setDisable(false);
            cancelButton.setDisable(true);
            copyWorker.cancel(true);
            progressBar.progressProperty().unbind();
            progressBar.setProgress(0);
            progressIndicator.progressProperty().unbind();
            progressIndicator.setProgress(0);
            textArea.appendText("File transfer was cancelled.");
        });
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 500, 250, javafx.scene.paint.Color.WHITE);
        FlowPane topPane = new FlowPane(5, 5);
        topPane.setPadding(new Insets(5));
        topPane.setAlignment(Pos.CENTER);
        topPane.getChildren().addAll(label, progressBar, progressIndicator);
        GridPane middlePane = new GridPane();
        middlePane.setPadding(new Insets(5));
        middlePane.setHgap(20);
        middlePane.setVgap(20);
        ColumnConstraints column1 = new ColumnConstraints(300, 400, Double.MAX_VALUE);
        middlePane.getColumnConstraints().addAll(column1);
        middlePane.setAlignment(Pos.CENTER);
        middlePane.add(textArea, 0, 0);
        FlowPane bottomPane = new FlowPane(5, 5);
        bottomPane.setPadding(new Insets(5));
        bottomPane.setAlignment(Pos.CENTER);
        bottomPane.getChildren().addAll(startButton, cancelButton);
        root.setTop(topPane);
        root.setCenter(middlePane);
        root.setBottom(bottomPane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
