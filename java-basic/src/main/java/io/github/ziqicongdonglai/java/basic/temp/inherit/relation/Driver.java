package io.github.ziqicongdonglai.java.basic.temp.inherit.relation;

/**
 * @author ke_zhang
 * @create 2021-10-21 9:28
 * @description 依赖
 */
public class Driver {
    /**
     * 出现在一个类的成员方法的局部变量，发生依赖关系
     */
    public void drive1() {
        Car car = new Car();
        car.run();
    }

    /**
     * 使用静态方法，发生依赖关系
     */
    public void drive2() {
        Car.run();
    }

    /**
     * 出现在一个类的成员方法的形式参数，发生依赖关系
     * @param car
     */
    public void drive3(Car car) {
        car.run();
    }
}
