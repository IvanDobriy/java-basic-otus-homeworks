package ru.otus.java.basic.homeworks.lesson13.parser.element;

public class DivisionOperation extends BinaryOperation {
    @Override
    public int getPrecedence() {
        return 2;
    }
    @Override
    public Number execute(Number left, Number right) {
        return new Number(left.getValue().divide(right.getValue()));
    }
}
