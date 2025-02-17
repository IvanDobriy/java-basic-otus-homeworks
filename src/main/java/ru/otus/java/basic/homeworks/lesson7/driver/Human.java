package ru.otus.java.basic.homeworks.lesson7.driver;

import ru.otus.java.basic.homeworks.lesson7.landscape.Landscape;
import ru.otus.java.basic.homeworks.lesson7.transport.ITransport;

import java.util.Objects;

public class Human implements IDriver {
    private int energy;
    private final String name;

    private ITransport currentTransport;

    public Human(String name, int energy) {
        this.name = name;
        this.energy = energy;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public ITransport getTransport() {
        return currentTransport;
    }

    @Override
    public boolean move(int distance, Landscape landscape) {
        if (Objects.isNull(currentTransport)) {
            return spendEnergy(distance) >= 0;
        }
        return currentTransport.move(distance, landscape);
    }

    @Override
    public boolean getIn(ITransport transport) {
        Objects.requireNonNull(transport);
        if (!Objects.isNull(currentTransport) && currentTransport != transport) {
            return false;
        }
        currentTransport = transport;
        if (currentTransport.place(this)) {
            return true;
        }
        currentTransport = null;
        return false;
    }

    @Override
    public ITransport getOut() {
        final var transport = currentTransport;
        currentTransport = null;
        if (!Objects.isNull(transport.getDriver())) {
            transport.remove();
        }
        return transport;
    }

    @Override
    public String toString() {
        return String.format("%s{name:%s,energy:%d,currentTransport:%s}", this.getClass().getName(), name, energy, currentTransport);
    }

    @Override
    public int spendEnergy(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("amount < 0");
        }
        int remains = energy - amount;
        energy = Math.max(0, remains);
        return remains;
    }

    @Override
    public int getEnergy() {
        return energy;
    }
}
