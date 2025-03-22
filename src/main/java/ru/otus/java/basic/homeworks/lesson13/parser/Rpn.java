package ru.otus.java.basic.homeworks.lesson13.parser;

import ru.otus.java.basic.homeworks.lesson13.parser.element.BinaryOperation;
import ru.otus.java.basic.homeworks.lesson13.parser.element.Element;
import ru.otus.java.basic.homeworks.lesson13.parser.element.Number;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.Queue;

public class Rpn {
    final Queue<Number> values;
    final Queue<BinaryOperation> operations;

    public Rpn(){
        values = new LinkedList<>();
        operations = new LinkedList<>();
    }

    public void add(Element element) {
        if(element instanceof Number){
            values.add((Number) element);
            return;
        }
        if(element instanceof BinaryOperation){
            operations.add((BinaryOperation) element);
        }
    }

    public BigDecimal calculate() {
        BinaryOperation operation;
        Number left;
        Number right;
        Number result;
        while (!operations.isEmpty()){
            operation = operations.remove();
            left = values.remove();
            right = values.remove();
            result = operation.execute(left, right);
            values.add(result);
        }
        return values.remove().getValue();
    }
}
