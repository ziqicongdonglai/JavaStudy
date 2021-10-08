package io.github.ziqicongdonglai.address.model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.Image;

import java.time.LocalDate;

/**
 * @author ke_zhang
 * @create 2021-10-08 21:40
 * @description 数据模型类
 */
public class Person {
    private final StringProperty name;
    private final StringProperty clazz;
    private final StringProperty gender;
    private final StringProperty address;
    private final ObjectProperty<LocalDate> birthday;
    private final ObjectProperty<Image> avatar;

    public Person() {
        this(null,null,null,null,null,null);
    }

    public Person(String name, String clazz, String gender, String address, LocalDate birthday, Image avatar) {
        this.name = new SimpleStringProperty(name);
        this.clazz = new SimpleStringProperty(clazz);
        this.gender = new SimpleStringProperty(gender);
        this.address = new SimpleStringProperty(address);
        this.birthday = new SimpleObjectProperty<>(birthday);
        this.avatar = new SimpleObjectProperty<>(avatar);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getClazz() {
        return clazz.get();
    }

    public StringProperty clazzProperty() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz.set(clazz);
    }

    public String getGender() {
        return gender.get();
    }

    public StringProperty genderProperty() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender.set(gender);
    }

    public String getAddress() {
        return address.get();
    }

    public StringProperty addressProperty() {
        return address;
    }

    public void setAddress(String address) {
        this.address.set(address);
    }

    public LocalDate getBirthday() {
        return birthday.get();
    }

    public ObjectProperty<LocalDate> birthdayProperty() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday.set(birthday);
    }

    public Image getAvatar() {
        return avatar.get();
    }

    public ObjectProperty<Image> avatarProperty() {
        return avatar;
    }

    public void setAvatar(Image avatar) {
        this.avatar.set(avatar);
    }
}
