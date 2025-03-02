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

}
