package ru.otus.java.basic.homeworks.lesson22;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Set;
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

    @ParameterizedTest
    @MethodSource("getCheckData")
    void checkInTest(Set<Integer> set, int[] arr, boolean expected, Class<Exception> exceptionClass) {
        if(exceptionClass != null){
            Assertions.assertThrows(exceptionClass, ()->{
                ArrayUtils.checkIn(set, arr);
            });
            return;
        }
        boolean result = ArrayUtils.checkIn(set, arr);
        Assertions.assertEquals(expected, result);
    }

    static Stream<Arguments> getCheckData() {
        return List.of(
                Arguments.arguments(Set.of(1, 2), new int[]{1, 2, 3}, true, null),
                Arguments.arguments(Set.of(1, 2, 3), new int[]{1, 2, 3}, true, null),
                Arguments.arguments(Set.of(1), new int[]{2,3}, false, null),
                Arguments.arguments(Set.of(1, 2, 3, 4), new int[]{1, 2, 3}, false, IllegalArgumentException.class)
        ).stream();
    }
}
