package ru.otus.java.basic.homeworks.lesson8;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ArrayUtilsTests {
    @Test
    void positiveTest() throws AppArrayDataException {
        final String[][] data = {
                {"1", "2 ", " 3", "  4  "},
                {"1", "2 ", " 3", "  4  "},
                {"1", "2 ", " 3", "  4  "},
                {"1", "2 ", " 3", "  4  "}
        };
        int result = ArrayUtils.sum(data);
        Assertions.assertEquals(40, result);
    }

    @Test
    void unexpectedRowLength() {
        final String[][] data = {
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
        };
        final var exception = Assertions.assertThrows(AppArraySizeException.class, () -> {
            ArrayUtils.sum(data);
        });
        final String[][] expected = {
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
        };
        Assertions.assertEquals("arr must be 4x4", exception.getMessage());
        Assertions.assertArrayEquals(expected, exception.getArr());
    }

    @Test
    void unexpectedColLength() {
        final String[][] data = {
                {"1", "2", "3", "4"},
                {"1", "2", "3"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"}
        };

        final var exception = Assertions.assertThrows(AppArraySizeException.class, () -> {
            ArrayUtils.sum(data);
        });
        final String[][] expected = {
                {"1", "2", "3", "4"},
                {"1", "2", "3"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"}
        };
        Assertions.assertEquals("arr must be 4x4", exception.getMessage());
        Assertions.assertArrayEquals(expected, exception.getArr());
    }

    @Test
    void dataIsSomeStringTest() {
        final String[][] data = {
                {"1", "Hello, world!!!", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
        };
        final var exception = Assertions.assertThrows(AppArrayDataException.class, () -> {
            ArrayUtils.sum(data);
        });
        final String[][] expected = {
                {"1", "Hello, world!!!", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
        };
        Assertions.assertEquals("Can`t parse el:'Hello, world!!!' to int for [0, 1] element", exception.getMessage());
        Assertions.assertArrayEquals(expected, data);
        Assertions.assertEquals(0, exception.getRow());
        Assertions.assertEquals(1, exception.getCol());
        Assertions.assertEquals("Hello, world!!!", exception.getValue());
    }

    @Test
    void dataIsFloat() {
        final String[][] data = {
                {"1", "2", "3.0", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
        };
        Assertions.assertThrows(AppArrayDataException.class, () -> {
            ArrayUtils.sum(data);
        });
    }
}
