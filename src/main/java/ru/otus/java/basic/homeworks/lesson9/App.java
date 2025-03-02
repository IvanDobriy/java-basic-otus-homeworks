package ru.otus.java.basic.homeworks.lesson9;

import ru.otus.java.basic.homeworks.lesson9.exceptions.RangeCreationException;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static ArrayList<Integer> range(final int min, final int max) {
        if (min > max) {
            throw new RangeCreationException(min, max);
        }
        int capacity = Math.abs(max - min) + 1;
        final var list = new ArrayList<Integer>(capacity);
        int value = min;
        for (int i = 0; i < capacity; i++) {
            list.add(value++);
        }
        return list;
    }

    public static int sum(final List<Integer> elements) {
        int result = 0;
        for (int element : elements) {
            if (element > 5) {
                result += element;
            }
        }
        return result;
    }

    public static void fill(final int value, final List<Integer> elements) {
        for (int i = 0; i < elements.size(); i++) {
            elements.set(i, value);
        }
    }

    public static void increment(final int value, final List<Integer> elements) {
        for (int i = 0; i < elements.size(); i++) {
            final var previous = elements.get(i);
            elements.set(i, previous + value);
        }
    }
}
