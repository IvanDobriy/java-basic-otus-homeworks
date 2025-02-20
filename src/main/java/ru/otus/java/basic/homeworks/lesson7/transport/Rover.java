package ru.otus.java.basic.homeworks.lesson7.transport;

import ru.otus.java.basic.homeworks.lesson7.landscape.Landscape;

import java.util.Objects;

public class Rover extends GasolineTransport {
    
    public Rover(int gasoline) {
        super(gasoline);
    }

    @Override
    public boolean move(int distance, Landscape landscape) {
        if (this.getDriver() == null) {
            return false;
        }
        return spendEnergy(distance);
    }
}
