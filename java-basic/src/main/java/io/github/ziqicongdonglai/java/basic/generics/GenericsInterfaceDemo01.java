package io.github.ziqicongdonglai.java.basic.generics;

/**
 * @author ke_zhang
 * @create 2021-11-06 0:18
 * @description 实现接⼝的⼦类明确声明泛型类型
 */
public class GenericsInterfaceDemo01 implements Content<Integer> {
    private final int text;

    public GenericsInterfaceDemo01(int text) {
        this.text = text;
    }

    @Override
    public Integer text() {
        return text;
    }

    public static void main(String[] args) {
        GenericsInterfaceDemo01 demo = new GenericsInterfaceDemo01(10);
        System.out.print(demo.text());
    }
}
