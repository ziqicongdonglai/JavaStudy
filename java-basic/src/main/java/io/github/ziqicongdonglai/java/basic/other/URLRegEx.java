package io.github.ziqicongdonglai.java.basic.other;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ke_zhang
 * @create 2021-10-19 21:03
 * @description 获取用户指定URL的图片链接集合
 */
@Slf4j
public class URLRegEx {
    private static final String IMG_PATTERN = "<img.*?>";
    private static final String HTTPS_PATTERN = "\"https?(.*?)(\"|>|\\s+)";

    public static ArrayList<String> getImgList(String webUrl) {
        // 创建站点URL
        URL site = null;
        try {
            site = new URL(webUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        // 创建URL连接
        URLConnection connection = null;
        try {
            connection = site.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 由连接的字节输入流 -> 字节字符转换流 -> 扫描流
        Scanner in = null;
        try {
            in = new Scanner(new InputStreamReader(connection.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 用正则表达式("<img.*?>")截取<img src="">标签
        Pattern compile = Pattern.compile(IMG_PATTERN);
        // 匹配对象
        Matcher imgMatcher, httpsMatcher;
        // 定义图片链接
        String imgUrl;
        // 图片集合
        ArrayList imgList = new ArrayList<String>();
        int count = 0;
        while (in.hasNext()) {
            // 按行读取
            String line = in.nextLine();
            // 匹配正则，过滤出<img src="****"/>这样行
            imgMatcher = compile.matcher(line);
            // 当前行符合正则匹配
            if (imgMatcher.find()) {
                // 取出完整的img标签
                String imgElement = imgMatcher.group();
                //log.info(imgElement);
                // 这个正则用来从完整的img标签中提取到https地址
                httpsMatcher = Pattern.compile(HTTPS_PATTERN).matcher(imgElement);
                if (httpsMatcher.find()) {
                    // 提取出https，包含双引号
                    imgUrl = httpsMatcher.group();
                    // 取子串，去除引号
                    //log.info(imgUrl.substring(1, imgUrl.length() - 1));
                    imgUrl = imgUrl.substring(1, imgUrl.length() - 1);
                    imgList.add(imgUrl);
                    count++;
                }
            }
        }
        //log.info("img count of this site:" + count);
        in.close();
        return imgList;
    }

    public static void main(String[] args) {
        System.out.println("请输入要获取图片集合的网站链接：");
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        try {
            String url = bfr.readLine();
            ArrayList<String> imgList = URLRegEx.getImgList(url);
            System.out.println(imgList);
            //for (String imgUrl : imgList) {
            //    System.out.println(imgUrl);
            //}
            PrintStream printStream =
                    new PrintStream(new FileOutputStream("imgList.txt"));
            printStream.print(imgList);
            printStream.close();
            System.out.println("生成imgList.txt文件");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
