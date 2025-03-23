package ru.otus.java.basic.homeworks.lesson13.parser.element;

import java.math.BigDecimal;
import java.util.Objects;

public class Number extends Element {
    private BigDecimal value;

    public Number(BigDecimal number) {
        value = number;
    }

    public BigDecimal getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number = (Number) o;
        return Objects.equals(value, number.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
