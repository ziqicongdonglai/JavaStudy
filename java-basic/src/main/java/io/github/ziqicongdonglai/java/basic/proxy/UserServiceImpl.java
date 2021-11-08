package io.github.ziqicongdonglai.java.basic.proxy;

/**
 * @author ke_zhang
 * @create 2021-11-08 22:39
 * @description
 */
public class UserServiceImpl implements UserService{
    @Override
    public void add() {
        System.out.println("add");
    }

    @Override
    public void delete() {
        System.out.println("delte");
    }

    @Override
    public void update() {
        System.out.println("update");
    }

    @Override
    public void query() {
        System.out.println("query");
    }
}
