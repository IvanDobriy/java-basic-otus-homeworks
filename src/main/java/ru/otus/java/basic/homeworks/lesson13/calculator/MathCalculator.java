package ru.otus.java.basic.homeworks.lesson13.calculator;

import ru.otus.java.basic.homeworks.lesson13.parser.MathConverter;
import ru.otus.java.basic.homeworks.lesson13.parser.RpnConverter;
import ru.otus.java.basic.homeworks.lesson13.parser.element.BinaryOperation;
import ru.otus.java.basic.homeworks.lesson13.parser.element.Element;
import ru.otus.java.basic.homeworks.lesson13.parser.element.Number;

import java.math.BigDecimal;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;

public class MathCalculator {
    private MathConverter mathConverter;
    private RpnConverter rpnConverter;

    public MathCalculator(MathConverter mathConverter, RpnConverter rpnConverter) {
        Objects.requireNonNull(mathConverter);
        Objects.requireNonNull(rpnConverter);
        this.mathConverter = mathConverter;
        this.rpnConverter = rpnConverter;
    }

    public BigDecimal calculate(String mathExpression) {
        Objects.requireNonNull(mathExpression);
        final var prefixNotation = mathConverter.convert(mathExpression);
        final var postfixNotation = rpnConverter.convertToPrefixNotion(prefixNotation);
        final Deque<Number> stack = new LinkedList<>();
        Number right;
        Number left;
        for (Element element : postfixNotation) {
            if (element instanceof BinaryOperation) {
                right = stack.pop();
                left = stack.pop();
                Number result = ((BinaryOperation) element).execute(left, right);
                stack.push(result);
                continue;
            }
            stack.push((Number) element);
        }
        return stack.pop().getValue();
    }
}
