package ru.otus.java.basic.homeworks.lesson1;


import jdk.jfr.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.Charset;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AppTests {
    class Arguments {
        final int a;
        final int b;
        final int c;

        Arguments(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        int getA() {
            return a;
        }

        int getB() {
            return b;
        }

        int getC() {
            return c;
        }

    }

    @Test
    void greetingsTest() {
        final var outputStream = new ByteArrayOutputStream();
        final var printStream = new PrintStream(outputStream);
        final var app = App.build(printStream);
        app.greetings();
        final var result = outputStream.toByteArray();
        final var expected = "Hello\nWorld\nfrom\nJava\n".getBytes(Charset.defaultCharset());
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    void checkSignTestResultMoreOrEquals0() {
        final var outputStream = new ByteArrayOutputStream();
        final var printStream = new PrintStream(outputStream);
        final var app = App.build(printStream);
        final var testsData = new Arguments[]{
                new Arguments(0, 0, 0),
                new Arguments(0, 1, 0),
                new Arguments(0, 0, 1),
                new Arguments(0, 1, 1),
                new Arguments(1, 0, 0),
                new Arguments(1, 1, 0),
                new Arguments(1, 0, 1),
                new Arguments(1, 1, 1)
        };
        for (final Arguments arguments : testsData) {
            Assertions.assertAll(() -> {
                app.checkSign(arguments.getA(), arguments.getB(), arguments.getC());
                final var result = outputStream.toByteArray();
                final var expected = "Сумма положительная\n".getBytes(Charset.defaultCharset());
                outputStream.reset();
                Assertions.assertArrayEquals(expected, result);
            });
        }
    }

    @Test
    void checkSignTestResultLessWhen0() {
        final var outputStream = new ByteArrayOutputStream();
        final var printStream = new PrintStream(outputStream);
        final var app = App.build(printStream);
        final var testsData = new Arguments[]{
                new Arguments(0, -1, 0),
                new Arguments(0, 0, -1),
                new Arguments(0, -1, -1),
                new Arguments(-1, 0, 0),
                new Arguments(-1, -1, 0),
                new Arguments(-1, 0, -1),
                new Arguments(-1, -1, -1)
        };
        for (final Arguments arguments : testsData) {
            Assertions.assertAll(() -> {
                app.checkSign(arguments.getA(), arguments.getB(), arguments.getC());
                final var result = outputStream.toByteArray();
                final var expected = "Сумма отрицательная\n".getBytes(Charset.defaultCharset());
                outputStream.reset();
                Assertions.assertArrayEquals(expected, result);
            });
        }
    }
}
