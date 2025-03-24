package ru.otus.java.basic.homeworks.lesson13.parser.element;

import java.math.BigDecimal;

public class Number extends Element {
    private BigDecimal value;

    public Number(BigDecimal number) {
        value = number;
    }

    public BigDecimal getValue() {
        return value;
    }
}
