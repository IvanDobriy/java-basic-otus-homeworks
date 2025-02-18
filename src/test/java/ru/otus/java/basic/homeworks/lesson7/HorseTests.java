package ru.otus.java.basic.homeworks.lesson7;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import ru.otus.java.basic.homeworks.lesson7.driver.Human;
import ru.otus.java.basic.homeworks.lesson7.landscape.Landscape;
import ru.otus.java.basic.homeworks.lesson7.transport.Horse;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class HorseTests {

    @Test
    void creationTest() {
        final var horse = new Horse(10);
        Assertions.assertEquals(10, horse.getEnergy());
        Assertions.assertEquals("ru.otus.java.basic.homeworks.lesson7.transport.Horse{forces:10,currentDriver:null}", horse.toString());
    }

    @Test
    void toStringTest() {
        final var human = new Human("Ivan", 10);
        final var horse = new Horse(10);
        horse.place(human);
        Assertions.assertEquals("ru.otus.java.basic.homeworks.lesson7.transport.Horse{forces:10,currentDriver:Ivan}", horse.toString());
    }

    @Test
    void moveTest() {
        final var human = new Human("Ivan", 10);
        final var horse = new Horse(10);
        horse.place(human);
        var result = horse.move(1, Landscape.PLAIN);
        Assertions.assertTrue(result);
        Assertions.assertEquals(9, horse.getEnergy());

        result = horse.move(10, Landscape.PLAIN);
        Assertions.assertFalse(result);
        Assertions.assertEquals(0, horse.getEnergy());
    }

    @Test
    void landscapeTest() {
        final var human = new Human("Ivan", 10);
        final var horse = new Horse(10);
        horse.place(human);
        var result = horse.move(1, Landscape.PLAIN);
        Assertions.assertTrue(result);


        result = horse.move(1, Landscape.WOODLAND);
        Assertions.assertTrue(result);

        result = horse.move(1, Landscape.SWAMP);
        Assertions.assertFalse(result);
    }

    @Test
    void spendEnergyTest() {
        final var human = new Human("Ivan", 10);
        final var horse = new Horse(10);

        horse.place(human);

        Assertions.assertEquals(9, horse.spendEnergy(1));
        Assertions.assertEquals(9, horse.getEnergy());
        Assertions.assertEquals(10, human.getEnergy());

        Assertions.assertEquals(-1, horse.spendEnergy(10));
        Assertions.assertEquals(0, horse.getEnergy());
        Assertions.assertEquals(10, human.getEnergy());
    }
}
