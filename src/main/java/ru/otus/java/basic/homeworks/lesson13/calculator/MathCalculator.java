package ru.otus.java.basic.homeworks.lesson13.calculator;

import ru.otus.java.basic.homeworks.lesson13.parser.MathConverter;

import java.math.BigDecimal;
import java.util.Objects;

public class MathCalculator {
    private MathConverter parser;

    public MathCalculator(MathConverter parser) {
        Objects.requireNonNull(parser);
        this.parser = parser;
    }

    public BigDecimal calculate(String mathExpression) {
        final var rpn = parser.convertToRPN(mathExpression);
        return rpn.calculate();
    }
}
