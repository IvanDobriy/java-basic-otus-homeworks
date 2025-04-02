package ru.otus.java.basic.homeworks.lesson13.parser.element;

import java.math.BigDecimal;

public class PowerOperation extends BinaryOperation {
    @Override
    public Number execute(Number left, Number right) {
        return new Number(BigDecimal.valueOf(Math.pow(left.getValue().doubleValue(), right.getValue().doubleValue())));
    }

    @Override
    public int getPrecedence() {
        return 3;
    }
}
