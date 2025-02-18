package ru.otus.java.basic.homeworks.lesson7;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import ru.otus.java.basic.homeworks.lesson7.driver.Human;
import ru.otus.java.basic.homeworks.lesson7.transport.Bicycle;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BicycleTests {

    @Test
    void positiveTest() {
        final var bicycle = new Bicycle();
        Assertions.assertEquals(0, bicycle.getEnergy());
        Assertions.assertEquals("ru.otus.java.basic.homeworks.lesson7.transport.Bicycle{currentDriver:null}", bicycle.toString());
    }

    @Test
    void toStringTest() {
        final var human = new Human("Ivan", 10);
        final var bicycle = new Bicycle();
        bicycle.place(human);
        Assertions.assertEquals("ru.otus.java.basic.homeworks.lesson7.transport.Bicycle{currentDriver:Ivan}", bicycle.toString());
    }

    @Test
    void placeRemoveTests() {
        final var human = new Human("Ivan", 10);
        final var bicycle = new Bicycle();
        bicycle.place(human);
        Assertions.assertEquals(human, bicycle.getDriver());
        Assertions.assertEquals(bicycle, human.getTransport());
        final var driver = bicycle.remove();
        Assertions.assertEquals(human, driver);
        Assertions.assertNull(bicycle.getDriver());
        Assertions.assertNull(human.getTransport());
    }

    @Test
    void placeDriverIsNull() {
        final var bicycle = new Bicycle();
        Assertions.assertThrows(NullPointerException.class, () -> {
           bicycle.place(null);
        });
    }

    @Test
    void removeDriverIsNull() {
        final var bicycle = new Bicycle();
        Assertions.assertNull(bicycle.remove());
    }
}
