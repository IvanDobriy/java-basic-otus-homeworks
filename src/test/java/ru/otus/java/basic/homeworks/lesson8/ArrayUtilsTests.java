package ru.otus.java.basic.homeworks.lesson8;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ArrayUtilsTests {
    @Test
    void positiveTest() throws AppArrayDataException {
        String[][] data = {
                {"1", "2 ", " 3", "  4  "},
                {"1", "2 ", " 3", "  4  "},
                {"1", "2 ", " 3", "  4  "},
                {"1", "2 ", " 3", "  4  "}
        };
        int result = ArrayUtils.sum(data);
        Assertions.assertEquals(40, result);

    }
}
