package io.github.ziqicongdonglai.weather.util;


import io.github.ziqicongdonglai.weather.config.AppConstant;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

/**
 * @author ke_zhang
 * @create 2021-10-13 22:27
 * @description Api连接，发起请求，解析成JSON数组或JSON对象
 */
public class ApiConnector {
    private final String urlString;
    public ApiConnector(String urlString) {
        this.urlString = urlString;
    }
    /**
     * 根据查询参数指定的url请求，返回JSON数组
     *
     * @param query 查询参数
     * @return JSON数组
     */
    public JSONArray getJsonArray(String query) {
        try {
            URL url = new URL(urlString + query);
            //向指定url发起get请求
            HttpURLConnection conn = (HttpURLConnection)
                    url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            int responseCode = conn.getResponseCode();
            //检查连接是否正常
            if (responseCode != AppConstant.SUCCESS) {
                throw new RuntimeException("HttpResponseCode: " +
                        responseCode);
            } else {
                //按⾏读取结果
                StringBuilder informationString = new StringBuilder();
                Scanner scanner = new Scanner(url.openStream());
                while (scanner.hasNext()) {
                    informationString.append(scanner.nextLine());
                }
                scanner.close();
                JSONParser parse = new JSONParser();
                //返回JSONArray
                return (JSONArray)
                        parse.parse(String.valueOf(informationString));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * 根据查询参数指定的url请求，返回JSON对象
     *
     * @param query 查询参数
     * @return JSON对象
     */
    public JSONObject getJsonObject(String query) {
        try {
            URL url = new URL(urlString + query);
            HttpURLConnection conn = (HttpURLConnection)
                    url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            int responseCode = conn.getResponseCode();
            if (responseCode != AppConstant.SUCCESS) {
                throw new RuntimeException("HttpResponseCode: " +
                        responseCode);
            } else {
                StringBuilder informationString = new StringBuilder();
                Scanner scanner = new Scanner(url.openStream());
                while (scanner.hasNext()) {
                    informationString.append(scanner.nextLine());
                }
                scanner.close();
                JSONParser parse = new JSONParser();
                return (JSONObject)
                        parse.parse(String.valueOf(informationString));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
