package ru.otus.java.basic.homeworks.lesson13.parser;

import ru.otus.java.basic.homeworks.lesson13.parser.element.*;
import ru.otus.java.basic.homeworks.lesson13.parser.element.Number;

import java.math.BigDecimal;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Rpn {
    final List<Element> postfixNotation;

    public Rpn(List<Element> prefixNotation) {
        postfixNotation = new LinkedList<>();
        final Deque<Element> stack = new LinkedList<>();
        for (Element element : prefixNotation) {
            if (element instanceof Number) {
                postfixNotation.add(element);
                continue;
            }
            if (element instanceof LeftBracket) {
                stack.push(element);
                continue;
            }
            if (element instanceof RightBracket) {
                while (!(stack.peek() instanceof LeftBracket)) {
                    postfixNotation.add(stack.pop());
                }
                stack.pop();
                continue;
            }
            while (!stack.isEmpty() && (element.getPrecedence() <= stack.peek().getPrecedence())) {
                postfixNotation.add(stack.pop());
            }
            stack.push(element);
        }
        while (!stack.isEmpty()) {
            postfixNotation.add(stack.pop());
        }
    }

    public List<Element> getPostfixNotation() {
        return postfixNotation;
    }

    public BigDecimal calculate() {
        final Deque<Number> stack = new LinkedList<>();
        for (Element element : postfixNotation) {
            if (element instanceof BinaryOperation) {
                final var right = stack.pop();
                final var left = stack.pop();
                Number result = ((BinaryOperation) element).execute(left, right);
                stack.push(result);
                continue;
            }
            stack.push((Number) element);
        }
        return stack.pop().getValue();
    }
}
