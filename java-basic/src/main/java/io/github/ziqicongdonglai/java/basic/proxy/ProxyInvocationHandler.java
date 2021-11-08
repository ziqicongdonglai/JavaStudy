package io.github.ziqicongdonglai.java.basic.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author ke_zhang
 * @create 2021-11-08 22:31
 * @description
 */
public class ProxyInvocationHandler implements InvocationHandler {
    private Object target;

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    /**
     * 生成得到代理类
     *
     * @return 代理类
     */
    public Object getProxy() {
        return Proxy.newProxyInstance(this.getClass().getClassLoader(),
                target.getClass().getInterfaces(), this);
    }

    /**
     * 处理代理实例，并返回结果
     *
     * @param proxy 代理对象
     * @param method 代理方法
     * @param args 入参数组
     * @return 执行结果
     * @throws Throwable 异常
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log(method.getName());
        // 动态代理的本质就是使用反射机制来实现
        return method.invoke(target, args);
    }

    public void log(String msg) {
        System.out.println("执行了" + msg + "方法");
    }
}
