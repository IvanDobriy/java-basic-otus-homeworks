package ru.otus.java.basic.homeworks.lesson11;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import ru.otus.java.basic.homeworks.lesson11.tree.Finder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FinderTests {

    @Test
    void positiveTest() {
        final var sortedList = List.of(1, 2, 3, 4, 5);
        final var finder = new Finder<>(sortedList, Comparator.comparingInt(el -> el));
        for (Integer element : sortedList) {
            final var result = finder.find(element);
            Assertions.assertEquals(element, result);
        }
        final var result = finder.find(123);
        Assertions.assertEquals(null, result);
    }

    @Test
    void usingUnsortedTest() {
        final var someList = List.of(1, 3, 0, -1);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Finder<>(someList, Comparator.comparingInt(el -> el));
        });
    }

    @Test
    void usingListWithNullElement() {
        final var someList = Arrays.asList(1, 2, 3, null);
        Assertions.assertThrows(RuntimeException.class, () -> {
            new Finder<>(someList, Comparator.comparingInt(el -> el));
        });
    }

    @Test
    void listIsNull() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            new Finder<Integer>(null, Comparator.comparingInt(el -> el));
        });
    }

    @Test
    void comparatorIsNull() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            new Finder<Integer>(List.of(1, 2, 3, 4, 5), null);
        });
    }

    @Test
    void listIsEmpty() {
        final var sortedList = List.<Integer>of();
        final var finder = new Finder<>(sortedList, Comparator.comparingInt(el -> el));
        final var result = finder.find(1);
        Assertions.assertEquals(null, result);
    }

    @Test
    void pathTest() {
        final var sortedList = new ArrayList<Integer>();
        for (int i = 0; i < 256; i++) {
            sortedList.add(i);
        }
        final var finder = new Finder<>(sortedList, Comparator.comparingInt(el -> el));
        var result = finder.find(1);
        Assertions.assertEquals(1, result);
        Assertions.assertEquals(8, finder.getPathLength());

        result = finder.find(255);
        Assertions.assertEquals(255, result);
        Assertions.assertEquals(8, finder.getPathLength());

        result = finder.find(128);
        Assertions.assertEquals(128, result);
        Assertions.assertEquals(1, finder.getPathLength());

        result = finder.find(1000);
        Assertions.assertNull(result);
        Assertions.assertEquals(9, finder.getPathLength());

        result = finder.find(-1);
        Assertions.assertNull(result);
        Assertions.assertEquals(10, finder.getPathLength());
    }

    @Test
    void sortedListTest() {
        final var sortedList = List.of(1, 2, 3, 4, 5);
        final var finder = new Finder<>(sortedList, Comparator.comparingInt(el -> el));
        Assertions.assertEquals(sortedList, finder.getSortedList());
    }


}
