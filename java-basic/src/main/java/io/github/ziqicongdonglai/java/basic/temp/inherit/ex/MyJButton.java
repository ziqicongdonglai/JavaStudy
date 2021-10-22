package io.github.ziqicongdonglai.java.basic.temp.inherit.ex;

import javax.swing.*;
import java.awt.*;

/**
 * @author ke_zhang
 * @create 2021-10-21 10:57
 * @description
 */
public class MyJButton extends JButton {
    private String s;

    public MyJButton(String s) {
        super(s);
        setContentAreaFilled(false);
    }

    /**
     * 绘制按钮内容
     *
     * @param g
     */
    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(new Color(124, 185, 153));
        // 绘制一个圆角矩形getSize()为获取组件的大小
        g.fillRoundRect(0, 0, getSize().width - 1, getSize().height - 1, 15, 15);
        // 使用父类函数绘制一个焦点框
        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
        g.drawRoundRect(0, 0, getSize().width - 1, getSize().height - 1, 15, 15);
    }
}
