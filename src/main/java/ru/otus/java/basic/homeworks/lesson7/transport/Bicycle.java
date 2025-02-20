package ru.otus.java.basic.homeworks.lesson7.transport;

import ru.otus.java.basic.homeworks.lesson7.landscape.Landscape;

import java.util.Objects;

public class Bicycle extends AbstractTransport {
    @Override
    public boolean move(int distance, Landscape landscape) {
        if (this.getDriver() == null) {
            return false;
        }
        if (landscape == Landscape.SWAMP) {
            return false;
        }
        return spendEnergy(distance) >= 0;
    }

    @Override
    public int spendEnergy(int amount) {
        final var driver = getDriver();
        if (driver == null) {
            return -1;
        }
        return getDriver().spendEnergy(amount);
    }

    @Override
    public int getEnergy() {
        final var driver = getDriver();
        if (driver == null) {
            return 0;
        }
        return driver.getEnergy();
    }
}
