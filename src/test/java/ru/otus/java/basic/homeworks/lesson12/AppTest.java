package ru.otus.java.basic.homeworks.lesson12;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.io.TempDir;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AppTest {
    private final InputStream initialInput = System.in;
    private final PrintStream initialOut = System.out;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream printStream = new PrintStream(outputStream);

    @BeforeEach
    void beforeEach() {
        outputStream.reset();
        System.setOut(printStream);
    }

    @AfterEach
    void afterEach() {
        System.setIn(initialInput);
        System.setOut(initialOut);
    }

    @Test
    void positiveTest(@TempDir Path dir) throws IOException {
        final var tempFilePath = Files.createTempFile(dir, "", ".txt");
        final var newIn = new ByteArrayInputStream(String.format("%s\nhi\nn\n", tempFilePath.toFile().getName()).getBytes(Charset.defaultCharset()));
        System.setIn(newIn);
        final var fileHandler = new FileHandler(dir.toString());
        final var app = new App(fileHandler);
        app.run();
        Assertions.assertEquals("Files:\n" +
                tempFilePath.toFile().getName() + "\n" +
                "Chose file to work:\n" +
                "File content:\n" +
                "Enter some test: \n", outputStream.toString());
        Assertions.assertEquals("hi", Files.readString(tempFilePath));
    }
}
