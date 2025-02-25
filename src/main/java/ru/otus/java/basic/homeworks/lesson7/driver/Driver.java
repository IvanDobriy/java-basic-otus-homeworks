package ru.otus.java.basic.homeworks.lesson7.driver;

import ru.otus.java.basic.homeworks.lesson7.operations.Energy;
import ru.otus.java.basic.homeworks.lesson7.operations.Movable;
import ru.otus.java.basic.homeworks.lesson7.transport.Transport;

public interface Driver extends Movable, Energy {
    boolean getIn(Transport transport);
    Transport getOut();
    Transport getTransport();
    String getName();
}
