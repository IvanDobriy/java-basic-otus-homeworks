package ru.otus.java.basic.homeworks.lesson11.enitity;

import java.util.Objects;

public class Person {
    String name;

    Position position;

    Long id;

    public Person() {
        name = null;
        position = null;
        id = null;
    }

    public Person(String name, Position position, Long id) {
        this.name = name;
        this.position = position;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Person person = (Person) o;
        return Objects.equals(name, person.name) && position == person.position && Objects.equals(id, person.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position, id);
    }
}
