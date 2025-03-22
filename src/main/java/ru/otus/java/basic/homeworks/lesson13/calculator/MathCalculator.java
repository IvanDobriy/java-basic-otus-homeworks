package ru.otus.java.basic.homeworks.lesson13.calculator;

import ru.otus.java.basic.homeworks.lesson13.parser.MathParser;

import java.math.BigDecimal;
import java.util.Objects;

public class MathCalculator {
    private MathParser parser;

    public MathCalculator(MathParser parser) {
        Objects.requireNonNull(parser);
        this.parser = parser;
    }

    public BigDecimal calculate(String mathExpression) {
        final var rpn = parser.parse(mathExpression);
        return rpn.calculate();
    }
}
