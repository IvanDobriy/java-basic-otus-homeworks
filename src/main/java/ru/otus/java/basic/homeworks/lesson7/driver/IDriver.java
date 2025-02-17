package ru.otus.java.basic.homeworks.lesson7.driver;

import ru.otus.java.basic.homeworks.lesson7.operations.IMovable;
import ru.otus.java.basic.homeworks.lesson7.transport.ITransport;

public interface IDriver extends IMovable {
    boolean getIn(ITransport transport);
    ITransport getOut();
    ITransport getTransport();
    String getName();

}
