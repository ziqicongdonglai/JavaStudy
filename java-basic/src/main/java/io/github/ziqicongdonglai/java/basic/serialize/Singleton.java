package io.github.ziqicongdonglai.java.basic.serialize;

import java.io.Serializable;

/**
 * @author ke_zhang
 * @create 2021-10-18 23:26
 * @description 单例类
 */
public class Singleton implements Serializable {


    private static final long serialVersionUID = 6943589587726147383L;

    private Singleton() {

    }

    private static class SingletonHolder {
        private static final Singleton singleton = new Singleton();
    }

    public static synchronized Singleton getSingleton() {
        return SingletonHolder.singleton;
    }

    private Object readResolve() {
        return SingletonHolder.singleton;
    }
}
