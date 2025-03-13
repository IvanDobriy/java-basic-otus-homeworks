package ru.otus.java.basic.homeworks.lesson11;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SortingTest {
    @Test
    void bubbleSortTest(){
        final var arr = new int[]{3,2,1};
        final var expected = new int[]{1,2,3};
        Sorting.bubbleSort(arr);
        Assertions.assertArrayEquals(expected, arr);
    }
}
