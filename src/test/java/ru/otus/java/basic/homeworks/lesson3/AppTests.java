package ru.otus.java.basic.homeworks.lesson3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AppTests {

    @Test
    void sumOfPositiveElementsTest() {
        var elements = new int[][]{{-1, -2, -3}, {1, -1, 0}, {2, -3, -4}};
        final var app = new App(System.out);
        var result = app.sumOfPositiveElements(elements);
        Assertions.assertEquals(3, result);

        elements = new int[][]{{1, -2 - 3}};
        result = app.sumOfPositiveElements(elements);
        Assertions.assertEquals(1, result);

        elements = new int[][]{{1}, {2}, {3}};
        result = app.sumOfPositiveElements(elements);
        Assertions.assertEquals(6, result);

        elements = new int[][]{};
        result = app.sumOfPositiveElements(elements);
        Assertions.assertEquals(0, result);
    }


}
