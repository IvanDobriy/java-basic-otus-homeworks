package ru.otus.java.basic.homeworks.lesson6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PlateTests {
    @Test
    void creationTest() {
        final var plate = new Plate(10);
        Assertions.assertEquals(10, plate.getCapacity());
        Assertions.assertEquals(10, plate.getCurrentAmount());
    }

    @Test
    void badCapacityTest() {
        final var exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Plate(-1);
        });
        Assertions.assertEquals("capacity < 0", exception.getMessage());
    }

    @Test
    void removeContentTest() {
        final var plate = new Plate(10);
        var result = plate.removeContent(1);
        Assertions.assertEquals(1, result);
        Assertions.assertEquals(10, plate.getCapacity());
        Assertions.assertEquals(9, plate.getCurrentAmount());
        result = plate.removeContent(10);
        Assertions.assertEquals(9, result);
        Assertions.assertEquals(10, plate.getCapacity());
        Assertions.assertEquals(0, plate.getCurrentAmount());
    }

    @Test
    void removeContentNegativeTest() {
        final var plate = new Plate(10);
        final var exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            plate.removeContent(-1);
        });
        Assertions.assertEquals("amount < 0", exception.getMessage());
    }

    @Test
    void addContentTest() {
        final var plate = new Plate(10);
        plate.addContent(10);
        Assertions.assertEquals(10, plate.getCapacity());
        Assertions.assertEquals(10, plate.getCurrentAmount());
        plate.removeContent(10);
        plate.addContent(1);
        Assertions.assertEquals(10, plate.getCapacity());
        Assertions.assertEquals(1, plate.getCurrentAmount());
    }

    @Test
    void addContentNegativeTest() {
        final var plate = new Plate(10);
        final var exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
           plate.addContent(-1);
        });
        Assertions.assertEquals("amount < 0", exception.getMessage());
    }
}
