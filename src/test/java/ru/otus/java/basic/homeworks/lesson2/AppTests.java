package ru.otus.java.basic.homeworks.lesson2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AppTests {
    @Test
    void printStringTests() {
        final var outputStream = new ByteArrayOutputStream();
        final var printStream = new PrintStream(outputStream);
        final var app = App.build(printStream);

        app.printString(0, "0");
        var result = outputStream.toString();
        var expected = "\n";
        outputStream.reset();
        Assertions.assertEquals(expected, result);

        app.printString(1, "1");
        result = outputStream.toString();
        expected = "1\n";
        outputStream.reset();
        Assertions.assertEquals(expected, result);

        app.printString(2, "2");
        result = outputStream.toString();
        expected = "22\n";
        outputStream.reset();
        Assertions.assertEquals(expected, result);

        app.printString(-1, "-1");
        result = outputStream.toString();
        expected = "\n";
        outputStream.reset();
        Assertions.assertEquals(expected, result);
    }

    @Test
    void sumTest() {
        final var outputStream = new ByteArrayOutputStream();
        final var printStream = new PrintStream(outputStream);
        final var app = App.build(printStream);

        var data = new int[]{-1, -2, 0, 1, 2, 3, 4, 5};
        app.sum(data);
        var result = outputStream.toString();
        var expected = "0\n";
        outputStream.reset();
        Assertions.assertEquals(expected, result);

        data = new int[]{6, 7, 8, 9};
        app.sum(data);
        expected = "30\n";
        result = outputStream.toString();
        Assertions.assertEquals(expected, result);
    }

    @Test
    void fillTest() {
        final var outputStream = new ByteArrayOutputStream();
        final var printStream = new PrintStream(outputStream);
        final var app = App.build(printStream);

        var result = new int[3];
        var expected = new int[]{1, 1, 1};
        app.fill(1, result);
        Assertions.assertArrayEquals(expected, result);
        result = new int[3];
        expected = new int[]{2, 2, 2};
        app.fill(2, result);
        Assertions.assertArrayEquals(expected, result);
    }
}
