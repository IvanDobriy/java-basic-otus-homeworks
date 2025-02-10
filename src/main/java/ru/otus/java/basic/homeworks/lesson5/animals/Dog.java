package ru.otus.java.basic.homeworks.lesson5.animals;

public class Dog extends Animal {
    public Dog(String aName, int aRunSpeed, int aSwimSpeed, int aStamina) {
        super(aName, aRunSpeed, aSwimSpeed, aStamina);
        swimFactor = 2;
    }

    @Override
    public void info() {
        System.out.println(String.format("Dog description: %s", getDescription()));
    }
}
