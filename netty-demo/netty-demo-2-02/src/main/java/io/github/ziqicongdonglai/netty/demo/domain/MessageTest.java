package io.github.ziqicongdonglai.netty.demo.domain;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.ByteBuffer;

/**
 * @author ke_zhang
 * @create 2021-11-02 23:32
 * @description MessageTest
 */
public class MessageTest {

    public static void main(String[] args) throws IOException {
        // 使用Java的序列化
        //String str = "hello,这是一条测试消息";
        //Message msg = new Message((byte) 0xAD, 35, str);
        //ByteArrayOutputStream out = new ByteArrayOutputStream();
        //ObjectOutputStream os = new ObjectOutputStream(out);
        //os.writeObject(msg);
        //os.flush();
        //byte[] b = out.toByteArray();
        //System.out.println("JDK序列化后的长度： " + b.length);
        //os.close();
        //out.close();

        // 使用二进制编码序列化
        //String str = "hello,这是一条测试消息";
        //Message msg = new Message((byte) 0xAD, 35, str);
        //
        //ByteBuffer buffer = ByteBuffer.allocate(1024);
        //byte[] bt = msg.getMsgBody().getBytes();
        //buffer.put(msg.getType());
        //buffer.putInt(msg.getLength());
        //buffer.put(bt);
        //buffer.flip();
        //
        //byte[] result = new byte[buffer.remaining()];
        //buffer.get(result);
        //System.out.println("使用二进制序列化的长度：" + result.length);

        // Java序列化 和 二进制序列化 的 耗时对比
        String str = "hello,这是一条测试消息";
        Message msg = new Message((byte) 0xAD, 35, str);
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            ObjectOutputStream os = new ObjectOutputStream(out);
            os.writeObject(msg);
            os.flush();
            byte[] b = out.toByteArray();
            os.close();
            out.close();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("JDK序列化100000次耗时：" + (endTime - startTime));

        long startTime1 = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            byte[] bt = msg.getMsgBody().getBytes();
            buffer.put(msg.getType());
            buffer.putInt(msg.getLength());
            buffer.put(bt);
            buffer.flip();
            byte[] result = new byte[buffer.remaining()];
            buffer.get(result);
        }
        long endTime1 = System.currentTimeMillis();
        System.out.println("使用二进制序列化100000次耗时：" + (endTime1 - startTime1));
    }
}
