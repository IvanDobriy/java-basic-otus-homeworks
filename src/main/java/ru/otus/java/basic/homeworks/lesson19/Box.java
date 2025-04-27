package ru.otus.java.basic.homeworks.lesson19;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {
    private final List<T> content;

    Box() {
        content = new ArrayList<>();
    }

    public void add(T fruit) {
        content.add(fruit);
    }

    public double weight() {
        double result = 0.0;
        for (T fruit : content) {
            result += fruit.size();
        }
        return result;
    }

    public boolean compare(Box<?> aBox) {
        return Math.abs(this.weight() - aBox.weight()) < 0.001;
    }

    public void pourTo(Box<? super T> aBox) {
        for (var el : content) {
            aBox.add(el);
        }
    }
}
