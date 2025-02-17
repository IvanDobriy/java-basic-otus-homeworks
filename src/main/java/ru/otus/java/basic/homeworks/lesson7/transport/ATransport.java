package ru.otus.java.basic.homeworks.lesson7.transport;

import ru.otus.java.basic.homeworks.lesson7.driver.IDriver;

import java.util.Objects;

public abstract class ATransport implements ITransport {
    private IDriver currentDriver;
    @Override
    public boolean place(IDriver driver) {
        Objects.requireNonNull(driver);
        if (!Objects.isNull(currentDriver)) {
            return false;
        }
        currentDriver = driver;
        return true;
    }

    @Override
    public IDriver remove() {
        final var driver = currentDriver;
        currentDriver = null;
        return driver;
    }

    @Override
    public IDriver getDriver() {
        return currentDriver;
    }

    @Override
    public String toString() {
        return String.format("%s{currentDriver:%s}", this.getClass().getName(), currentDriver);
    }
}
