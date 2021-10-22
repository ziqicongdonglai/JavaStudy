package io.github.ziqicongdonglai.java.basic.temp.inherit.relation;

/**
 * @author ke_zhang
 * @create 2021-10-21 9:30
 * @description
 */
public class DriverTest {
    public static void main(String[] args) {
        Driver driver = new Driver();
        driver.drive1();
        driver.drive2();
        driver.drive3(new Car());
    }
}