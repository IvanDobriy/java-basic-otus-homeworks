package ru.otus.java.basic.homeworks.lesson13.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import ru.otus.java.basic.homeworks.lesson13.parser.MathConverter;
import ru.otus.java.basic.homeworks.lesson13.parser.RpnConverter;

import java.math.BigDecimal;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MathCalculatorTests {
    @Test
    void positiveTest() {
        final var calculator = new MathCalculator(new MathConverter(), new RpnConverter());
        final var result = calculator.calculate("1 + 2*(3+4)/5 - 6");
        Assertions.assertEquals(new BigDecimal("-2.2"), result);
    }

    @Test
    void negativeTest() {
        final var exception = Assertions.assertThrows(RuntimeException.class, () -> {
            final var calculator = new MathCalculator(new MathConverter(), new RpnConverter());
            calculator.calculate("((1+2)(3+4))");
        });
    }
}
