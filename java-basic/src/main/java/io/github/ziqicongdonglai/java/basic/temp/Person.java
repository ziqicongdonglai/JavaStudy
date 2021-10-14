package io.github.ziqicongdonglai.java.basic.temp;

import lombok.Builder;
import lombok.Data;

/**
 * @author ke_zhang
 * @create 2021-10-14 9:38
 * @description
 */
@Data
@Builder
public class Person {
    private String name;
    private Integer age;
    private Double height;

    public static void main(String[] args) {
        Person person1 = Person.builder()
                .name("Tom")
                .build();
        Person person2 = Person.builder()
                .name("Tom")
                .age(20)
                .build();
        Person person3 = Person.builder()
                .height(1.88)
                .name("Jack")
                .build();
        System.out.println(person1);
        System.out.println(person2);
        System.out.println(person3);
    }
}
