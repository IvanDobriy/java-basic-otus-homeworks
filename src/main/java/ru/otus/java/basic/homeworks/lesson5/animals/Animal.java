package ru.otus.java.basic.homeworks.lesson5.animals;

import java.util.Objects;

public abstract class Animal {
    protected final String name;
    protected int speed;
    protected int stamina;

    Animal(String aName, int speed, int stamina) {
        Objects.requireNonNull(aName);
        name = aName;
        speed = speed;
        stamina = stamina;
    }

    public double run(int distance) {
        if(distance < 0){
            throw new IllegalArgumentException("distance < 0");
        }
        if(distance > stamina){
            return -1;
        }
        stamina -= distance;
        return ((double) distance) / speed;
    }

    public abstract double swim(int distance);

    public abstract void info();
}
