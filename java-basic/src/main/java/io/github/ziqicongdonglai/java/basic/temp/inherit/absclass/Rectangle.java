package io.github.ziqicongdonglai.java.basic.temp.inherit.absclass;

/**
 * @author ke_zhang
 * @create 2021-10-21 16:25
 * @description
 */
public class Rectangle extends Shape{
    public Rectangle() {

    }

    public Rectangle (double width, double height) {
        super(width, height);
    }
    @Override
    public double getArea() {
        return this.x * this.y;
    }
}
