package io.github.ziqicongdonglai.java.basic.reflection;

/**
 * @author ke_zhang
 * @create 2021-11-09 22:12
 * @description
 */
public class Person {
    private Integer id;
    private String name;

    public Person() {
    }

    public Person(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public static void getPerson() {
        System.out.println("I am a person.");
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
