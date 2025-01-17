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
        if(result < 0){
            out.println("Сумма отрицательная");
            return;
        }
        out.println("Сумма положительная");
    }

    public static App build(PrintStream anOut) {
        return new App(anOut);
    }

    public static void main(String[] args) {
        var app = build(System.out);
        app.greetings();
    }
}
