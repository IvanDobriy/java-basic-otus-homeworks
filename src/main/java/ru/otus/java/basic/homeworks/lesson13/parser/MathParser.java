package ru.otus.java.basic.homeworks.lesson13.parser;

public class MathParser {
    public Rpn parse(String mathExpression) {
        if (mathExpression.isBlank()) {
            throw new IllegalArgumentException("math expression is blank");
        }
        mathExpression = mathExpression.replaceAll("\\s+", "");
        final var algebra = new Algebra(mathExpression);
        final var elements = algebra.parse();
        final var rpn = new Rpn(elements);
        return rpn;
    }
}
