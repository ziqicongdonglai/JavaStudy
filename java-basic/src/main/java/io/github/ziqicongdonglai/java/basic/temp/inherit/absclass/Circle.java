package io.github.ziqicongdonglai.java.basic.temp.inherit.absclass;

/**
 * @author ke_zhang
 * @create 2021-10-21 16:20
 * @description
 */
public class Circle extends Shape{
    public Circle() {

    }

    public Circle(double z) {
        super(z);
    }

    @Override
    public double getArea() {
        double result = Math.PI * this.z * this.z;
        super.area = result;
        return result;
    }
}
