package ru.otus.java.basic.homeworks.lesson7.transport;

import ru.otus.java.basic.homeworks.lesson7.landscape.Landscape;
import ru.otus.java.basic.homeworks.lesson7.operations.Movable;

public class LoggedMovable implements Movable {
    private final Movable movable;

    public LoggedMovable(Movable movable) {
        this.movable = movable;
    }

    @Override
    public boolean move(int distance, Landscape landscape) {
        final var result = movable.move(distance, landscape);
        System.out.println(String.format("%s moved with parameters(distance:%d, landscape:%s) and result:%b", movable, distance, landscape, result));
        return result;
    }
}
