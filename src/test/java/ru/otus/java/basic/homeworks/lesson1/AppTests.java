package ru.otus.java.basic.homeworks.lesson1;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.io.*;
import java.nio.charset.Charset;
import java.util.logging.Logger;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AppTests {
    private Logger logger = Logger.getLogger(this.getClass().getName());

    class Arguments {
        final int[] args;

        Arguments(int... anArgs) {
            args = anArgs;
        }

        int getArgument(int position) {
            return args[position];
        }
    }

    int defaultRandomGenerator() {
        return 1;
    }

    @Test
    void greetingsTest() {
        final var outputStream = new ByteArrayOutputStream();
        final var printStream = new PrintStream(outputStream);
        final var app = App.build(System.in, printStream, this::defaultRandomGenerator);
        app.greetings();
        final var result = outputStream.toByteArray();
        final var expected = "Hello\nWorld\nfrom\nJava\n".getBytes(Charset.defaultCharset());
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    void checkSignTestResultMoreOrEquals0() {
        final var outputStream = new ByteArrayOutputStream();
        final var printStream = new PrintStream(outputStream);
        final var app = App.build(System.in, printStream, this::defaultRandomGenerator);
        final var testsData = new Arguments[]{new Arguments(0, 0, 0), new Arguments(0, 1, 0), new Arguments(0, 0, 1), new Arguments(0, 1, 1), new Arguments(1, 0, 0), new Arguments(1, 1, 0), new Arguments(1, 0, 1), new Arguments(1, 1, 1)};
        for (final Arguments arguments : testsData) {
            Assertions.assertAll(() -> {
                app.checkSign(arguments.getArgument(0), arguments.getArgument(1), arguments.getArgument(2));
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
        final var app = App.build(System.in, printStream, this::defaultRandomGenerator);
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
                app.checkSign(arguments.getArgument(0), arguments.getArgument(1), arguments.getArgument(2));
                final var result = outputStream.toByteArray();
                final var expected = "Сумма отрицательная\n".getBytes(Charset.defaultCharset());
                outputStream.reset();
                Assertions.assertArrayEquals(expected, result);
            });
        }
    }

    @Test
    void selectColorTestRed() {
        final var outputStream = new ByteArrayOutputStream();
        final var printStream = new PrintStream(outputStream);
        final var app = App.build(System.in, printStream, this::defaultRandomGenerator);
        final var testsData = new Arguments[]{
                new Arguments(-1),
                new Arguments(0),
                new Arguments(1),
                new Arguments(5),
                new Arguments(10),
        };
        for (final Arguments arguments : testsData) {
            Assertions.assertAll(() -> {
                app.selectColor(arguments.getArgument(0));
                final var result = outputStream.toByteArray();
                final var expected = "Красный\n".getBytes(Charset.defaultCharset());
                outputStream.reset();
                Assertions.assertArrayEquals(expected, result);
            });
        }
    }

    @Test
    void selectColorTestYellow() {
        final var outputStream = new ByteArrayOutputStream();
        final var printStream = new PrintStream(outputStream);
        final var app = App.build(System.in, printStream, this::defaultRandomGenerator);
        final var testsData = new Arguments[]{
                new Arguments(11),
                new Arguments(12),
                new Arguments(15),
                new Arguments(19),
                new Arguments(20),
        };
        for (final Arguments arguments : testsData) {
            Assertions.assertAll(() -> {
                app.selectColor(arguments.getArgument(0));
                final var result = outputStream.toByteArray();
                final var expected = "Желтый\n".getBytes(Charset.defaultCharset());
                outputStream.reset();
                Assertions.assertArrayEquals(expected, result);
            });
        }
    }

    @Test
    void selectColorTestGreen() {
        final var outputStream = new ByteArrayOutputStream();
        final var printStream = new PrintStream(outputStream);
        final var app = App.build(System.in, printStream, this::defaultRandomGenerator);
        final var testsData = new Arguments[]{
                new Arguments(21),
                new Arguments(22),
                new Arguments(30),
                new Arguments(40),
                new Arguments(1000),
        };
        for (final Arguments arguments : testsData) {
            Assertions.assertAll(() -> {
                app.selectColor(arguments.getArgument(0));
                final var result = outputStream.toByteArray();
                final var expected = "Зеленый\n".getBytes(Charset.defaultCharset());
                outputStream.reset();
                Assertions.assertArrayEquals(expected, result);
            });
        }
    }

    @Test
    void compareNumbersTestParameterAMoreOrEqualsParameterB() {
        final var outputStream = new ByteArrayOutputStream();
        final var printStream = new PrintStream(outputStream);
        final var app = App.build(System.in, printStream, this::defaultRandomGenerator);
        final var testsData = new Arguments[]{
                new Arguments(-1, -2),
                new Arguments(1, 0),
                new Arguments(5, 5),
                new Arguments(10, 2)
        };
        for (final Arguments arguments : testsData) {
            Assertions.assertAll(() -> {
                app.compareNumbers(arguments.getArgument(0), arguments.getArgument(1));
                final var result = outputStream.toByteArray();
                final var expected = "a >= b\n".getBytes(Charset.defaultCharset());
                outputStream.reset();
                Assertions.assertArrayEquals(expected, result);
            });
        }
    }

    @Test
    void compareNumbersTestParameterALessWhenB() {
        final var outputStream = new ByteArrayOutputStream();
        final var printStream = new PrintStream(outputStream);
        final var app = App.build(System.in, printStream, this::defaultRandomGenerator);
        final var testsData = new Arguments[]{
                new Arguments(-2, -1),
                new Arguments(0, 1),
                new Arguments(2, 10)
        };
        for (final Arguments arguments : testsData) {
            Assertions.assertAll(() -> {
                app.compareNumbers(arguments.getArgument(0), arguments.getArgument(1));
                final var result = outputStream.toByteArray();
                final var expected = "a < b\n".getBytes(Charset.defaultCharset());
                outputStream.reset();
                Assertions.assertArrayEquals(expected, result);
            });
        }
    }

    @Test
    void addOrSubtractAndPrintTestIncrementIsTrue() {
        final var outputStream = new ByteArrayOutputStream();
        final var printStream = new PrintStream(outputStream);
        final var app = App.build(System.in, printStream, this::defaultRandomGenerator);
        final var testsData = new Arguments[]{
                new Arguments(-2, -1),
                new Arguments(0, 1),
                new Arguments(2, 10)
        };
        for (final Arguments arguments : testsData) {
            Assertions.assertAll(() -> {
                final int arg0 = arguments.getArgument(0);
                final int arg1 = arguments.getArgument(1);
                app.addOrSubtractAndPrint(arg0, arg1, true);
                final var result = outputStream.toByteArray();
                final var expected = String.format("%d\n", arg0 + arg1).getBytes(Charset.defaultCharset());
                outputStream.reset();
                Assertions.assertArrayEquals(expected, result);
            });
        }
    }

    @Test
    void addOrSubtractAndPrintTestIncrementIsFalse() {
        final var outputStream = new ByteArrayOutputStream();
        final var printStream = new PrintStream(outputStream);
        final var app = App.build(System.in, printStream, this::defaultRandomGenerator);
        final var testsData = new Arguments[]{
                new Arguments(-2, -1),
                new Arguments(0, 1),
                new Arguments(2, 10)
        };
        for (final Arguments arguments : testsData) {
            Assertions.assertAll(() -> {
                final int arg0 = arguments.getArgument(0);
                final int arg1 = arguments.getArgument(1);
                app.addOrSubtractAndPrint(arg0, arg1, false);
                final var result = outputStream.toByteArray();
                final var expected = String.format("%d\n", arg0 - arg1).getBytes(Charset.defaultCharset());
                outputStream.reset();
                Assertions.assertArrayEquals(expected, result);
            });
        }
    }

    @Test
    void runMenuTest() {
        final var outputStream = new ByteArrayOutputStream();
        final var printStream = new PrintStream(outputStream);
        final var inputData = "1\n2\n3\n4\n5\n".getBytes(Charset.defaultCharset());
        final var inputStream = new ByteArrayInputStream(inputData);
        final var app = App.build(inputStream, printStream, this::defaultRandomGenerator);
        final var expectedPrefix = "Введите число от 1 до 5\n";

        var expected = (expectedPrefix + "Hello\nWorld\nfrom\nJava\n").getBytes(Charset.defaultCharset());
        app.runMenu();
        Assertions.assertArrayEquals(expected, outputStream.toByteArray());

        outputStream.reset();
        expected = (expectedPrefix + "Сумма положительная\n").getBytes(Charset.defaultCharset());
        app.runMenu();
        Assertions.assertArrayEquals(expected, outputStream.toByteArray());

        outputStream.reset();
        expected = (expectedPrefix + "Красный\n").getBytes(Charset.defaultCharset());
        app.runMenu();
        Assertions.assertArrayEquals(expected, outputStream.toByteArray());


        outputStream.reset();
        expected = (expectedPrefix + "a >= b\n").getBytes(Charset.defaultCharset());
        app.runMenu();
        Assertions.assertArrayEquals(expected, outputStream.toByteArray());

        outputStream.reset();
        expected = (expectedPrefix + "0\n").getBytes(Charset.defaultCharset());
        app.runMenu();
        logger.info(outputStream.toString());
        Assertions.assertArrayEquals(expected, outputStream.toByteArray());
    }

}
