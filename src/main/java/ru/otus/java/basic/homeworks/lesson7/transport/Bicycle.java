package ru.otus.java.basic.homeworks.lesson7.transport;

import ru.otus.java.basic.homeworks.lesson7.landscape.Landscape;

public class Bicycle extends ATransport {
    @Override
    public boolean move(int distance, Landscape landscape) {
        return false;
    }

    @Override
    public int spendEnergy(int amount) {
        return 0;
    }

    @Override
    public int getEnergy() {
        return 0;
    }
}
