package ru.otus.java.basic.homeworks.lesson7.driver;

import ru.otus.java.basic.homeworks.lesson7.landscape.Landscape;
import ru.otus.java.basic.homeworks.lesson7.transport.ITransport;

public class Human implements IDriver {
    private final String name;

    private ITransport currentTransport;

    public Human(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public ITransport getCurrentTransport() {
        return currentTransport;
    }

    public void setCurrentTransport(ITransport currentTransport) {
        this.currentTransport = currentTransport;
    }

    @Override
    public boolean move(int distance, Landscape landscape) {
        return false;
    }

}
