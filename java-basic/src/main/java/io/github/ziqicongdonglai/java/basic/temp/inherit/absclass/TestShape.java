package io.github.ziqicongdonglai.java.basic.temp.inherit.absclass;

/**
 * @author ke_zhang
 * @create 2021-10-21 16:30
 * @description
 */
public class TestShape {
    public static void main(String[] args) {
        Shape shape = new Circle(3.5);
        shape.getArea();
        System.out.println(shape.area);
        //System.out.println(shape.getArea());
        //shape = new Rectangle(4, 5);
        //System.out.println(shape.getArea());
    }
}
