package ru.otus.java.basic.homeworks.lesson9;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import ru.otus.java.basic.homeworks.lesson9.exceptions.RangeCreationException;

import java.util.Arrays;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AppTests {
    @Test
    void rangeTest() {
        var result = App.range(0, 3);
        Assertions.assertEquals(List.of(0, 1, 2, 3), result);
        result = App.range(-3, 0);
        Assertions.assertEquals(List.of(-3, -2, -1, 0), result);
        result = App.range(-1, -1);
        Assertions.assertEquals(List.of(-1), result);
        final var exception = Assertions.assertThrows(RangeCreationException.class, () -> {
            App.range(0, -1);
        });
        Assertions.assertEquals("Can`t create range with current parameters: [min: 0, max: -1]", exception.getMessage());
        Assertions.assertEquals(0, exception.getMin());
        Assertions.assertEquals(-1, exception.getMax());
    }

    @Test
    void sumTest() {
        var result = App.sum(List.of(1, 5, 7, 10));
        Assertions.assertEquals(17, result);
        result = App.sum(List.of());
        Assertions.assertEquals(0, result);
    }

    @Test
    void fillTest() {
        final var data = Arrays.asList(1, 2, 3);
        App.fill(10, data);
        Assertions.assertEquals(List.of(10, 10, 10), data);
    }

    @Test
    void incrementTest() {
        final var data = Arrays.asList(1, 2, 3);
        App.increment(10, data);
        Assertions.assertEquals(List.of(11, 12, 13), data);
    }

    @Test
    void getNamesTest() {
        final var result = App.getNames(List.of(new Employee("Ivan", 34), new Employee("John", 12)));
        Assertions.assertEquals(List.of("Ivan", "John"), result);
    }

    @Test
    void teamIsOldTest() {
        var result = App.teamIsOld(10, List.of(new Employee("Ivan", 6), new Employee("John", 6)));
        Assertions.assertFalse(result);
        result = App.teamIsOld(10, List.of(new Employee("Ivan", 16), new Employee("John", 16)));
        Assertions.assertTrue(result);
        var exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            App.teamIsOld(10, List.of());
        });
        Assertions.assertEquals("Team list is empty", exception.getMessage());

        exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            App.teamIsOld(-10, List.of(new Employee("Ivan", 10)));
        });
        Assertions.assertEquals("middle age < 0", exception.getMessage());
    }

    @Test
    void getYoungestTest() {
        final var employees = List.of(new Employee("Ivan", 16), new Employee("John", 6));
        final var result = App.getYoungest(employees);
        Assertions.assertEquals(employees.get(1), result);
        final var exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            App.getYoungest(List.of());
        });
        Assertions.assertEquals("Employee list is empty", exception.getMessage());
    }


}
