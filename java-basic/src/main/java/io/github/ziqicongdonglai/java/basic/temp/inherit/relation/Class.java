package io.github.ziqicongdonglai.java.basic.temp.inherit.relation;

/**
 * @author ke_zhang
 * @create 2021-10-21 9:43
 * @description 班级类
 */
public class Class {
    Student student;

    public void show() {
        student.study();
    }

    public void print() {
        System.out.println(student);
    }
}
