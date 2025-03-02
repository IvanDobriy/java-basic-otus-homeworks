package ru.otus.java.basic.homeworks.lesson9;

import ru.otus.java.basic.homeworks.lesson9.exceptions.RangeCreationException;

import java.util.ArrayList;

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
}
