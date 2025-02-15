package ru.otus.java.basic.homeworks.lesson5.animals;

public class Cat extends Animal {
    public Cat(String aName, int aRunSpeed, int aSwimSpeed, int aStamina) {
        super(aName, aRunSpeed, aSwimSpeed, aStamina);
        swimFactor = -1;
    }

    @Override
    public double swim(int distance) {
        throw new RuntimeException("Cat can`t swim");
    }

    @Override
    public void info() {
        System.out.println(String.format("Cat description: %s", getDescription()));
    }
}
