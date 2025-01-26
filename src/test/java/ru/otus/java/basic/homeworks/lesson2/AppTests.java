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

    @Test
    void addTest() {
        final var outputStream = new ByteArrayOutputStream();
        final var printStream = new PrintStream(outputStream);
        final var app = App.build(printStream);

        var data = new int[]{1, 2, 3};
        var expected = new int[]{1, 2, 3};
        app.add(0, data);
        Assertions.assertArrayEquals(expected, data);

        data = new int[]{1, 2, 3};
        expected = new int[]{2, 3, 4};
        app.add(1, data);
        Assertions.assertArrayEquals(expected, data);
    }

    @Test
    void largestPartSumTest() {
        final var outputStream = new ByteArrayOutputStream();
        final var printStream = new PrintStream(outputStream);
        final var app = App.build(printStream);

        var data = new int[]{1, 2, 3, 4};
        app.largestPartSum(data);
        var result = outputStream.toString();
        outputStream.reset();
        var expected = "7\n";
        Assertions.assertEquals(expected, result);

        data = new int[]{4, 3, 2, 1};
        app.largestPartSum(data);
        result = outputStream.toString();
        outputStream.reset();
        expected = "7\n";
        Assertions.assertEquals(expected, result);

        data = new int[]{1, 2, 10, 3, 5};
        app.largestPartSum(data);
        result = outputStream.toString();
        outputStream.reset();
        expected = "8\n";
        Assertions.assertEquals(expected, result);

        data = new int[]{3, 5, 10, 1, 2};
        app.largestPartSum(data);
        result = outputStream.toString();
        outputStream.reset();
        expected = "8\n";
        Assertions.assertEquals(expected, result);

        data = new int[]{-1, -2, 10, 3, -6};
        app.largestPartSum(data);
        result = outputStream.toString();
        outputStream.reset();
        expected = "-3\n";
        Assertions.assertEquals(expected, result);

        data = new int[0];
        app.largestPartSum(data);
        result = outputStream.toString();
        outputStream.reset();
        expected = "\n";
        Assertions.assertEquals(expected, result);
    }

    @Test
    void arraysAddTest() {
        final var outputStream = new ByteArrayOutputStream();
        final var printStream = new PrintStream(outputStream);
        final var app = App.build(printStream);

        var result = app.arraysAdd(new int[]{1, 2}, new int[]{1, 2, 3, 4}, new int[]{1, 2, 3, 4, 5});
        var expected = new int[]{3, 6, 6, 8, 5};
        Assertions.assertArrayEquals(expected, result);

        result = app.arraysAdd();
        expected = new int[0];
        Assertions.assertArrayEquals(expected, result);

        result = app.arraysAdd(new int[]{1, 2});
        expected = new int[]{1, 2};
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    void findPointTest() {
        final var outputStream = new ByteArrayOutputStream();
        final var printStream = new PrintStream(outputStream);
        final var app = App.build(printStream);

        var result = app.findPoint(new int[]{1, 1, 1, 1});
        var expected = 2;
        Assertions.assertEquals(expected, result);

        result = app.findPoint(new int[]{3, 1, 1, 1});
        expected = 1;
        Assertions.assertEquals(expected, result);

        result = app.findPoint(new int[]{1, 2, 1, 4});
        expected = 3;
        Assertions.assertEquals(expected, result);

        result = app.findPoint(new int[]{-1, 1, 1, -1});
        expected = 2;
        Assertions.assertEquals(expected, result);

        result = app.findPoint(new int[]{1, 3});
        expected = -1;
        Assertions.assertEquals(expected, result);

        result = app.findPoint(new int[]{1, 3, 5});
        expected = -1;
        Assertions.assertEquals(expected, result);

    }
}
