package ru.otus.java.basic.homeworks.lesson13.parser.element;

public abstract class BinaryOperation extends Element {
    public Number execute(Number left, Number right) {
        throw new RuntimeException("unsupported operation");
    }
}
