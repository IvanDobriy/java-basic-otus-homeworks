package ru.otus.java.basic.homeworks.lesson7.transport;

import ru.otus.java.basic.homeworks.lesson7.driver.IDriver;
import ru.otus.java.basic.homeworks.lesson7.landscape.Landscape;

public class Horse implements ITransport {
    @Override
    public boolean place(IDriver driver) {
        return false;
    }

    @Override
    public boolean remove() {
        return false;
    }

    @Override
    public boolean move(int distance, Landscape landscape) {
        return false;
    }
}
