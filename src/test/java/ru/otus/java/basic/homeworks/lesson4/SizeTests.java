package ru.otus.java.basic.homeworks.lesson4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SizeTests {
    @Test
    void smallSizeTest(){
        final var size = Size.SMALL;
        Assertions.assertEquals(100, size.getWidth());
        Assertions.assertEquals(100, size.getHeight());
        Assertions.assertEquals(100, size.getLength());
        Assertions.assertEquals("Small", size.getDescription());
        final var expected = "size width: 100, height: 100, length: 100, description: Small";
        Assertions.assertEquals(expected, size.toString());
    }

    @Test
    void mediumSizeTest(){
        final var size = Size.MEDIUM;
        Assertions.assertEquals(500, size.getWidth());
        Assertions.assertEquals(500, size.getHeight());
        Assertions.assertEquals(500, size.getLength());
        Assertions.assertEquals("Medium", size.getDescription());
        final var expected = "size width: 500, height: 500, length: 500, description: Medium";
        Assertions.assertEquals(expected, size.toString());
    }

    @Test
    void largeTest(){
        final var size = Size.LARGE;
        Assertions.assertEquals(1000, size.getWidth());
        Assertions.assertEquals(1000, size.getHeight());
        Assertions.assertEquals(1000, size.getLength());
        Assertions.assertEquals("Large", size.getDescription());
        final var expected = "size width: 1000, height: 1000, length: 1000, description: Large";
        Assertions.assertEquals(expected, size.toString());
    }
}
