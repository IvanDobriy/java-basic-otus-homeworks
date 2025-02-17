package ru.otus.java.basic.homeworks.lesson7.transport;

import ru.otus.java.basic.homeworks.lesson7.landscape.Landscape;

import java.util.Objects;

public class Car extends ATransport {
    @Override
    public boolean move(int distance, Landscape landscape) {
        if(Objects.isNull(this.getDriver())){
            return false;
        }
        System.out.println("moved");
        return true;
    }
}
