package ru.otus.java.basic.homeworks.lesson13.parser;

import java.util.Objects;

public class MathParser {
    private final Algebra algebra;

    public MathParser(Algebra algebra) {
        Objects.requireNonNull(algebra);
        this.algebra = algebra;
    }

    public Rpn parse(String mathExpression) {
        if (mathExpression.isBlank()) {
            throw new IllegalArgumentException("math expression is blank");
        }
        return null;
    }
}
