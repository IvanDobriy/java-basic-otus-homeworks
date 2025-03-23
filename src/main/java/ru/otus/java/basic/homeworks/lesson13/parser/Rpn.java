package ru.otus.java.basic.homeworks.lesson13.parser;

import ru.otus.java.basic.homeworks.lesson13.parser.element.*;
import ru.otus.java.basic.homeworks.lesson13.parser.element.Number;

import java.math.BigDecimal;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Rpn {
    final List<Element> postfix;

    public Rpn(List<Element> elements) {
        postfix = new LinkedList<>();
        final Deque<Element> stack = new LinkedList<>();
        for (Element element : elements) {
            if (element instanceof Number) {
                postfix.add(element);
                continue;
            }
            if (element instanceof LeftBracket) {
                stack.add(element);
                continue;
            }
            if (element instanceof RightBracket) {
                while (stack.peek() instanceof LeftBracket) {
                    postfix.add(stack.pop());
                }
                stack.pop();
                continue;
            }
            while (!stack.isEmpty() && (element.getPrecedence() <= stack.peek().getPrecedence())) {
                postfix.add(stack.pop());
            }
            postfix.add(element);
        }
        while (!stack.isEmpty()) {
            postfix.add(stack.pop());
        }
    }
    public List<Element> getPostfix() {
        return postfix;
    }

    public BigDecimal calculate() {
        return null;
    }
}
