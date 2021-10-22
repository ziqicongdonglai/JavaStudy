package io.github.ziqicongdonglai.java.basic.temp.inherit.absclass;

/**
 * @author ke_zhang
 * @create 2021-10-21 17:02
 * @description
 */
public abstract class Employee {
    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 工作：抽象方法
     */
    public abstract void work();

    @Override
    public String toString() {
        return String.format("员工号为%s的%s员工", this.id, this.name);
    }
}
