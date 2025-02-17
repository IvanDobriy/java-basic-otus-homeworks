package ru.otus.java.basic.homeworks.lesson7;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import ru.otus.java.basic.homeworks.lesson7.driver.Human;
import ru.otus.java.basic.homeworks.lesson7.landscape.Landscape;
import ru.otus.java.basic.homeworks.lesson7.transport.Bicycle;
import ru.otus.java.basic.homeworks.lesson7.transport.ITransport;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class HumanTests {
    @Test
    void creationTest() {
        final var human = new Human("Ivan", 10);
        Assertions.assertEquals("Ivan", human.getName());
        Assertions.assertEquals(10, human.getEnergy());
        Assertions.assertEquals("ru.otus.java.basic.homeworks.lesson7.driver.Human{name:Ivan,energy:10,currentTransport:null}", human.toString());
    }

    @Test
    void toStringTest(){
        final var human = new Human("Ivan", 10);
        final ITransport bicycle = new Bicycle();
        human.getIn(bicycle);
        Assertions.assertEquals("", bicycle);
    }

    @Test
    void getInOutTest() {
        final var human = new Human("Ivan", 10);
        final ITransport bicycle = new Bicycle();
        final var result = human.getIn(bicycle);
        Assertions.assertTrue(result);
        Assertions.assertEquals(bicycle, human.getTransport());
        Assertions.assertEquals(human, bicycle.getDriver());
        final var transport = human.getOut();
        Assertions.assertEquals(bicycle, transport);
        Assertions.assertNull(bicycle.getDriver());
    }

    @Test
    void getInTransportIsNull(){
        final var human = new Human("Ivan", 10);
        Assertions.assertThrows(NullPointerException.class, ()->{
            human.getIn(null);
        });
    }

    @Test
    void repeatGetInWithSameTransport(){
        final var human = new Human("Ivan", 10);
        final ITransport transport = new Bicycle();
        human.getIn(transport);
        final var result = human.getIn(transport);
        Assertions.assertTrue(result);
        Assertions.assertEquals(transport, human.getTransport());
        Assertions.assertEquals(human, transport.getDriver());
    }

    @Test
    void repeatGetInWithDifferentTransport(){
        final var human = new Human("Ivan", 10);
        final ITransport transport1 = new Bicycle();
        final ITransport transport2 = new Bicycle();
        human.getIn(transport1);
        final var result = human.getIn(transport2);
        Assertions.assertFalse(result);
        Assertions.assertEquals(transport1, human.getTransport());
        Assertions.assertEquals(human, transport1.getDriver());
        Assertions.assertNull(transport2.getDriver());
    }

    @Test
    void getInWithOccupiedTransport(){
        final var human1 = new Human("Ivan", 10);
        final ITransport transport1 = new Bicycle();
        human1.getIn(transport1);
        final var human2 = new Human("John", 10);
        final var result = human2.getIn(transport1);
        Assertions.assertFalse(result);
        Assertions.assertNull(human2.getTransport());
        Assertions.assertEquals(transport1, human1.getTransport());
        Assertions.assertEquals(human1, transport1.getDriver());
    }

    @Test
    void moveTest() {
        final var human = new Human("Ivan", 10);
        var result = human.move(1, Landscape.PLAIN);
    }

}
