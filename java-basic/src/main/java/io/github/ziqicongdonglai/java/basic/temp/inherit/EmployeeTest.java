package io.github.ziqicongdonglai.java.basic.temp.inherit;

/**
 * @author ke_zhang
 * @create 2021-10-21 8:25
 * @description
 */
public class EmployeeTest {
    public static void main(String[] args) {
        //Developer developer1 = new Developer();
        //developer1.setId(1001);
        //developer1.setName("小明");
        //developer1.salary = 1888.8901920;
        //System.out.println(developer1);
        //developer1.test();
        //System.out.println("*************************");
        //Developer developer2 = new Developer(1002, "小华", 9999.999);
        //System.out.println(developer2);
        //developer2.test();

        Developer developer = new Developer(1001, "tom", 888.88);
        System.out.println(developer);
    }
}

class Employee {
    protected Integer id;
    protected String name;

    public Employee() {

    }

    public Employee(Integer id) {
        this.id = id;
    }

    public Employee(String name) {
        this.name = name;
    }

    public Employee(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void work () {
        System.out.println("work hard...");
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}

class Developer extends Employee{
    String name;
    Double salary;

    public Developer() {
        // 3.调用父类的成员变量
        super.id = 1003;
    }

    public Developer(Integer id, String name, Double salary) {
        //1.调用父类的构造方法
        //super(id, name);
        //super(id);
        //this.name = name;
        //this.salary = salary;
        super(id, name);
        this.salary = salary;
    }

    @Override
    public void work() {
        System.out.println("努力搬砖");
    }

    public void test() {
        // 2.调用父类的成员方法
        //super.work();
        this.name = "测试姓名";
        System.out.println(super.name);
        System.out.println(this.name);
    }

    @Override
    public String toString() {
        return String.format("%-10s %-8s %.1f", this.id, this.name, this.salary);
    }
}

