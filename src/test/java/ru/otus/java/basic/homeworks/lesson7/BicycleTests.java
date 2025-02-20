package ru.otus.java.basic.homeworks.lesson7;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import ru.otus.java.basic.homeworks.lesson7.driver.Human;
import ru.otus.java.basic.homeworks.lesson7.driver.Driver;
import ru.otus.java.basic.homeworks.lesson7.landscape.Landscape;
import ru.otus.java.basic.homeworks.lesson7.transport.Bicycle;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BicycleTests {

    @Test
    void creationTest() {
        final var bicycle = new Bicycle();
        Assertions.assertEquals(0, bicycle.getEnergy());
        Assertions.assertEquals("ru.otus.java.basic.homeworks.lesson7.transport.Bicycle{currentDriver:null}", bicycle.toString());
    }

    @Test
    void toStringTest() {
        final var human = new Human("Ivan", 10);
        final var bicycle = new Bicycle();
        bicycle.place(human);
        Assertions.assertEquals("ru.otus.java.basic.homeworks.lesson7.transport.Bicycle{currentDriver:Ivan}", bicycle.toString());
    }

    @Test
    void placeRemoveTests() {
        final var human = new Human("Ivan", 10);
        final var bicycle = new Bicycle();
        final var result = bicycle.place(human);
        Assertions.assertTrue(result);
        Assertions.assertEquals(human, bicycle.getDriver());
        Assertions.assertEquals(bicycle, human.getTransport());
        final var driver = bicycle.remove();
        Assertions.assertEquals(human, driver);
        Assertions.assertNull(bicycle.getDriver());
        Assertions.assertNull(human.getTransport());
    }

    @Test
    void placeDriverIsNull() {
        final var bicycle = new Bicycle();
        Assertions.assertThrows(NullPointerException.class, () -> {
            bicycle.place(null);
        });
    }

    @Test
    void removeDriverIsNull() {
        final var bicycle = new Bicycle();
        Assertions.assertNull(bicycle.remove());
    }

    @Test
    void repeatPlaceWithSameDriver() {
        final Driver driver = new Human("Ivan", 10);
        final var bicycle = new Bicycle();
        bicycle.place(driver);
        final var result = bicycle.place(driver);
        Assertions.assertTrue(result);
        Assertions.assertEquals(driver, bicycle.getDriver());
        Assertions.assertEquals(bicycle, driver.getTransport());
    }

    @Test
    void repeatWithOccupiedDriver() {
        final Driver driver1 = new Human("Ivan", 10);
        final Driver driver2 = new Human("John", 10);
        final var bicycle = new Bicycle();
        bicycle.place(driver1);
        final var result = bicycle.place(driver2);
        Assertions.assertFalse(result);
        Assertions.assertEquals(driver1, bicycle.getDriver());
        Assertions.assertEquals(bicycle, driver1.getTransport());
        Assertions.assertNull(driver2.getTransport());
    }

    @Test
    void moveTest() {
        final var human = new Human("Ivan", 10);
        final var bicycle = new Bicycle();
        bicycle.place(human);
        var result = bicycle.move(1, Landscape.PLAIN);
        Assertions.assertTrue(result);
        Assertions.assertEquals(9, bicycle.getEnergy());

        result = bicycle.move(10, Landscape.PLAIN);
        Assertions.assertFalse(result);
        Assertions.assertEquals(0, bicycle.getEnergy());
    }

    @Test
    void landscapeTest(){
        final var human = new Human("Ivan", 10);
        final var bicycle = new Bicycle();

        bicycle.place(human);
        var result = bicycle.move(1, Landscape.PLAIN);
        Assertions.assertTrue(result);


        result = bicycle.move(1, Landscape.WOODLAND);
        Assertions.assertTrue(result);

        result = bicycle.move(1, Landscape.SWAMP);
        Assertions.assertFalse(result);
    }

    @Test
    void spendEnergyTest() {
        final var human = new Human("Ivan", 10);
        final var bicycle = new Bicycle();

        bicycle.place(human);

        Assertions.assertEquals(9, bicycle.spendEnergy(1));
        Assertions.assertEquals(9, bicycle.getEnergy());
        Assertions.assertEquals(9, human.getEnergy());

        Assertions.assertEquals(-1, bicycle.spendEnergy(10));
        Assertions.assertEquals(0, bicycle.getEnergy());
        Assertions.assertEquals(0, human.getEnergy());
    }



}
