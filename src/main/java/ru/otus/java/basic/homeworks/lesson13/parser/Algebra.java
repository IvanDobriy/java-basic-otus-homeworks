package ru.otus.java.basic.homeworks.lesson13.parser;

import ru.otus.java.basic.homeworks.lesson13.parser.element.Number;
import ru.otus.java.basic.homeworks.lesson13.parser.element.*;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.Set;

public class Algebra {

    public interface Callback {
        void run(Element element);
    }

    private final Set<Character> brackets = Set.of('(', ')');
    private final Set<Character> mathOperations = Set.of('+', '-', '/', '*');

    private final LinkedList<Element> rawElements;

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
        rawElements = new LinkedList<>();
    }

    public Number parseNumber() {
        StringBuilder builder = new StringBuilder();
        while (Character.isDigit(mathExpression.charAt(position))) {
            builder.append(mathExpression.charAt(position));
            position++;
        }
        return new Number(new BigDecimal(builder.toString()));
    }

    public BinaryOperation parseBinaryOperation() {
        char currentSymbol = mathExpression.charAt(position);
        if (!(rawElements.getLast() instanceof Number)) {
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

    public Bracket parseBracket() {
        char currentSymbol = mathExpression.charAt(position);
        if (currentSymbol == '(') {
            if (!(rawElements.isEmpty() || rawElements.getLast() instanceof BinaryOperation)) {
                throw new RuntimeException("bla bla bla");
            }
            bracketCounter++;
            position++;
            return new LeftBracket();
        }
        if (currentSymbol != ')') {
            throw new RuntimeException("bla bla bla");
        }
        if (bracketCounter == 0 || !(rawElements.getLast() instanceof Number || rawElements.getLast() instanceof LeftBracket)) {
            throw new RuntimeException("bla bla bla");
        }
        bracketCounter--;
        position++;
        return new RightBracket();
    }

    public void forEach(Callback callback) {
        char currentSymbol;
        while (position < mathExpression.length()) {
            currentSymbol = mathExpression.charAt(position);
            if (Character.isDigit(currentSymbol)) {
                rawElements.add(parseNumber());
                continue;
            }
            if (brackets.contains(currentSymbol)) {
                rawElements.add(parseBracket());
            }
            if (mathOperations.contains(currentSymbol)) {
                rawElements.add(parseBinaryOperation());
            }
        }
        if (bracketCounter != 0) {
            throw new RuntimeException("bracketCounter != 0");
        }
        for (Element element : rawElements) {
            callback.run(element);
        }
    }
}
