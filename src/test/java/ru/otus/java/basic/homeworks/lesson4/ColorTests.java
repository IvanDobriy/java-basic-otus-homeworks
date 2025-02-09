package ru.otus.java.basic.homeworks.lesson4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ColorTests {
    @Test
    void blackTest(){
        final var color = Color.BLACK;
        Assertions.assertEquals(0, color.getCode());
        Assertions.assertEquals("Black", color.getName());
        Assertions.assertEquals("color name: Black, code: 0", color.toString());
    }

    @Test
    void whiteTest(){
        final var color = Color.WHITE;
        Assertions.assertEquals(1, color.getCode());
        Assertions.assertEquals("White", color.getName());
        Assertions.assertEquals("color name: White, code: 1", color.toString());
    }
}
