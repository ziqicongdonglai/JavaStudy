package io.github.ziqicongdonglai.netty.demo.bio.client;

import java.io.IOException;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @author ke_zhang
 * @create 2021-10-30 23:27
 * @description bio客户端
 */
public class BioClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("10.30.242.134", 7397);
            System.out.println("BIO客户端启动成功！");
            BioClientHandler bioClientHandler = new BioClientHandler(socket, StandardCharsets.UTF_8);
            bioClientHandler.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
