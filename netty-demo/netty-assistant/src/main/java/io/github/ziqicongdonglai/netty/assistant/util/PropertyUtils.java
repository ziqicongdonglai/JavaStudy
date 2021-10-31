package io.github.ziqicongdonglai.netty.assistant.util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author ke_zhang
 * @create 2021-10-31 19:13
 * @description
 */
public class PropertyUtils {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
    }

    public static final String PATH = "a.properties";

    public static String read(String key) {
        String value = "";
        Properties prop = new Properties();
        try{
            //读取属性文件a.properties
            InputStream in = new BufferedInputStream (new FileInputStream(PATH));
            //加载属性列表
            prop.load(in);
            value = prop.getProperty(key);
            in.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return value;
    }
    public static void write(String key,String value) {
        Properties prop = new Properties();
        try{
            ///保存属性到b.properties文件 true表示追加打开
            FileOutputStream oFile = new FileOutputStream(PATH, true);
            prop.setProperty(key,value);
            prop.store(oFile, "The New properties file");
            oFile.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    public static void Read() {
        Properties prop = new Properties();
        try{
            //读取属性文件a.properties
            InputStream in = new BufferedInputStream(new FileInputStream("a.properties"));
            ///加载属性列表
            prop.load(in);
            for (String key : prop.stringPropertyNames()) {
                System.out.println(key + ":" + prop.getProperty(key));
            }
            in.close();
            ///保存属性到b.properties文件
            FileOutputStream oFile = new FileOutputStream("b.properties", true);
            prop.setProperty("phone", "10086");
            prop.store(oFile, "The New properties file");
            oFile.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

}
