package io.github.ziqicongdonglai.java.basic.temp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author ke_zhang
 * @create 2021-10-14 10:30
 * @description
 */
public class TestComputer {
    public static void main(String[] args) throws IOException {
        Computer pc = new Computer(
                "HUAWEI MateBook D", "grey",
                "Intel", "16G",
                "512G", 6666.66, "开机");
        // 从键盘通过输入流接收数据
        InputStream in;
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        System.out.println("请输入1-9进行查询操作，-1为退出");
        try {
            String choice = br.readLine();
                switch (choice) {
                    case "1": {
                        System.out.println(pc.getBrand());
                        break;
                    }
                    case "2": {
                        System.out.println(pc.getPrice());
                        break;
                    }
                    case "3": {
                        pc.start();
                        break;
                    }
                    case "4": {
                        pc.off();
                        break;
                    }
                    case "-1": {
                        break;
                    }
                    default: {
                        System.out.println("请输入正确的操作");
                        break;
                    }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
