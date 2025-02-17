package ru.otus.java.basic.homeworks.lesson7.transport;

import ru.otus.java.basic.homeworks.lesson7.driver.IDriver;
import ru.otus.java.basic.homeworks.lesson7.operations.IMovable;

public interface ITransport extends IMovable {
    boolean place(IDriver driver);

    IDriver remove();

    IDriver getDriver();
}
