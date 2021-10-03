package io.github.ziqicongdonglai.java.jfx.config;

import io.github.ziqicongdonglai.java.jfx.GameApp;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author ke_zhang
 * @create 2021-09-30 17:40
 * @description 应用配置
 */
public class AppConfig {
    /**
     * 应用默认标题，如果app.properties有配置值，就被覆盖
     */
    public static String title = "JavaFx Application";
    /**
     * 应用默认图标
     */
    public static String icon = "icon/logo.png";
    /**
     * 窗口默认宽度
     */
    public static int stageWidth = 640;
    /**
     * 窗口默认高度
     */
    public static int stageHeight = 480;
    /**
     * 默认允许调整窗口尺寸
     */
    public static boolean stageResizable = true;

    public static void init() {
        try {
            Properties properties = new Properties();
            InputStream in = GameApp.class.getResourceAsStream("app.properties");
            properties.load(in);
            title = properties.getProperty("title");
            icon = properties.getProperty("icon");
            stageWidth = Integer.parseInt(properties.getProperty("stage.width"));
            stageHeight = Integer.parseInt(properties.getProperty("stage.height"));
            stageResizable = Boolean.parseBoolean(properties.getProperty("stage.resizable"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
