package ru.otus.java.basic.homeworks.lesson10;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PhoneBookTests {
    @Test
    void oneUserTest() {
        final var phoneBook = new PhoneBook();
        final var expectedPhone = "123";
        phoneBook.add("Danilchenko", "Ivan", "Sergeevich", expectedPhone);

        var result = phoneBook.find("Danilchenko", "Ivan", "Sergeevich");
        Assertions.assertEquals(List.of(expectedPhone), result);

        result = phoneBook.find("Danilchenko", "Ivan", null);
        Assertions.assertEquals(List.of(expectedPhone), result);

        result = phoneBook.find("Danilchenko", null, "Sergeevich");
        Assertions.assertEquals(List.of(expectedPhone), result);

        result = phoneBook.find(null, "Ivan", "Sergeevich");
        Assertions.assertEquals(List.of(expectedPhone), result);

        result = phoneBook.find("Danilchenko", null, null);
        Assertions.assertEquals(List.of(expectedPhone), result);

        result = phoneBook.find(null, "Ivan", null);
        Assertions.assertEquals(List.of(expectedPhone), result);

        result = phoneBook.find(null, null, "Sergeevich");
        Assertions.assertEquals(List.of(expectedPhone), result);

        result = phoneBook.find("Ivanov", null, null);
        Assertions.assertEquals(List.of(), result);
    }

    @Test
    void nullCheck() {
        final var phoneBook = new PhoneBook();
        final var expectedPhone = "123";
        var exception = Assertions.assertThrows(NullPointerException.class, ()->{
            phoneBook.add(null, "Ivan", "Sergeevich", expectedPhone);
        });
        Assertions.assertEquals("last name is null", exception.getMessage());

        exception = Assertions.assertThrows(NullPointerException.class, ()->{
            phoneBook.add("Danilchenko", null, "Sergeevich", expectedPhone);
        });
        Assertions.assertEquals("first name is null", exception.getMessage());

        exception = Assertions.assertThrows(NullPointerException.class, ()->{
            phoneBook.add("Danilchenko", "Ivan", null, expectedPhone);
        });
        Assertions.assertEquals("patronymic is null", exception.getMessage());
    }


    @Test
    void multyUserTest() {
        final var phoneBook = new PhoneBook();
        final var expectedPhone1 = "1";
        final var expectedPhone2 = "2";
        final var expectedPhone3 = "3";
        final var expectedPhone4 = "4";

        phoneBook.add("A", "B", "C", expectedPhone1);
        phoneBook.add("A", "B", "F", expectedPhone2);
        phoneBook.add("A", "G", "H", expectedPhone3);
        phoneBook.add("B", "G", "H", expectedPhone4);

        var result = phoneBook.find("A", "B", "C");
        Assertions.assertEquals(List.of(expectedPhone1), result);

        result = phoneBook.find("A", "B", null);
        Assertions.assertEquals(List.of(expectedPhone1, expectedPhone2), result);

        result = phoneBook.find(null, "G", "H");
        Assertions.assertEquals(List.of(expectedPhone3, expectedPhone4), result);

        result = phoneBook.find(null, "B", "F");
        Assertions.assertEquals(List.of(expectedPhone2), result);

        result = phoneBook.find("A", null, "H");
        Assertions.assertEquals(List.of(expectedPhone3), result);

        result = phoneBook.find("A", null, "F");
        Assertions.assertEquals(List.of(expectedPhone2), result);

        result = phoneBook.find("A", null, null);
        Assertions.assertEquals(List.of(expectedPhone1, expectedPhone2, expectedPhone3), result);

        result = phoneBook.find(null, "B", null);
        Assertions.assertEquals(List.of(expectedPhone1, expectedPhone2), result);

        result = phoneBook.find(null, "G", null);
        Assertions.assertEquals(List.of(expectedPhone3, expectedPhone4), result);

        result = phoneBook.find(null, null, "C");
        Assertions.assertEquals(List.of(expectedPhone1), result);

        result = phoneBook.find(null, null, "F");
        Assertions.assertEquals(List.of(expectedPhone2), result);

        result = phoneBook.find(null, null, "H");
        Assertions.assertEquals(List.of(expectedPhone3, expectedPhone4), result);
    }

    @Test
    void containsPhoneNumberTest(){
        final var phoneBook = new PhoneBook();
        final var expectedPhone1 = "1";
        final var expectedPhone2 = "2";
        final var expectedPhone3 = "3";
        final var expectedPhone4 = "4";

        phoneBook.add("A", "B", "C", expectedPhone1);
        phoneBook.add("A", "B", "F", expectedPhone2);
        phoneBook.add("A", "G", "H", expectedPhone3);
        phoneBook.add("B", "G", "H", expectedPhone4);

        var result = phoneBook.containsPhoneNumber(expectedPhone1);
        Assertions.assertTrue(result);

        result = phoneBook.containsPhoneNumber(expectedPhone2);
        Assertions.assertTrue(result);

        result = phoneBook.containsPhoneNumber(expectedPhone3);
        Assertions.assertTrue(result);

        result = phoneBook.containsPhoneNumber(expectedPhone4);
        Assertions.assertTrue(result);
        result = phoneBook.containsPhoneNumber("789))");
        Assertions.assertFalse(result);
    }
}
