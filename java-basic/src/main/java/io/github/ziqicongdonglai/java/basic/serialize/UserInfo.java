package io.github.ziqicongdonglai.java.basic.serialize;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * @author ke_zhang
 * @create 2021-10-18 22:49
 * @description
 */
public class UserInfo implements Externalizable {


    private static final long serialVersionUID = -7792375476363060816L;
    private String userName;
    private Integer useAge;
    private Integer useScore;
    private transient String usePass;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUseAge() {
        return useAge;
    }

    public void setUseAge(Integer useAge) {
        this.useAge = useAge;
    }

    public Integer getUseScore() {
        return useScore;
    }

    public void setUseScore(Integer useScore) {
        this.useScore = useScore;
    }

    public String getUsePass() {
        return usePass;
    }

    public void setUsePass(String usePass) {
        this.usePass = usePass;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "userName='" + userName + '\'' +
                ", useAge=" + useAge +
                ", useScore=" + useScore +
                ", usePass='" + usePass + '\'' +
                '}';
    }

    public UserInfo() {
        //  这个是在第二次测试使用，判断反序列化是否通过构造器
        useAge = 20;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        // 指定序列化时候写入的属性。这里仍然不写入年龄
        out.writeObject(userName);
        out.writeObject(usePass);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        // 指定反序列化的时候读取属性的顺序以及读取的属性
        // 如果你写反了属性读取的顺序，你可以发现反序列化的读取的对象的指定的属性值也会按你写的读取
        userName= (String) in.readObject();
        usePass = (String) in.readObject();
    }
}
