package ru.otus.java.basic.homeworks.lesson7.transport;

import ru.otus.java.basic.homeworks.lesson7.driver.Driver;

import java.util.Objects;

public abstract class AbstractTransport implements Transport {
    private Driver currentDriver;

    @Override
    public boolean place(Driver driver) {
        Objects.requireNonNull(driver);
        if (!Objects.isNull(currentDriver) && currentDriver != driver) {
            return false;
        }
        final var transport = driver.getTransport();
        if (Objects.isNull(transport)) {
            driver.getIn(this);
        } else if (transport != this) {
            return false;
        }
        currentDriver = driver;
        return true;
    }

    @Override
    public Driver remove() {
        if(Objects.isNull(currentDriver)){
            return null;
        }
        final var driver = currentDriver;
        currentDriver = null;
        if (!Objects.isNull(driver.getTransport())) {
            driver.getOut();
        }
        return driver;
    }

    @Override
    public Driver getDriver() {
        return currentDriver;
    }

    @Override
    public String toString() {
        String name = null;
        if (!Objects.isNull(currentDriver)) {
            name = currentDriver.getName();
        }
        return String.format("%s{currentDriver:%s}", this.getClass().getName(), name);
    }
}
