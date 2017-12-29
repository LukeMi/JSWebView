package com.lukemi.jswebiew;

/**
 * Created by chenmz
 * on 2017/12/6 0006.
 */

public class Person {
    public String name;
    public String age;
    public String uint;

    public Person() {
    }

    public Person(String name, String age, String uint) {
        this.name = name;
        this.age = age;
        this.uint = uint;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", uint='" + uint + '\'' +
                '}';
    }
}
