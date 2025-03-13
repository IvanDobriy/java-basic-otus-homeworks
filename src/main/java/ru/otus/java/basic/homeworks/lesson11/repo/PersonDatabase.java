package ru.otus.java.basic.homeworks.lesson11.repo;

import ru.otus.java.basic.homeworks.lesson11.enitity.Person;
import ru.otus.java.basic.homeworks.lesson11.enitity.Position;

import java.util.*;

import static ru.otus.java.basic.homeworks.lesson11.enitity.Position.*;

public class PersonDatabase {
    private final Map<Long, Person> storage;

    private final static Set<Position> managerSigns = Set.of(MANAGER, DIRECTOR, BRANCH_DIRECTOR, SENIOR_MANAGER);
    private final static Set<Position> employerSign = getEmployerSign();

    private static Set<Position> getEmployerSign() {
        final var positions = new HashSet<>(Arrays.asList(Position.values()));
        positions.removeAll(managerSigns);
        return positions; //is mutable )))
    }

    public PersonDatabase() {
        storage = new HashMap<>();
    }

    public PersonDatabase(Map<Long, Person> storage) {
        Objects.requireNonNull(storage);
        this.storage = storage;
    }

    Person findById(Long id) {
        Objects.requireNonNull(id);
        return storage.get(id);
    }

    void add(Person person) {
        Objects.requireNonNull(person);
        storage.put(person.getId(), person);
    }

    boolean isManager(Person person) {
        Objects.requireNonNull(person);
        return managerSigns.contains(person.getPosition());
    }

    boolean isEmployee(Long id) {
        Objects.requireNonNull(id);
        final var person = storage.get(id);
        if (person == null) {
            return false;
        }
        return employerSign.contains(person.getPosition());
    }
}
