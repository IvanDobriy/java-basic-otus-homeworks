package ru.otus.java.basic.homeworks.lesson11.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import ru.otus.java.basic.homeworks.lesson11.enitity.Person;
import ru.otus.java.basic.homeworks.lesson11.enitity.Position;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PersonTests {

    @Test
    void equalsReflectionTest() {
        final var person = new Person("1", Position.DRIVER, 1L);
        Assertions.assertTrue(person.equals(person));

    }

    @Test
    void equalsSymmetryTest() {
        final var person1 = new Person("1", Position.DRIVER, 1L);
        final var person2 = new Person("1", Position.DRIVER, 1L);
        Assertions.assertFalse(person2 == person1);
        Assertions.assertTrue(person1.equals(person2));
        Assertions.assertTrue(person2.equals(person1));
        Assertions.assertTrue(person1.hashCode() == person2.hashCode());
    }

    @Test
    void equalsTransitivityTest() {
        final var person1 = new Person("1", Position.DRIVER, 1L);
        final var person2 = new Person("1", Position.DRIVER, 1L);
        final var person3 = new Person("1", Position.DRIVER, 1L);
        Assertions.assertTrue(person1.equals(person2));
        Assertions.assertTrue(person2.equals(person3));
        Assertions.assertTrue(person1.equals(person3));
        Assertions.assertTrue(person1.hashCode() == person2.hashCode() && person1.hashCode() == person3.hashCode());

    }

    @Test
    void equalsTest() {
        final var person1 = new Person("1", Position.DRIVER, 1L);
        final var person2 = new Person("2", Position.BRANCH_DIRECTOR, 2L);
        Assertions.assertFalse(person1.equals(person2));
        Assertions.assertTrue(person1.hashCode() != person2.hashCode());
    }

    @Test
    void hashCodeTest() {
        final var person1 = new Person("1", Position.DRIVER, 1L);
        final var h1 = person1.hashCode();
        final var h2 = person1.hashCode();
        Assertions.assertTrue(h1 == h2);
        person1.setId(2L);
        final var h3 = person1.hashCode();
        Assertions.assertTrue(h1 != h3);
    }

}
