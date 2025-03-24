package ru.otus.java.basic.homeworks.lesson13.parser;

import ru.otus.java.basic.homeworks.lesson13.parser.element.Number;
import ru.otus.java.basic.homeworks.lesson13.parser.element.*;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Algebra {
    private final Set<Character> brackets = Set.of('(', ')');
    private final Set<Character> mathOperations = Set.of('+', '-', '/', '*');

    private LinkedList<Element> result;

    private final String mathExpression;
    private int position;

    private int bracketCounter;

    public Algebra(String mathExpression) {
        if (mathExpression.isBlank()) {
            throw new IllegalArgumentException("math expression is blank");
        }
        this.mathExpression = mathExpression;
        position = 0;
        bracketCounter = 0;
        result = new LinkedList<>();
    }

    private Number parseNumber() {
        StringBuilder builder = new StringBuilder();
        while (position < mathExpression.length() && Character.isDigit(mathExpression.charAt(position))) {
            builder.append(mathExpression.charAt(position));
            position++;
        }
        return new Number(new BigDecimal(builder.toString()));
    }

    private BinaryOperation parseBinaryOperation() {
        char currentSymbol = mathExpression.charAt(position);
        if (!((result.getLast() instanceof Number) || (result.getLast() instanceof RightBracket))) {
            throw new RuntimeException(String.format("%c is not binary operation", currentSymbol));
        }
        position++;
        if (currentSymbol == '+') {
            return new SumOperation();
        }
        if (currentSymbol == '-') {
            return new SubtractionOperation();
        }
        if (currentSymbol == '/') {
            return new DivisionOperation();
        }
        if (currentSymbol == '*') {
            return new MultiplicationOperation();
        }
        throw new RuntimeException("unsupported binary operation");
    }

    private Bracket parseBracket() {
        char currentSymbol = mathExpression.charAt(position);
        if (currentSymbol == '(') {
            if (!(result.isEmpty() || result.getLast() instanceof BinaryOperation)) {
                throw new RuntimeException("bla bla bla");
            }
            bracketCounter++;
            position++;
            return new LeftBracket();
        }
        if (currentSymbol != ')') {
            throw new RuntimeException("expected ')' symbol");
        }
        if (bracketCounter == 0 || !(result.getLast() instanceof Number || result.getLast() instanceof LeftBracket)) {
            throw new RuntimeException("left brace is not closed");
        }
        bracketCounter--;
        position++;
        return new RightBracket();
    }

    public List<Element> run() {
        position = 0;
        bracketCounter = 0;
        result = new LinkedList<>();
        char currentSymbol;
        while (position < mathExpression.length()) {
            currentSymbol = mathExpression.charAt(position);
            if (Character.isDigit(currentSymbol)) {
                result.add(parseNumber());
                continue;
            }
            if (brackets.contains(currentSymbol)) {
                result.add(parseBracket());
            }
            if (mathOperations.contains(currentSymbol)) {
                result.add(parseBinaryOperation());
            }
        }
        if (bracketCounter != 0) {
            throw new RuntimeException("bracketCounter != 0");
        }
        return result;
    }
}
