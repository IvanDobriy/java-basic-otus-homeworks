package ru.otus.java.basic.homeworks.lesson7;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import ru.otus.java.basic.homeworks.lesson7.transport.Bicycle;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BicycleTests {
    @Test
    void positiveTest() {
        final var bicycle = new Bicycle();
        Assertions.assertEquals(0, bicycle.getEnergy());
        Assertions.assertEquals("ru.otus.java.basic.homeworks.lesson7.transport.Bicycle{currentDriver:null}", bicycle.toString());
    }
}
