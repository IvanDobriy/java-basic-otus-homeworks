package ru.otus.java.basic.homeworks.lesson9;

import java.util.Objects;

public class Employee {
    private String name;
    private int age;

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public Employee(String name, int age){
        Objects.requireNonNull(name, "name is null");
        if(age < 0){
            throw new IllegalArgumentException("age < 0");
        }
        this.name = name;
        this.age = age;
    }

}
