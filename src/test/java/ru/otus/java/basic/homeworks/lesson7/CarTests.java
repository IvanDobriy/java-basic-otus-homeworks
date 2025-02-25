package ru.otus.java.basic.homeworks.lesson7;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import ru.otus.java.basic.homeworks.lesson7.driver.Human;
import ru.otus.java.basic.homeworks.lesson7.landscape.Landscape;
import ru.otus.java.basic.homeworks.lesson7.transport.Car;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CarTests {

    @Test
    void creationTest() {
        final var car = new Car(10);
        Assertions.assertEquals(10, car.getEnergy());
        Assertions.assertEquals("ru.otus.java.basic.homeworks.lesson7.transport.Car{gasoline:10,currentDriver:null}", car.toString());
    }

    @Test
    void toStringTest() {
        final var human = new Human("Ivan", 10);
        final var car = new Car(10);
        car.place(human);
        Assertions.assertEquals("ru.otus.java.basic.homeworks.lesson7.transport.Car{gasoline:10,currentDriver:Ivan}", car.toString());
    }

    @Test
    void moveTest() {
        final var human = new Human("Ivan", 10);
        final var car = new Car(10);
        car.place(human);
        var result = car.move(1, Landscape.PLAIN);
        Assertions.assertTrue(result);
        Assertions.assertEquals(9, car.getEnergy());

        result = car.move(10, Landscape.PLAIN);
        Assertions.assertFalse(result);
        Assertions.assertEquals(0, car.getEnergy());
    }


    @Test
    void landscapeTest() {
        final var human = new Human("Ivan", 10);
        final var car = new Car(10);

        car.place(human);
        var result = car.move(1, Landscape.PLAIN);
        Assertions.assertTrue(result);


        result = car.move(1, Landscape.WOODLAND);
        Assertions.assertFalse(result);

        result = car.move(1, Landscape.SWAMP);
        Assertions.assertFalse(result);
    }

    @Test
    void spendEnergyTest() {
        final var human = new Human("Ivan", 10);
        final var car = new Car(10);

        car.place(human);

        Assertions.assertTrue(car.spendEnergy(1));
        Assertions.assertEquals(9, car.getEnergy());
        Assertions.assertEquals(10, human.getEnergy());

        Assertions.assertFalse(car.spendEnergy(10));
        Assertions.assertEquals(0, car.getEnergy());
        Assertions.assertEquals(10, human.getEnergy());
    }
}
