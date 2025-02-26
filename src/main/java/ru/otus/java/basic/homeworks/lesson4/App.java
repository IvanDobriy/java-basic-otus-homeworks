package ru.otus.java.basic.homeworks.lesson4;

import java.time.ZonedDateTime;
import java.util.logging.Logger;

public class App {
    public static void userExample(){
        final var users = new User[]{
                new User("Petrov", "Ivan", "Sergeevich", 1990, "petrov@mail.com"),
                new User("Chugunov", "Petr", "Ivanovich", 1980, "chugunov@mail.com"),
                new User("Ivanov", "Ivan", "Vasilievich", 1970, "ivanov@mail.com"),
                new User("Gordeev", "Fedr", "Petrovich", 2000, "gordeev@mail.com"),
                new User("Cubirev", "Ilya", "Fedorovich", 2000, "cubirev@mail.com"),
                new User("Kuzmichev", "Oleg", "Vasilievich", 2010, "kuzmichev@mail.com"),
                new User("Filonov", "Anton", "Andreevich", 2010, "filonov@mail.com"),
                new User("Stepochkin", "Alexey", "Vladimirovich", 2010, "stepochkin@mail.com"),
                new User("Agarev", "Alexey", "Anatolievich", 1989, "agarev@mail.com"),
                new User("Gusev", "Dmitriy", "Sergeevich", 1995, "gusev@mail.com")
        };
        final var timePoint = ZonedDateTime.now().minusYears(40);
        for (int i = 0; i < users.length; i++) {
            final var user = users[i];
            if (timePoint.getYear() > user.getYearOfBirthDate()) {
                user.printUserInfo();
            }
        }
    }
    public static void boxExample(){
        final var smallBox = new BoxProfiler(new Box(Size.SMALL, Color.BLACK, true));
        final var mediumBox = new BoxProfiler( new Box(Size.MEDIUM, Color.BLACK, true));
        final var largeBox = new BoxProfiler(new Box(Size.LARGE, Color.BLACK, true));
        mediumBox.putContent(smallBox);
        largeBox.putContent(mediumBox);
        largeBox.printInfo();
    }

    public static void main(String[] args) {
        userExample();
        boxExample();
    }
}
