package ru.otus.java.basic.homeworks.lesson13.parser.element;

public class MultiplicationOperation extends BinaryOperation {
    @Override
    public int getPrecedence() {
        return 2;
    }
}
