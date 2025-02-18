package ru.otus.java.basic.homeworks.lesson7.transport;

import ru.otus.java.basic.homeworks.lesson7.landscape.Landscape;

import java.util.Objects;

public class Horse extends ATransport {
    private int forces;

    public Horse(int forces) {
        this.forces = forces;
    }

    @Override
    public int spendEnergy(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("amount < 0");
        }
        int remains = forces - amount;
        forces = Math.max(0, remains);
        return remains;
    }

    @Override
    public int getEnergy() {
        return forces;
    }

    @Override
    public boolean move(int distance, Landscape landscape) {
        if (Objects.isNull(this.getDriver())) {
            return false;
        }
        if (landscape.equals(Landscape.SWAMP)) {
            return false;
        }
        return spendEnergy(distance) >= 0;
    }
    @Override
    public String toString() {
        String name = null;
        var driver = getDriver();
        if (!Objects.isNull(driver)) {
            name = driver.getName();
        }
        return String.format("%s{forces:%d,currentDriver:%s}", this.getClass().getName(), forces, name);
    }
}
