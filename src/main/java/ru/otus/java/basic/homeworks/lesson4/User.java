package ru.otus.java.basic.homeworks.lesson4;

public class User {
    private final String name;
    private final String surname;
    private final String patronymic;
    private final int yearOfBirthDate;
    private final String email;

    public User(String aSurname, String aName, String aPatronymic, int anYearOfBirthDate, String anEmail) {
        name = aName;
        surname = aSurname;
        patronymic = aPatronymic;
        yearOfBirthDate = anYearOfBirthDate;
        email = anEmail;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public int getYearOfBirthDate() {
        return yearOfBirthDate;
    }

    public String getEmail() {
        return email;
    }

    public void printUserInfo() {
        final var nameInfo = String.format("ФИО: %s %s %s\n", name, surname, patronymic);
        final var aBirthDateInfo = String.format("Год рождения: %d\n", yearOfBirthDate);
        final var emailInfo = String.format("e-mail: %s", email);
        System.out.println(nameInfo + aBirthDateInfo + emailInfo);
    }
}
