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
        class TestCase {
            final int key;
            final Integer expected;
            final int depth;

            TestCase(int key, int depth, Integer expected) {
                this.key = key;
                this.depth = depth;
                this.expected = expected;
            }
        }
        final var sortedList = new ArrayList<Integer>();
        for (int i = 0; i < 256; i++) {
            sortedList.add(i);
        }
        final var cases = List.of(
                new TestCase(1, 8, 1),
                new TestCase(255, 8, 255),
                new TestCase(128, 1, 128),
                new TestCase(1000, 9, null),
                new TestCase(-1, 10, null)
        );
        final var finder = new Finder<>(sortedList, Comparator.comparingInt(el -> el));
        for (TestCase tc : cases) {
            var result = finder.find(tc.key);
            Assertions.assertEquals(tc.expected, result);
            Assertions.assertEquals(tc.depth, finder.getPathLength());
        }
    }

    @Test
    void sortedListTest() {
        final var sortedList = List.of(1, 2, 3, 4, 5);
        final var finder = new Finder<>(sortedList, Comparator.comparingInt(el -> el));
        Assertions.assertEquals(sortedList, finder.getSortedList());
    }


}
