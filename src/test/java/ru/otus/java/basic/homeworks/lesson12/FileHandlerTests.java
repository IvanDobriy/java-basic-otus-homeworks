package ru.otus.java.basic.homeworks.lesson12;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.io.TempDir;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class FileHandlerTests {
    private final InputStream initalInput = System.in;
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
        System.setIn(initalInput);
        System.setOut(initialOut);
    }

    @Test
    void creationTest(@TempDir Path dir) throws IOException {
        new FileHandler(dir.toString());
        Assertions.assertThrows(NullPointerException.class, () -> {
            new FileHandler(null);
        });
        Assertions.assertThrows(RuntimeException.class, () -> {
            new FileHandler(dir.resolve("./text.txt").toString());
        });
    }

    @Test
    void getTextFilesTest(@TempDir Path dir) throws IOException {
        final var tempFilePath = Files.createTempFile(dir, "", ".txt");
        Files.createTempFile(dir, "", "");
        final var handler = new FileHandler(dir.toString());
        final var files = handler.getTextFiles();
        Assertions.assertEquals(List.of(tempFilePath.toFile()), files);
    }

    @Test
    void printFileListFilesExistsTest(@TempDir Path dir) throws IOException {
        final var files = List.of(new File("f1"), new File("f2"), new File("f3"));
        final var handler = new FileHandler(dir.toString());
        handler.printFileList(files);
        Assertions.assertEquals("Files:\nf1\nf2\nf3\n", outputStream.toString());
    }

    @Test
    void printFileListFileListIsEmptyTest(@TempDir Path dir) {
        final var files = List.<File>of();
        final var handler = new FileHandler(dir.toString());
        handler.printFileList(files);
        Assertions.assertEquals("Text files not found\n", outputStream.toString());
    }

    @Test
    void selectFileTest(@TempDir Path dir) {
        final var expectedFile = new File("f1");
        final var newIn = new ByteArrayInputStream(expectedFile.getName().getBytes(Charset.defaultCharset()));
        System.setIn(newIn);
        final var handler = new FileHandler(dir.toString());

        final var files = List.of(expectedFile, new File("f2"), new File("f3"));
        final var file = handler.selectFile(files);
        Assertions.assertEquals("Chose file to work:\n", outputStream.toString());
        Assertions.assertEquals(expectedFile, file);
    }

    @Test
    void printFileContentTest(@TempDir Path dir) throws IOException {
        final var tempFilePath = Files.createTempFile(dir, "", ".txt");
        Files.createTempFile(dir, "", "");
        Files.write(tempFilePath, "hello, world".getBytes(Charset.defaultCharset()));
        final var handler = new FileHandler(dir.toString());
        handler.printFileContent(tempFilePath.toFile());
        Assertions.assertEquals("File content:\nhello, world\n", outputStream.toString());
    }

    @Test
    void enterTextTest(@TempDir Path dir) throws IOException {
        final var expectedString = "123";
        final var newIn = new ByteArrayInputStream(expectedString.getBytes(Charset.defaultCharset()));
        System.setIn(newIn);
        final var tempFilePath = Files.createTempFile(dir, "", ".txt");
        Files.createTempFile(dir, "", "");
        final var handler = new FileHandler(dir.toString());
        handler.enterText(tempFilePath.toFile());
        Assertions.assertEquals(expectedString, Files.readString(tempFilePath));
    }

    @Test
    void needContinueTest(@TempDir Path dir) throws IOException {
        var newIn = new ByteArrayInputStream("y".getBytes(Charset.defaultCharset()));
        System.setIn(newIn);
        final var handler = new FileHandler(dir.toString());
        var result = handler.needContinue();
        Assertions.assertTrue(result);
    }

    @Test
    void needContinueNegativeTest(@TempDir Path dir) {
        var newIn = new ByteArrayInputStream("n".getBytes(Charset.defaultCharset()));
        System.setIn(newIn);
        final var handler = new FileHandler(dir.toString());
        var result = handler.needContinue();
        Assertions.assertFalse(result);
    }
}
