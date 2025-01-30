package ru.otus.java.basic.homeworks.lesson3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AppTests {

    @Test
    void sumOfPositiveElementsTest() {
        final var app = new App(System.out);

        var elements = new int[][]{{-1, -2, -3}, {1, -1, 0}, {2, -3, -4}};
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

    @Test
    void printRectangleTest() {
        final var outputStream = new ByteArrayOutputStream();
        final var printStream = new PrintStream(outputStream);
        final var app = new App(printStream);

        app.printRectangle(0);
        var expected = "";
        var result = outputStream.toString();
        outputStream.reset();
        Assertions.assertEquals(expected, result);

        app.printRectangle(1);
        expected = "*\n";
        result = outputStream.toString();
        outputStream.reset();
        Assertions.assertEquals(expected, result);

        app.printRectangle(2);
        expected = "**\n**\n";
        result = outputStream.toString();
        outputStream.reset();
        Assertions.assertEquals(expected, result);

        app.printRectangle(3);
        expected = "***\n***\n***\n";
        result = outputStream.toString();
        outputStream.reset();
        Assertions.assertEquals(expected, result);

        app.printRectangle(-3);
        expected = "***\n***\n***\n";
        result = outputStream.toString();
        outputStream.reset();
        Assertions.assertEquals(expected, result);
    }

    @Test
    void eyeTest() {
        final var outputStream = new ByteArrayOutputStream();
        final var printStream = new PrintStream(outputStream);
        final var app = new App(printStream);

        var arr = new int[3][3];
        app.eye(arr, 1);
        var expected = new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
        Assertions.assertArrayEquals(expected, arr);

        arr = new int[3][3];
        app.eye(arr, 5);
        expected = new int[][]{{5, 0, 0}, {0, 5, 0}, {0, 0, 5}};
        Assertions.assertArrayEquals(expected, arr);


        arr = new int[2][2];
        app.eye(arr, 1);
        expected = new int[][]{{1, 0}, {0, 1}};
        Assertions.assertArrayEquals(expected, arr);

        arr = new int[2][3];
        app.eye(arr, 1);
        expected = new int[][]{{1, 0, 0}, {0, 1, 0}};
        Assertions.assertArrayEquals(expected, arr);

        arr = new int[1][1];
        app.eye(arr, 1);
        expected = new int[][]{{1}};
        Assertions.assertArrayEquals(expected, arr);
    }
}
