package ru.otus.java.basic.homeworks.lesson7.transport;

import ru.otus.java.basic.homeworks.lesson7.landscape.Landscape;

import java.util.Objects;

public class Car extends GasolineTransport {
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
}
