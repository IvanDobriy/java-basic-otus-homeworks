package ru.otus.java.basic.homeworks.lesson22;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ArrayUtilsTests {
    @ParameterizedTest()
    @MethodSource("getArrData")
    void lastAfter1Test(int[] arr, int[] expected, Class<Exception> exception) {
        if (exception != null) {
            Assertions.assertThrows(exception, () -> {
                ArrayUtils.lastAfter1(arr);
            });
            return;
        }
        final var result = ArrayUtils.lastAfter1(arr);
        Assertions.assertArrayEquals(expected, result);
    }

    static Stream<Arguments> getArrData() {
        return List.of(
                Arguments.arguments(new int[]{1, 2, 3}, new int[]{2, 3}, null),
                Arguments.arguments(new int[]{2, 1, 3}, new int[]{3}, null),
                Arguments.arguments(new int[]{}, null, RuntimeException.class),
                Arguments.arguments(new int[]{1}, null, RuntimeException.class),
                Arguments.arguments(new int[]{2}, null, RuntimeException.class),
                Arguments.arguments(new int[]{2, 1}, null, RuntimeException.class)
        ).stream();
    }
}
