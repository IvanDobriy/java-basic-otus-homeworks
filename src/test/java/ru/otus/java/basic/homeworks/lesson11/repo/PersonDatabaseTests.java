package ru.otus.java.basic.homeworks.lesson11.repo;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import ru.otus.java.basic.homeworks.lesson11.enitity.Person;
import ru.otus.java.basic.homeworks.lesson11.enitity.Position;

import java.util.*;

import static ru.otus.java.basic.homeworks.lesson11.enitity.Position.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PersonDatabaseTests {

    @Test
    void creationNullCheckTest() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            new PersonDatabase(null);
        });
    }

    @Test
    void addTest() {
        final var storage = new HashMap<Long, Person>();
        final var db = new PersonDatabase(storage);
        final var person = new Person("Ivan", Position.DRIVER, 1L);
        final var person2 = new Person("John", Position.BRANCH_DIRECTOR, 2L);
        db.add(person);
        db.add(person2);
        Assertions.assertEquals(2, storage.size());
        Assertions.assertEquals(person, storage.get(1L));
        Assertions.assertEquals(person2, storage.get(2L));
    }

    @Test
    void addPersonIsNullTest() {
        final var db = new PersonDatabase();
        Assertions.assertThrows(NullPointerException.class, () -> {
            db.add(null);
        });
    }

    @Test
    void findByIdTest() {
        final var db = new PersonDatabase();
        final var person = new Person("Ivan", Position.DRIVER, 1L);
        db.add(person);
        var result = db.findById(1L);
        Assertions.assertEquals(person, result);
        result = db.findById(2L);
        Assertions.assertNull(result);
    }

    @Test
    void findByIdNullCheck() {
        final var db = new PersonDatabase();
        Assertions.assertThrows(NullPointerException.class, () -> {
            db.findById(null);
        });
    }

    @Test
    void isManagerTest() {
        final var db = new PersonDatabase();
        final var managersSign = List.of(MANAGER, DIRECTOR, BRANCH_DIRECTOR, SENIOR_MANAGER);
        final var mangers = new ArrayList<Person>(managersSign.size());
        for (int i = 0; i < managersSign.size(); i++) {
            mangers.add(new Person(String.valueOf(i), managersSign.get(i), (long) i));
        }

        final var anotherPersonsSignSet = new HashSet<>(Arrays.asList(Position.values()));
        anotherPersonsSignSet.removeAll(managersSign);
        final var anotherPersonsSign = new ArrayList<>(anotherPersonsSignSet);

        final var anotherPersons = new ArrayList<Person>(anotherPersonsSign.size());
        for (int i = 0; i < anotherPersonsSign.size(); i++) {
            anotherPersons.add(new Person(String.valueOf(i), anotherPersonsSign.get(i), (long) i));
        }
        anotherPersons.forEach((person -> {
            Assertions.assertFalse(db.isManager(person));
        }));

        mangers.forEach((manager) -> {
            Assertions.assertTrue(db.isManager(manager));
        });
    }

    @Test
    void isManagerNullCheckTest() {
        final var db = new PersonDatabase();
        Assertions.assertThrows(NullPointerException.class, () -> {
            db.isManager(null);
        });
    }

    @Test
    void isEmployeeTest() {
        final var db = new PersonDatabase();
        final var managersSign = List.of(MANAGER, DIRECTOR, BRANCH_DIRECTOR, SENIOR_MANAGER);
        final var mangers = new ArrayList<Person>(managersSign.size());
        for (int i = 0; i < managersSign.size(); i++) {
            final var person = new Person(String.valueOf(i), managersSign.get(i), (long) i);
            mangers.add(person);
            db.add(person);
        }

        final var employeeSignSet = new HashSet<>(Arrays.asList(Position.values()));
        employeeSignSet.removeAll(managersSign);
        final var employeeSign = new ArrayList<>(employeeSignSet);
        final var employeeList = new ArrayList<Person>(employeeSign.size());
        for (int i = managersSign.size(); i < employeeSign.size() + managersSign.size(); i++) {
            final var person = new Person(String.valueOf(i), employeeSign.get(i - managersSign.size()), (long) i);
            employeeList.add(person);
            db.add(person);
        }

        employeeList.forEach((employee -> {
            Assertions.assertTrue(db.isEmployee(employee.getId()));
        }));

        mangers.forEach((manager) -> {
            Assertions.assertFalse(db.isEmployee(manager.getId()));
        });
    }

    @Test
    void isEmployeeNullCheckTest() {
        final var db = new PersonDatabase();
        Assertions.assertThrows(NullPointerException.class, () -> {
            db.isEmployee(null);
        });
    }

}
