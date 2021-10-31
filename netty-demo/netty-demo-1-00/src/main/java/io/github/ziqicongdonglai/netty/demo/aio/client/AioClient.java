package io.github.ziqicongdonglai.netty.demo.aio.client;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.Future;

/**
 * @author ke_zhang
 * @create 2021-10-30 23:25
 * @description 客户端
 */
public class AioClient {
    public static void main(String[] args)throws Exception {
        AsynchronousSocketChannel socketChannel = AsynchronousSocketChannel.open();
        //改成你的IP地址
        Future<Void> future = socketChannel.connect(new InetSocketAddress("10.30.242.134", 7397));
        System.out.println("AIO客户端启动成功！");
        future.get();
        socketChannel.read(ByteBuffer.allocate(1024), null, new AioClientHandler(socketChannel, StandardCharsets.UTF_8));
        Thread.sleep(30000);
    }
}
