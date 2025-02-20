package ru.otus.java.basic.homeworks.lesson7.transport;

import ru.otus.java.basic.homeworks.lesson7.landscape.Landscape;

import java.util.Objects;

public class Bicycle extends AbstractTransport {
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
    public boolean spendEnergy(int amount) {
        if (currentDriver == null) {
            return false;
        }
        return getDriver().spendEnergy(amount);
    }

    @Override
    public int getEnergy() {
        if (currentDriver == null) {
            return 0;
        }
        return currentDriver.getEnergy();
    }
}
