package ru.otus.java.basic.homeworks.lesson9;

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
        this.name = name;
        this.age = age;
    }

}
