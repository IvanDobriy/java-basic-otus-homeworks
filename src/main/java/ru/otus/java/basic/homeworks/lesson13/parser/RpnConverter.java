package ru.otus.java.basic.homeworks.lesson13.parser;

import ru.otus.java.basic.homeworks.lesson13.parser.element.Element;
import ru.otus.java.basic.homeworks.lesson13.parser.element.LeftBracket;
import ru.otus.java.basic.homeworks.lesson13.parser.element.Number;
import ru.otus.java.basic.homeworks.lesson13.parser.element.RightBracket;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class RpnConverter {

    public List<Element> convertToPrefixNotion(List<Element> prefixNotation) {
        final List<Element> postfixNotation = new LinkedList<>();
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

        return postfixNotation;
    }
}
