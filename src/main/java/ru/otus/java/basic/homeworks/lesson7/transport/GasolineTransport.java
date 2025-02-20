package ru.otus.java.basic.homeworks.lesson7.transport;

import java.util.Objects;

public abstract class GasolineTransport extends AbstractTransport {
    private int gasoline = 0;

    protected GasolineTransport(int gasoline) {
        this.gasoline = gasoline;
    }

    @Override
    public int spendEnergy(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("amount < 0");
        }
        int remains = gasoline - amount;
        gasoline = Math.max(0, remains);
        return remains;
    }

    @Override
    public int getEnergy() {
        return gasoline;
    }

    @Override
    public String toString() {
        String name = null;
        if (getDriver() != null) {
            name = getDriver().getName();
        }
        return String.format("%s{gasoline:%d,currentDriver:%s}", this.getClass().getName(), gasoline, name);
    }
}
