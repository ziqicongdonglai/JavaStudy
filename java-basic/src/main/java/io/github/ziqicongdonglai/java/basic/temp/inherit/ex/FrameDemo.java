package io.github.ziqicongdonglai.java.basic.temp.inherit.ex;

import java.awt.*;

/**
 * @author ke_zhang
 * @create 2021-10-21 10:43
 * @description
 */
public class FrameDemo {
    public static void main(String[] args) {
        MyJFrame f = new MyJFrame();
        f.setSize(500, 300);
        f.setLocation(300, 200);
        MyJButton jButton1 = new MyJButton("按钮1");
        MyJButton jButton2 = new MyJButton("按钮2");
        f.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        f.add(jButton1);
        f.add(jButton2);
        f.setVisible(true);
    }
}
