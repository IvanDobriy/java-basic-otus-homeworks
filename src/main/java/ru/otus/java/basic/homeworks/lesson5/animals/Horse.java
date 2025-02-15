package ru.otus.java.basic.homeworks.lesson5.animals;

public class Horse extends Animal {
    public Horse(String aName, int aRunSpeed, int aSwimSpeed, int aStamina) {
        super(aName, aRunSpeed, aSwimSpeed, aStamina);
        swimFactor = 4;
    }

    @Override
    public void info() {
        System.out.println(String.format("Horse description: %s", getDescription()));
    }
}
