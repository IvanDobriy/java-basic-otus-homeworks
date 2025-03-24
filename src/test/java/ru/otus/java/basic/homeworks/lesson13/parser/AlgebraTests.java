package ru.otus.java.basic.homeworks.lesson13.parser;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import ru.otus.java.basic.homeworks.lesson13.parser.element.*;
import ru.otus.java.basic.homeworks.lesson13.parser.element.Number;

import java.math.BigDecimal;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AlgebraTests {
    @Test
    void positiveTest() {
        final var algebra = new Algebra("1+2*(3+4)/5-6");
        final var result = algebra.run();
        final var expected = List.of(
                new Number(new BigDecimal("1")),
                new SumOperation(),
                new Number(new BigDecimal("2")),
                new MultiplicationOperation(),
                new LeftBracket(),
                new Number(new BigDecimal("3")),
                new SumOperation(),
                new Number(new BigDecimal("4")),
                new RightBracket(),
                new DivisionOperation(),
                new Number(new BigDecimal("5")),
                new SubtractionOperation(),
                new Number(new BigDecimal("6"))
        );
//        Assertions.assertEquals(expected, result);
    }
}
