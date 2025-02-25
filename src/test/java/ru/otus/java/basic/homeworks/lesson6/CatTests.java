package ru.otus.java.basic.homeworks.lesson6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CatTests {
    @Test
    void creationTest() {
        final var cat = new Cat("Muska", 10);
        Assertions.assertEquals("Muska", cat.getName());
        Assertions.assertEquals(10, cat.getAppetite());
        Assertions.assertFalse(cat.isFull());
    }

    @Test
    void creationNegativeTest() {
        final var exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Cat("Muska", -1);
        });
        Assertions.assertEquals("appetite < 0", exception.getMessage());
    }

    @Test
    void eatTest(){
        var plate = new Plate(10);
        var cat = new Cat("Muska", 9);
        cat.eat(plate);
        Assertions.assertEquals(9, cat.getAppetite());
        Assertions.assertTrue(cat.isFull());
        Assertions.assertEquals(1, plate.getCurrentAmount());


        plate = new Plate(10);
        cat = new Cat("Murzic",11);
        cat.eat(plate);
        Assertions.assertEquals(11, cat.getAppetite());
        Assertions.assertFalse(cat.isFull());
        Assertions.assertEquals(10, plate.getCurrentAmount());


        plate = new Plate(11);
        cat.eat(plate);
        Assertions.assertEquals(11, cat.getAppetite());
        Assertions.assertTrue(cat.isFull());
        Assertions.assertEquals(0, plate.getCurrentAmount());
    }

    @Test
    void toStringTest() {
        final var cat = new Cat("Muska", 10);
        final var plate = new Plate(10);
        Assertions.assertEquals("Cat{name:Muska,appetite:10,isFull:false}", cat.toString());
        cat.eat(plate);
        Assertions.assertEquals("Cat{name:Muska,appetite:10,isFull:true}", cat.toString());
    }
}
