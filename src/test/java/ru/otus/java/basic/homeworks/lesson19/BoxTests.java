package ru.otus.java.basic.homeworks.lesson19;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BoxTests {
    @Test
    void positiveTest() {
        final var appleBox = new Box<Apple>();
        final var orangeBox = new Box<Orange>();
        final var fruitBox = new Box<>();
        final var apple = new Apple();
        final var orange = new Orange();
        appleBox.add(apple);
        orangeBox.add(orange);
        fruitBox.add(apple);
        fruitBox.add(orange);
        Assertions.assertEquals(1, appleBox.weight());
        Assertions.assertEquals(2, orangeBox.weight());
        Assertions.assertFalse(appleBox.compare(orangeBox));
        appleBox.pourTo(fruitBox);
        orangeBox.pourTo(fruitBox);
        Assertions.assertEquals(6, fruitBox.weight());
        Assertions.assertEquals(0, appleBox.weight());
        Assertions.assertEquals(0, orangeBox.weight());
    }
}
