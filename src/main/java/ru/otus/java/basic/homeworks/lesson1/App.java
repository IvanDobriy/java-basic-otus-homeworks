package ru.otus.java.basic.homeworks.lesson1;

import java.io.PrintStream;

public class App {
    private final PrintStream out;

    private App() {
        throw new UnsupportedOperationException(String.format("Used unsupported default %s constructor", this.getClass().getName()));
    }

    private App(PrintStream anOut) {
        out = anOut;
    }

    void greetings() {
        out.println("Hello");
        out.println("World");
        out.println("from");
        out.println("Java");
    }

    void checkSign(int a, int b, int c) {
        final int result = a + b + c;
        if (result < 0) {
            out.println("Сумма отрицательная");
            return;
        }
        out.println("Сумма положительная");
    }

    void selectColor(int data) {
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

    void compareNumbers(int a, int b) {
        if (a >= b) {
            out.println("a >= b");
            return;
        }
        out.println("a < b");
    }

    void addOrSubtractAndPrint(int a, int b, boolean increment) {
        if (increment) {
            out.println(a + b);
            return;
        }
        out.println(a - b);
    }

    public static App build(PrintStream anOut) {
        return new App(anOut);
    }

    public static void main(String[] args) {
        var app = build(System.out);
        app.greetings();
    }
}
