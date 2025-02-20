package ru.otus.java.basic.homeworks.lesson7.transport;

import ru.otus.java.basic.homeworks.lesson7.driver.Driver;
import ru.otus.java.basic.homeworks.lesson7.operations.Energy;
import ru.otus.java.basic.homeworks.lesson7.operations.Movable;

public interface Transport extends Movable, Energy {
    boolean place(Driver driver);

    Driver remove();

    Driver getDriver();
}
