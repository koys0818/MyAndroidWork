package com.lec.android.a007_activity;

//intent 에 담아 보내는 객체는 반드시 serializable 되어있어야한다

import java.io.Serializable;

public class Person implements Serializable {
    String name;
    int age;



    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
