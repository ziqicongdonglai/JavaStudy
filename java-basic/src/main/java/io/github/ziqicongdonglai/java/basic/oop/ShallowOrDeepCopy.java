package io.github.ziqicongdonglai.java.basic.oop;

import lombok.extern.slf4j.Slf4j;

/**
 * @author ke_zhang
 * @create 2021-10-15 20:40
 * @description 浅拷贝or深拷贝
 */
@Slf4j
public class ShallowOrDeepCopy {
    public static void main(String[] args) throws CloneNotSupportedException{
        Student student = new Student();
        student.setId(1);
        student.setName("zk");
        Address address = new Address();
        address.setId(101);
        address.setDescribe("江苏南京");
        student.setAddress(address);

        Student cloneStudent = (Student) student.clone();
        log.info("********************浅拷贝还是深拷贝********************");
        log.info("student == cloneStudent: {}", student == cloneStudent);
        log.info("二级对象内容：{}", student.getAddress() == cloneStudent.getAddress());
        log.info("二级对象中内容：{}", student.getAddress().getDescribe() ==
                cloneStudent.getAddress().getDescribe());

        log.info("********************修改属性前********************");
        log.info(student.toString());
        log.info(cloneStudent.toString());
        student.setName("张珂");
        address.setDescribe("江苏扬州");
        log.info("********************修改属性后********************");
        log.info(student.toString());
        log.info(cloneStudent.toString());
    }
}
