package ru.otus.java.basic.homeworks.lesson2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.function.Executable;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

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
}
