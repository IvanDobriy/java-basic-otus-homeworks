package ru.otus.java.basic.homeworks.lesson13.parser.element;

public class DivisionOperation extends BinaryOperation {
    @Override
    public int getPrecedence() {
        return 2;
    }
}
