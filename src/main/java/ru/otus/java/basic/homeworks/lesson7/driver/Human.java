package ru.otus.java.basic.homeworks.lesson7.driver;

import ru.otus.java.basic.homeworks.lesson7.landscape.Landscape;
import ru.otus.java.basic.homeworks.lesson7.transport.ITransport;

import java.util.Objects;

public class Human implements IDriver {
    private final String name;

    private ITransport currentTransport;

    public Human(String name) {
        this.name = name;
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
            //TODO self moving
        }
        return false;
    }

    @Override
    public boolean getIn(ITransport transport) {
        Objects.requireNonNull(transport);
        if (!Objects.isNull(currentTransport)) {
            return false;
        }
        currentTransport = transport;
        return true;
    }

    @Override
    public ITransport getOut() {
        final var transport = currentTransport;
        currentTransport = null;
        return transport;
    }

    @Override
    public String toString() {
        return String.format("%s{name:%s,currentTransport:%s}", this.getClass().getName(), name, currentTransport);
    }
}
