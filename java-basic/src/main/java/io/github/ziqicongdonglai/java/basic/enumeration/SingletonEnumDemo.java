package io.github.ziqicongdonglai.java.basic.enumeration;

import lombok.extern.slf4j.Slf4j;

/**
 * @author ke_zhang
 * @create 2021-09-29 20:50
 * @description
 * 利用枚举实现举例
 * 因为枚举类的构造方法只能被声明为private权限或不声明权限
 */
@Slf4j
public class SingletonEnumDemo {
    /**
     * 内部私有枚举
     */
    private enum SingletonEnum {
        /**
         * 枚举实例（单例）
         */
        INSTANCE;

        /**
         * 枚举属性
         */
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {
        SingletonEnum.INSTANCE.setName("soft");
        log.info(SingletonEnum.INSTANCE.getName());
    }
}
