package ru.otus.java.basic.homeworks.lesson13.parser;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import ru.otus.java.basic.homeworks.lesson13.parser.element.*;
import ru.otus.java.basic.homeworks.lesson13.parser.element.Number;

import java.math.BigDecimal;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class RpnTests {
    @Test
    void simpleTest() {
        //1234+*5/+6-
        //1 + 2*(3+4)/5 - 6
        final var list = List.of(new Number(new BigDecimal(1)),
                new SumOperation(),
                new Number(new BigDecimal(2)),
                new MultiplicationOperation(),
                new LeftBracket(),
                new Number(new BigDecimal(3)),
                new SumOperation(),
                new Number(new BigDecimal(4)),
                new RightBracket(),
                new DivisionOperation(),
                new Number(new BigDecimal(5)),
                new SubtractionOperation(),
                new Number(new BigDecimal(6))
        );
        final var rpn = new Rpn(list);
        final var result = rpn.calculate();
        Assertions.assertEquals(new BigDecimal("-2.2"), result);
    }
}
