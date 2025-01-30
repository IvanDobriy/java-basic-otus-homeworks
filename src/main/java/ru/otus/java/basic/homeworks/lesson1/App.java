package ru.otus.java.basic.homeworks.lesson1;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class App {
    interface RandomGenerator {
        int generate();
    }

    private final PrintStream out;
    private final Scanner scanner;
    private final RandomGenerator generator;


    private App() {
        throw new UnsupportedOperationException(String.format("Used unsupported default %s constructor", this.getClass().getName()));
    }

    public App(InputStream anInput, PrintStream anOut, RandomGenerator aGenerator) {
        scanner = new Scanner(anInput);
        out = anOut;
        generator = aGenerator;
    }

    public void greetings() {
        out.println("Hello");
        out.println("World");
        out.println("from");
        out.println("Java");
    }

    public void checkSign(int a, int b, int c) {
        final int result = a + b + c;
        if (result < 0) {
            out.println("Сумма отрицательная");
            return;
        }
        out.println("Сумма положительная");
    }

    public void selectColor(int data) {
        if (data <= 10) {
            out.println("Красный");
            return;
        }
        if (data <= 20) {
            out.println("Желтый");
            return;
        }
        out.println("Зеленый");
    }

    public void compareNumbers(int a, int b) {
        if (a >= b) {
            out.println("a >= b");
            return;
        }
        out.println("a < b");
    }

    public void addOrSubtractAndPrint(int a, int b, boolean increment) {
        if (increment) {
            out.println(a + b);
            return;
        }
        out.println(a - b);
    }

    public void runMenu() {
        out.println("Введите число от 1 до 5");
        switch (scanner.nextInt()) {
            case 1: {
                greetings();
                break;
            }
            case 2: {
                checkSign(generator.generate(), generator.generate(), generator.generate());
                break;
            }
            case 3: {
                selectColor(generator.generate());
                break;
            }
            case 4: {
                compareNumbers(generator.generate(), generator.generate());
                break;
            }
            case 5: {
                addOrSubtractAndPrint(generator.generate(), generator.generate(), generator.generate() % 2 == 0);
                break;
            }
        }
    }

    public static void main(String[] args) {
        var app = new App(System.in, System.out, () -> (int) (Math.random() * 1000));
        app.runMenu();
    }
}
