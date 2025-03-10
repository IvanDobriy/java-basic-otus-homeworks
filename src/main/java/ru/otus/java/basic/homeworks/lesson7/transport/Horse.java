package ru.otus.java.basic.homeworks.lesson7.transport;

import ru.otus.java.basic.homeworks.lesson7.landscape.Landscape;

import java.util.Objects;

public class Horse extends AbstractTransport {
    private int forces;

    public Horse(int forces) {
        this.forces = forces;
    }

    @Override
    public boolean spendEnergy(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("amount < 0");
        }
        int remains = forces - amount;
        forces = Math.max(0, remains);
        return remains >= 0;
    }

    @Override
    public int getEnergy() {
        return forces;
    }

    @Override
    public boolean move(int distance, Landscape landscape) {
        if (currentDriver == null) {
            return false;
        }
        if (landscape == Landscape.SWAMP) {
            return false;
        }
        return spendEnergy(distance);
    }

    @Override
    public String toString() {
        String name = null;
        if (currentDriver != null) {
            name = currentDriver.getName();
        }
        return String.format("%s{forces:%d,currentDriver:%s}", this.getClass().getName(), forces, name);
    }
}
