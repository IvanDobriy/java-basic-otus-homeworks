package ru.otus.java.basic.homeworks.lesson13.parser.element;

public class SumOperation extends BinaryOperation {
    @Override
    public int getPrecedence() {
        return 1;
    }
}
