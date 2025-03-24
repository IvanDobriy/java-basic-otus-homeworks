package ru.otus.java.basic.homeworks.lesson13.parser;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.math.BigDecimal;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class RpnCalculatorTests {
    @Test
    void simpleTest() {
        //1 + 2*(3+4)/5 - 6
//        final var rpn = new RpnConverter(new MathConverter());
//        final var result = rpn.calculate("1 + 2*(3+4)/5 - 6");
//        Assertions.assertEquals(new BigDecimal("-2.2"), result);
    }
}
