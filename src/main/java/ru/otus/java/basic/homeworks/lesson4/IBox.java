package ru.otus.java.basic.homeworks.lesson4;

import java.util.Objects;

public interface IBox {
    Size getSize();

    Color getColor();

    void setColor(Color aColor);

    boolean isOpened();

    void open();

    void close();

    boolean canContain(Box aBox);

    void putContent(Box aBox);

    Box removeContent();

    String getInfo();

    void printInfo();
}
