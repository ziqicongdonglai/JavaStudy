package io.github.ziqicongdonglai.java.basic.generics;

/**
 * @author ke_zhang
 * @create 2021-11-06 0:12
 * @description 单类型参数的泛型类
 */
public class Info<T> {
    private T value;

    public Info() {
    }

    public Info(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Info{" + "value=" + value + '}';
    }
}
