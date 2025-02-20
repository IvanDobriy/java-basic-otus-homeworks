package ru.otus.java.basic.homeworks.lesson7;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import ru.otus.java.basic.homeworks.lesson7.driver.Human;
import ru.otus.java.basic.homeworks.lesson7.landscape.Landscape;
import ru.otus.java.basic.homeworks.lesson7.transport.Rover;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class RoverTests {

    @Test
    void creationTest() {
        final var rover = new Rover(10);
        Assertions.assertEquals(10, rover.getEnergy());
        Assertions.assertEquals("ru.otus.java.basic.homeworks.lesson7.transport.Rover{gasoline:10,currentDriver:null}", rover.toString());
    }

    @Test
    void toStringTest() {
        final var human = new Human("Ivan", 10);
        final var rover = new Rover(10);
        rover.place(human);
        Assertions.assertEquals("ru.otus.java.basic.homeworks.lesson7.transport.Rover{gasoline:10,currentDriver:Ivan}", rover.toString());
    }


    @Test
    void landscapeTest() {
        final var human = new Human("Ivan", 10);
        final var rover = new Rover(10);

        rover.place(human);
        var result = rover.move(1, Landscape.PLAIN);
        Assertions.assertTrue(result);


        result = rover.move(1, Landscape.WOODLAND);
        Assertions.assertTrue(result);

        result = rover.move(1, Landscape.SWAMP);
        Assertions.assertTrue(result);
    }

}
