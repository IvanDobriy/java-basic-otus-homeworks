package ru.otus.java.basic.homeworks.lesson7.transport;

import ru.otus.java.basic.homeworks.lesson7.driver.IDriver;
import ru.otus.java.basic.homeworks.lesson7.landscape.Landscape;

import java.util.Objects;

public class Bicycle implements ITransport {
    private IDriver driver;
    @Override
    public boolean place(IDriver driver) {
        Objects.requireNonNull(driver);
        if(!Objects.isNull(this.driver)){
            return false;
        }
        this.driver = driver;
        return true;
    }

    @Override
    public boolean remove() {
        if(!Objects.isNull(driver)){
            driver = null;
            return true;
        }
        return false;
    }

    @Override
    public boolean move(int distance, Landscape landscape) {
        return false;
    }
}
