package ru.otus.java.basic.homeworks.lesson13.parser;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.math.BigDecimal;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MathParserTests {
    @Test
    void positiveTest() {
        final var parser = new MathParser();
        final var rpn = parser.parse("1+2*(3+4)/5-6");
        final var result = rpn.calculate();
        Assertions.assertEquals(new BigDecimal("-2.2"), result);
    }
}
