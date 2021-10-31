package io.github.ziqicongdonglai.netty.demo.bio.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @author ke_zhang
 * @create 2021-10-30 23:28
 * @description Bio服务端
 */
public class BioServer extends Thread {

    private ServerSocket serverSocket = null;

    public static void main(String[] args) {
        BioServer bioServer = new BioServer();
        bioServer.start();
    }

    @Override
    public void run() {
        try {
            serverSocket = new ServerSocket();
            serverSocket.bind(new InetSocketAddress(7397));
            System.out.println("BIO服务端启动成功！");
            while (true) {
                Socket socket = serverSocket.accept();
                BioServerHandler handler = new BioServerHandler(socket, StandardCharsets.UTF_8);
                handler.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
