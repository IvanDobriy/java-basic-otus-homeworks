package ru.otus.java.basic.homeworks.lesson7.transport;

import ru.otus.java.basic.homeworks.lesson7.landscape.Landscape;

import java.util.Objects;

public class Bicycle extends AbstractTransport {
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
    public int spendEnergy(int amount) {
        final var driver = getDriver();
        if (Objects.isNull(driver)) {
            return -1;
        }
        return getDriver().spendEnergy(amount);
    }

    @Override
    public int getEnergy() {
        final var driver = getDriver();
        if (Objects.isNull(driver)) {
            return 0;
        }
        return driver.getEnergy();
    }
}
