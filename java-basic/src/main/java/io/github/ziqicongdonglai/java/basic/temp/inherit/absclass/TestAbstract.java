package io.github.ziqicongdonglai.java.basic.temp.inherit.absclass;

/**
 * @author ke_zhang
 * @create 2021-10-21 15:53
 * @description 将设计和实现分离（官方）
 */
public abstract class TestAbstract {
    public void test () {
        System.out.println("抽象类中的普通方法");
    }

    /**
     * 抽象方法
     */
    public abstract void run();
}
