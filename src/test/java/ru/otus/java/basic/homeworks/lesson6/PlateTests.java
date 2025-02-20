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
    void removeMealTest() {
        final var plate = new Plate(10);
        var result = plate.removeMeal(1);
        Assertions.assertEquals(1, result);
        Assertions.assertEquals(10, plate.getCapacity());
        Assertions.assertEquals(9, plate.getCurrentAmount());
        result = plate.removeMeal(10);
        Assertions.assertEquals(9, result);
        Assertions.assertEquals(10, plate.getCapacity());
        Assertions.assertEquals(0, plate.getCurrentAmount());
    }

    @Test
    void removeMealNegativeTest() {
        final var plate = new Plate(10);
        final var exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            plate.removeMeal(-1);
        });
        Assertions.assertEquals("amount < 0", exception.getMessage());
    }

    @Test
    void addMealTest() {
        final var plate = new Plate(10);
        plate.addMeal(10);
        Assertions.assertEquals(10, plate.getCapacity());
        Assertions.assertEquals(10, plate.getCurrentAmount());
        plate.removeMeal(10);
        plate.addMeal(1);
        Assertions.assertEquals(10, plate.getCapacity());
        Assertions.assertEquals(1, plate.getCurrentAmount());
    }

    @Test
    void addMealNegativeTest() {
        final var plate = new Plate(10);
        final var exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
           plate.addMeal(-1);
        });
        Assertions.assertEquals("amount < 0", exception.getMessage());
    }

    @Test
    void toStringTest(){
        final var plate = new Plate(10);
        final var expected = "Plate{capacity:10,currentAmount:10}";
        Assertions.assertEquals(expected, plate.toString());
    }
}
