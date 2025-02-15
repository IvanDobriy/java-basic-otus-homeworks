package ru.otus.java.basic.homeworks.lesson5.animals;

import java.util.Objects;

public abstract class Animal {
    protected final String name;
    protected int runSpeed;
    protected int swimSpeed;
    protected int stamina;
    protected int swimFactor;

    Animal(String aName, int aRunSpeed, int aSwimSpeed, int aStamina) {
        Objects.requireNonNull(aName);
        if (aRunSpeed < 0) {
            throw new IllegalArgumentException("aRunSpeed < 0");
        }
        if (aSwimSpeed < 0) {
            throw new IllegalArgumentException("aSwimSpeed < 0");
        }
        if (aStamina < 0) {
            throw new IllegalArgumentException("aStamina < 0");
        }
        name = aName;
        runSpeed = aRunSpeed;
        swimSpeed = aSwimSpeed;
        stamina = aStamina;
    }

    public int getStamina() {
        return stamina;
    }

    public double run(int distance) {
        if (distance < 0) {
            throw new IllegalArgumentException("distance < 0");
        }
        if (distance > stamina) {
            return -1;
        }
        stamina -= distance;
        return ((double) distance) / runSpeed;
    }

    public double swim(int distance) {
        if (distance < 0) {
            throw new IllegalArgumentException("distance < 0");
        }
        if (distance > ((double) stamina) / swimFactor) {
            return -1;
        }
        stamina -= distance * swimFactor;
        return ((double) distance) / swimSpeed;
    }

    public String getDescription() {
        return String.format("name: %s, runSpeed: %d, swimSpeed: %d, stamina: %d", name, runSpeed, swimSpeed, stamina);
    }

    public abstract void info();
}
