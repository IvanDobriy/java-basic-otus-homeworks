package ru.otus.java.basic.homeworks.lesson9;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class EmployeeTests {
    @Test
    void creationTest() {
        final var employee = new Employee("Ivan", 34);
        Assertions.assertEquals(34, employee.getAge());
        Assertions.assertEquals("Ivan", employee.getName());
        final var illegalArgumentException = Assertions.assertThrows(IllegalArgumentException.class, () -> {
           new Employee("Ivan", -10);
        });
        Assertions.assertEquals("age < 0", illegalArgumentException.getMessage());
        final var nullPointerException = Assertions.assertThrows(NullPointerException.class, () -> {
            new Employee(null, 10);
        });
        Assertions.assertEquals("name is null", nullPointerException.getMessage());
    }
}
