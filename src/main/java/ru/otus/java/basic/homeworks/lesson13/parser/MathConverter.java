package ru.otus.java.basic.homeworks.lesson13.parser;

import ru.otus.java.basic.homeworks.lesson13.parser.element.Element;

import java.util.List;

public class MathConverter {
    public List<Element> convert(String mathExpression) {
        if (mathExpression.isBlank()) {
            throw new IllegalArgumentException("math expression is blank");
        }
        mathExpression = mathExpression.replaceAll("\\s+", "");
        final var algebra = new Algebra(mathExpression);
        return algebra.run();
    }
}
