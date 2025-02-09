package ru.otus.java.basic.homeworks.lesson5.animals;

public class Cat extends Animal{
    Cat(String aName, int speed, int stamina) {
        super(aName, speed, stamina);
    }

    @Override
    public double swim(int distance) {
        return 0;
    }

    @Override
    public void info() {

    }
}
