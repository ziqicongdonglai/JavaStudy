package io.github.ziqicongdonglai.java.jfx.basic.trayicon;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author ke_zhang
 * @create 2021-10-25 23:34
 * @description
 * JavaFX系统托盘
 * 注意：要在module-info中添加：requires java.desktop;
 */
public class JavaFxTrayIconSample extends Application {
    /**
     * 托盘图标
     */
    private static final String ICON_IMAGE = "https://cdn.jsdelivr.net/gh/ziqicongdonglai/blogpic/img/2021/avatar.jpg";
    private Stage stage;

    /**
     * 创建线程池，这是正确方法，不要Timer，不要Executors，具体参数含义可以自行查阅
     */
    ScheduledThreadPoolExecutor scheduled = new ScheduledThreadPoolExecutor(2);

    //ExecutorService service = new ThreadPoolExecutor(
    //        1, 2,
    //        1000, TimeUnit.MILLISECONDS, new SynchronousQueue<>(),
    //        Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy()
    //);

    /**
     * 时间格式化
     */
    private final DateFormat timeFormat = SimpleDateFormat.getDateTimeInstance();

    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        // 指示javafx系统在最后一个应用程序窗口关闭时不隐式退出
        Platform.setImplicitExit(false);
        // 设置托盘图标（使用awt代码在swing线程上运行），this::addAppToTray是JDK8的方法引用
        javax.swing.SwingUtilities.invokeLater(this::addAppToTray);
        // stage透明的风格
        stage.initStyle(StageStyle.TRANSPARENT);
        StackPane layout = new StackPane(createContent());
        layout.setStyle("-fx-background-color: rgba(255, 255, 255, 0.5);");
        layout.setPrefSize(300, 200);
        // 当点击应用程序屏幕时，这个虚拟应用程序就会隐藏自己
        layout.setOnMouseClicked(event -> stage.hide());
        Scene scene = new Scene(layout);
        scene.setFill(Color.TRANSPARENT);
        stage.setScene(scene);
    }

    /**
     * 对于这个虚拟应用，（JavaFX场景图）内容是“hello，world”。
     * 真正的应用，可能会加载一个FXML
     *
     * @return 主窗口应用程序内容
     */
    private Node createContent() {
        Label hello = new Label("hello, world");
        hello.setStyle("-fx-font-size: 40px; -fx-text-fill: #238285;");
        Label instructions = new Label("(click to hide)");
        instructions.setStyle("-fx-font-size: 24px; -fx-text-fill: #a06cc9;-fx-cursor: hand;");
        VBox content = new VBox(10, hello, instructions);
        content.setAlignment(Pos.CENTER);
        return content;
    }

    /**
     * 为应用程序设置一个系统托盘图标
     */
    private void addAppToTray() {
        // 确保awt工具箱已初始化
        java.awt.Toolkit.getDefaultToolkit();
        // 应用程序需要系统托盘支持，如果没有支持就退出
        if (!java.awt.SystemTray.isSupported()) {
            System.out.println("不支持系统托盘，应用程序退出。");
            Platform.exit();
        }

        // 设置系统托盘图标
        java.awt.SystemTray tray = java.awt.SystemTray.getSystemTray();
        URL iconImage = null;
        try {
            iconImage = new URL(ICON_IMAGE);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        Image image = null;
        try {
            image = ImageIO.read(Objects.requireNonNull(iconImage));
        } catch (IOException e) {
            e.printStackTrace();
        }
        java.awt.TrayIcon trayIcon = new java.awt.TrayIcon(Objects.requireNonNull(image));

        // 如果用户双击托盘图标，则显示主应用程序窗体
        trayIcon.addActionListener(event -> Platform.runLater(this::showStage));

        // 如果用户选择了默认菜单项（包括应用程序名称），显示主应用程序窗体
        java.awt.MenuItem openItem = new java.awt.MenuItem("hello, world");
        openItem.addActionListener(event -> Platform.runLater(this::showStage));

        // 为应用程序字体设置粗体显示
        java.awt.Font defaultFont = java.awt.Font.decode(null);
        java.awt.Font boldFont = defaultFont.deriveFont(Font.BOLD);
        openItem.setFont(boldFont);

        // 要真正退出应用程序，必须转到系统托盘图标去点击Exit菜单
        java.awt.MenuItem exitItem = new java.awt.MenuItem("Exit");
        // 关闭JavaFX应用程序，停止线程任务，移除托盘图标
        exitItem.addActionListener(event -> {
            scheduled.shutdown();
            Platform.exit();
            tray.remove(trayIcon);
        });
        // 为应用程序设置弹出式菜单
        final java.awt.PopupMenu popup = new java.awt.PopupMenu();
        popup.add(openItem);
        popup.addSeparator();
        popup.add(exitItem);
        trayIcon.setPopupMenu(popup);

        // 执行定时任务，每3秒提示系统时间
        scheduled.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                javax.swing.SwingUtilities.invokeLater(() ->
                        trayIcon.displayMessage(
                                "hello",
                                "The time is now " + timeFormat.format(new Date()),
                                TrayIcon.MessageType.INFO
                        ));
            }
        }, 0, 3000, TimeUnit.MILLISECONDS);
            // 将应用程序托盘图标添加到系统托盘
        try {
            tray.add(trayIcon);
        } catch (AWTException e) {
            System.out.println("Unable to init system tray");
            e.printStackTrace();
        }
    }

    /**
     * 让应用程序置顶
     */
    private void showStage() {
        if (stage != null) {
            stage.show();
            stage.toFront();
        }
    }

    public static void main(String[] args) throws IOException, java.awt.AWTException {
        launch(args);
    }
}
