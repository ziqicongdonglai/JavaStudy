package io.github.ziqicongdonglai.java.basic.temp.inherit.absclass;

/**
 * @author ke_zhang
 * @create 2021-10-21 17:57
 * @description
 */
public class TestEmployee {
    public static void main(String[] args) {
        Employee employee = new JavaEE();
        employee.setId("1001");
        employee.setName("Tom");
        System.out.println(employee);
        employee.work();
        System.out.println("*************************");
        employee = new Android();
        employee.setId("1002");
        employee.setName("Jack");
        System.out.println(employee);
        employee.work();
        System.out.println("*************************");
        employee = new Internet();
        employee.setId("1003");
        employee.setName("Mary");
        System.out.println(employee);
        employee.work();
        System.out.println("*************************");
        employee = new HardWare();
        employee.setId("1004");
        employee.setName("David");
        System.out.println(employee);
        employee.work();
    }
}
