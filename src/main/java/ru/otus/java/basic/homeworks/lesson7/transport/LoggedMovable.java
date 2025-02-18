package ru.otus.java.basic.homeworks.lesson7.transport;

import ru.otus.java.basic.homeworks.lesson7.landscape.Landscape;
import ru.otus.java.basic.homeworks.lesson7.operations.IMovable;

public class LoggedMovable implements IMovable {
    private final IMovable movable;

    public LoggedMovable(IMovable movable) {
        this.movable = movable;
    }

    @Override
    public boolean move(int distance, Landscape landscape) {
        final var result = movable.move(distance, landscape);
        System.out.println(String.format("%s moved with parameters(distance:%d, landscape:%s) and result:%b", movable, distance, landscape, result));
        return result;
    }
}
