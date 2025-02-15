package ru.otus.java.basic.homeworks.lesson4;

import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.Charset;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UserTests {
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
    void positiveTest() {
        final var user = new User(
                "Danilchenko",
                "Ivan",
                "Sergeevich",
                1990,
                "dobrogovremeny@gmail.com");
        Assertions.assertEquals("Danilchenko", user.getSurname());
        Assertions.assertEquals("Ivan", user.getName());
        Assertions.assertEquals("Sergeevich", user.getPatronymic());
        Assertions.assertEquals(1990, user.getYearOfBirthDate());
        Assertions.assertEquals("dobrogovremeny@gmail.com", user.getEmail());

        user.printUserInfo();
        final var expected = "ФИО: Ivan Danilchenko Sergeevich\nГод рождения: 1990\ne-mail: dobrogovremeny@gmail.com\n";
        final var result = outputStream.toString(Charset.defaultCharset());
        Assertions.assertEquals(expected, result);
    }
}
