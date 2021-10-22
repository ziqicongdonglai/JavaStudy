package io.github.ziqicongdonglai.java.basic.temp.inherit.ex;

import javax.swing.*;

/**
 * @author ke_zhang
 * @create 2021-10-21 10:49
 * @description
 */
public class MyJFrame extends JFrame {
    public MyJFrame() {
        super();
    }

    @Override
    protected void frameInit() {
        this.setTitle("自定义JFrame");
    }

}
