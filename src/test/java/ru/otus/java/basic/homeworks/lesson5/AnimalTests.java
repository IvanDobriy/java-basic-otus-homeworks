package ru.otus.java.basic.homeworks.lesson5;

import org.junit.jupiter.api.*;
import ru.otus.java.basic.homeworks.lesson5.animals.Animal;
import ru.otus.java.basic.homeworks.lesson5.animals.Cat;
import ru.otus.java.basic.homeworks.lesson5.animals.Dog;
import ru.otus.java.basic.homeworks.lesson5.animals.Horse;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AnimalTests {
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream printStream = new PrintStream(outputStream);
    private final PrintStream initialOut = System.out;

    @BeforeEach
    void beforeEach() {
        outputStream.reset();
        System.setOut(printStream);
    }

    @AfterEach
    void afterEach() {
        System.setOut(initialOut);
    }

    @Test
    void runTests() {
        final var animals = new Animal[]{
                new Dog("Irma", 1, 1, 10),
                new Cat("Muska", 1, 1, 10),
                new Horse("Valya", 1, 1, 10),
        };
        for (int i = 0; i < animals.length; i++) {
            final var animal = animals[i];
            var time = animal.run(2);
            var stamina = animal.getStamina();
            Assertions.assertEquals(2, time);
            Assertions.assertEquals(8, stamina);
            time = animal.run(2000);
            stamina = animal.getStamina();
            Assertions.assertEquals(-1, time);
            Assertions.assertEquals(8, stamina);
        }
    }

    @Test
    void dogSwimTest() {
        final var dog = new Dog("Irma", 1, 2, 10);
        var time = dog.swim(2);
        var stamina = dog.getStamina();
        Assertions.assertEquals(1, time);
        Assertions.assertEquals(6, stamina);
        time = dog.swim(50);
        stamina = dog.getStamina();
        Assertions.assertEquals(-1, time);
        Assertions.assertEquals(6, stamina);
    }

    @Test
    void horseSwimTest() {
        final var horse = new Horse("Valya", 1, 2, 10);
        var time = horse.swim(2);
        var stamina = horse.getStamina();
        Assertions.assertEquals(1, time);
        Assertions.assertEquals(2, stamina);
        time = horse.swim(2);
        stamina = horse.getStamina();
        Assertions.assertEquals(-1, time);
        Assertions.assertEquals(2, stamina);
    }

    @Test
    void catSwimTest() {
        final var cat = new Cat("Muska", 1, 1, 10);
        final var exception = Assertions.assertThrows(RuntimeException.class, () -> cat.swim(1));
        Assertions.assertEquals("Cat can`t swim", exception.getMessage());
    }

    @Test
    void dogInfoTest() {
        final var dog = new Dog("Irma", 1, 1, 10);
        dog.info();
        final var result = outputStream.toString();
        final var expected = "Dog description: name: Irma, runSpeed: 1, swimSpeed: 1, stamina: 10\n";
        Assertions.assertEquals(expected, result);
    }

    @Test
    void catInfoTest() {
        final var cat = new Cat("Muska", 1, 1, 10);
        cat.info();
        final var result = outputStream.toString();
        final var expected = "Cat description: name: Muska, runSpeed: 1, swimSpeed: 1, stamina: 10\n";
        Assertions.assertEquals(expected, result);
    }

    @Test
    void horseInfoTest() {
        final var horse = new Horse("Valya", 1, 1, 10);
        horse.info();
        final var result = outputStream.toString();
        final var expected = "Horse description: name: Valya, runSpeed: 1, swimSpeed: 1, stamina: 10\n";
        Assertions.assertEquals(expected, result);
    }

    @Test
    void illegalConstructorArguments() {
        var exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Dog("Rich", -1, 1, 1);
        });
        Assertions.assertEquals("aRunSpeed < 0", exception.getMessage());
        exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Dog("Rich", 1, -1, 1);
        });
        Assertions.assertEquals("aSwimSpeed < 0", exception.getMessage());
        exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Dog("Rich", 1, 1, -1);
        });
        Assertions.assertEquals("aStamina < 0", exception.getMessage());
    }

    @Test
    void illegalRunArguments() {
        final var animals = new Animal[]{
                new Dog("Irma", 1, 1, 10),
                new Cat("Muska", 1, 1, 10),
                new Horse("Valya", 1, 1, 10),
        };
        for (int i = 0; i < animals.length; i++) {
            final var animal = animals[i];
            final var exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
                animal.run(-1);
            });
            Assertions.assertEquals("distance < 0", exception.getMessage());
        }
    }

    @Test
    void illegalSwimArguments(){
        final var animals = new Animal[]{
                new Dog("Irma", 1, 1, 10),
                new Horse("Valya", 1, 1, 10),
        };
        for (int i = 0; i < animals.length; i++) {
            final var animal = animals[i];
            final var exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
                animal.swim(-1);
            });
            Assertions.assertEquals("distance < 0", exception.getMessage());
        }
    }
}
