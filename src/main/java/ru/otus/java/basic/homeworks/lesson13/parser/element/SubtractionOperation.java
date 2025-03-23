package ru.otus.java.basic.homeworks.lesson13.parser.element;

public class SubtractionOperation extends BinaryOperation {
    @Override
    public int getPrecedence() {
        return 1;
    }
}
