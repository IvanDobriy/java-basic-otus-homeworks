package ru.otus.java.basic.homeworks.lesson7.transport;

public abstract class GasolineTransport extends ATransport {
    private int gasoline = 0;

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
}
