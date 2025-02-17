package ru.otus.java.basic.homeworks.lesson7.transport;

import ru.otus.java.basic.homeworks.lesson7.landscape.Landscape;

import java.util.Objects;

public class Rover extends GasolineTransport {
    private int gasoline = 0;

    @Override
    public boolean move(int distance, Landscape landscape) {
        if (Objects.isNull(this.getDriver())) {
            return false;
        }
        int remains = spendEnergy(distance);
        return remains >= 0;
    }
}
