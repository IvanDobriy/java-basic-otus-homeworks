package ru.otus.java.basic.homeworks.lesson13.parser;

public class MathConverter {
    public RpnCalculator convertToRPN(String mathExpression) {
        if (mathExpression.isBlank()) {
            throw new IllegalArgumentException("math expression is blank");
        }
        mathExpression = mathExpression.replaceAll("\\s+", "");
        final var algebra = new Algebra(mathExpression);
        final var elements = algebra.run();
        final var rpn = new RpnCalculator(elements);
        return rpn;
    }
}
