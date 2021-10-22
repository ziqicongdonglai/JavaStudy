package io.github.ziqicongdonglai.java.basic.temp.inherit.absclass;

/**
 * @author ke_zhang
 * @create 2021-10-21 16:05
 * @description
 */
public class TestApp {
    public static void main(String[] args) {
        // 多态
        TestAbstract ta = new Test01();
        ta.run();
        ta = new Test02();
        ta.run();
    }
}
