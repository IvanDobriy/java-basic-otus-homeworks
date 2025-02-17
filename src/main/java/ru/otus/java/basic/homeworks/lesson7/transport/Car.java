package ru.otus.java.basic.homeworks.lesson7.transport;

import ru.otus.java.basic.homeworks.lesson7.landscape.Landscape;

import java.util.Objects;

public class Car extends ATransport {
    private int gasoline = 0;

    @Override
    public boolean move(int distance, Landscape landscape) {
        if (Objects.isNull(this.getDriver())) {
            return false;
        }
        int remains = -1;
        if(landscape.equals(Landscape.PLAIN)){
            remains = spendEnergy(distance);
        }
        return remains >= 0;
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
}
