package io.github.ziqicongdonglai.java.basic.oop;

import lombok.Data;

/**
 * @author ke_zhang
 * @create 2021-10-15 20:33
 * @description
 */
@Data
class Address implements Cloneable {
    private Integer id;
    private String describe;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

@Data
class Student implements Cloneable {
    private Integer id;
    private String name;
    private Address address;

    //@Override
    //protected Object clone() throws CloneNotSupportedException {
    //    // 浅拷贝
    //    return super.clone();
    //}


    @Override
    protected Object clone() throws CloneNotSupportedException {
        // 深拷贝
        Student s = (Student) super.clone();
        s.address = (Address) this.address.clone();
        return s;
    }
}
