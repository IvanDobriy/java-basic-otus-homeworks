package ru.otus.java.basic.homeworks.lesson20;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FinderTests {

    @Test
    void positiveTest(@TempDir Path tempDir) throws IOException {
        Path path = tempDir.resolve("test.txt");
        Files.write(path, "aa bb cc aa a bc acaa".getBytes(StandardCharsets.UTF_8));
        final var finder = new Finder();
        final var result = finder.count(path, "aa".toCharArray());
        Assertions.assertEquals(3, result);
    }

    @Test
    void sequenceNotFoundTest(@TempDir Path tempDir) throws IOException {
        Path path = tempDir.resolve("test.txt");
        Files.write(path, "aa bb cc aa a bc acaa".getBytes(StandardCharsets.UTF_8));
        final var finder = new Finder();
        final var result = finder.count(path, "dd".toCharArray());
        Assertions.assertEquals(0, result);
    }

    @Test
    void fileIsEmptyFoundTest(@TempDir Path tempDir) throws IOException {
        Path path = tempDir.resolve("test.txt");
        Files.write(path, "".getBytes(StandardCharsets.UTF_8));
        final var finder = new Finder();
        final var result = finder.count(path, "aa".toCharArray());
        Assertions.assertEquals(0, result);
    }
}
