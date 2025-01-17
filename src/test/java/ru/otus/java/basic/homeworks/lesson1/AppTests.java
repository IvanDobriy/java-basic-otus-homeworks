package ru.otus.java.basic.homeworks.lesson1;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.Charset;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AppTests {
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
}
