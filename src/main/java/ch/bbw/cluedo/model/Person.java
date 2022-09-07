package ch.bbw.cluedo.model;

import java.awt.image.BufferedImage;

public class Person {
    private String name;
    private int age;
    private int weight;
    private String sex;
    private String image;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Person(String name, int age, int weight, String sex, String image) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.sex = sex;
        this.image = image;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
