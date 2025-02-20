package ru.otus.java.basic.homeworks.lesson7;

import ru.otus.java.basic.homeworks.lesson7.driver.Human;
import ru.otus.java.basic.homeworks.lesson7.landscape.Landscape;
import ru.otus.java.basic.homeworks.lesson7.transport.*;

public class App {

    public static void main(String[] args) {
        final var girl = new Human("Alexandra", 1000);
        final var names = new String[]{
                "Ivan",
                "John",
                "Fedr",
                "Emelya",
                "Alexey",
                "Pavel",
                "Petiya"
        };
        final var transports = new Transport[]{
                new Car(10),
                new Rover(10),
                new Bicycle(),
                new Horse(10)
        };
        for (Transport transport : transports) {
            transport.place(new Human(names[(int)(Math.random() * names.length)], 10));
        }
        for (Transport transport : transports) {
            final var loggedMovable = new LoggedMovable(transport);
            for (Landscape landscape : Landscape.values()) {
                loggedMovable.move(1, landscape);
            }
        }
        final var loggedMovable = new LoggedMovable(girl);
        for (Landscape landscape : Landscape.values()) {
            loggedMovable.move(1, landscape);
        }
    }
}
