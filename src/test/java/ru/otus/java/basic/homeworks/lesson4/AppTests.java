package ru.otus.java.basic.homeworks.lesson4;

import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AppTests {
    private final PrintStream initialOut = System.out;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream printStream = new PrintStream(outputStream);

    @BeforeEach
    void beforeEach() {
        System.setOut(printStream);
    }

    @AfterEach
    void afterEach() {
        outputStream.reset();
        System.setOut(initialOut);
    }

    @Test
    void mainTest() {
        App.main(new String[]{});
        final var expected = "ФИО: Petr Chugunov Ivanovich\nГод рождения: 1980\ne-mail: chugunov@mail.com\n"
                + "ФИО: Ivan Ivanov Vasilievich\nГод рождения: 1970\ne-mail: ivanov@mail.com\n";
        final var result = outputStream.toString();
        Assertions.assertEquals(expected, result);
    }
}
