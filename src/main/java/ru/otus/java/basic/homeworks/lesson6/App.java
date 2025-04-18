package ru.otus.java.basic.homeworks.lesson6;

public class App {

    public static void main(String[] args) {
        final var plates = new Plate[]{
                new Plate(1),
                new Plate(10),
                new Plate(12)
        };
        final var cats = new Cat[]{
                new Cat("Muska", 10),
                new Cat("Murzic", 3),
                new Cat("Barsic", 10), // I fill sorry for Barsic ((
        };
        for (Cat cat : cats) {
            for (Plate plate : plates) {
                if (cat.isFull()) {
                    break;
                }
                cat.eat(plate);
            }
        }
        for (Plate plate : plates) {
            System.out.println(plate);
        }
        for (Cat cat : cats) {
            System.out.println(cat);
        }
    }
}
