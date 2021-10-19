package io.github.ziqicongdonglai.java.basic.serialize;

import java.io.*;

/**
 * @author ke_zhang
 * @create 2021-10-18 21:42
 * @description Student类的序列化和反序列化
 */
public class StudentSerialize {
    /**
     * 实现Serializable 序列化
     *
     * @throws IOException IO异常
     */
    public static void serialize() throws IOException {
        Student student = new Student();
        student.setName("Java学习者");
        student.setAge(20);
        student.setScore(1000);

        ObjectOutputStream objectOutputStream =
                new ObjectOutputStream(new FileOutputStream("student.txt"));
        objectOutputStream.writeObject(student);
        objectOutputStream.close();

        System.out.println("序列化成功！已经生成student.txt文件");
        System.out.println("========================================");
    }

    public static void deserialize() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream =
                new ObjectInputStream(new FileInputStream("student.txt"));
        Student student = (Student) objectInputStream.readObject();
        objectInputStream.close();

        System.out.println("反序列化结果为：");
        System.out.println(student);
    }

    /**
     * 实现Externalizable 序列化
     *
     * @throws IOException IO异常
     */
    public static void externaliz() throws IOException {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName("Java学习者");
        userInfo.setUseAge(20);
        userInfo.setUseScore(1000);
        userInfo.setUsePass("123");

        ObjectOutputStream objectOutputStream =
                new ObjectOutputStream(new FileOutputStream("userInfo.txt"));
        objectOutputStream.writeObject(userInfo);
        objectOutputStream.close();

        System.out.println("序列化成功！已经生成userInfo.txt文件");
        System.out.println("========================================");
    }

    public static void deExternaliz() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream =
                new ObjectInputStream(new FileInputStream("userInfo.txt"));
        UserInfo userInfo = (UserInfo) objectInputStream.readObject();
        objectInputStream.close();

        System.out.println("反序列化结果为：");
        System.out.println(userInfo);
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // 先执行序列化
        //serialize();
        // 成功后看到生成了student.txt再执行下面的反序列化
         deserialize();

        // 先执行序列化
        //externaliz();
        // 成功后看到生成了userInfo.txt再执行下面的反序列化
        // deExternaliz();
    }
}
