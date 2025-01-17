package ru.otus.java.basic.homeworks.lesson1;

import java.io.PrintStream;

public class App {
    private final PrintStream out;

    private App(PrintStream anOut) {
        out = anOut;
    }

    void greetings() {
        out.println("Hello");
        out.println("World");
        out.println("from");
        out.println("Java");
    }

    public static App build(PrintStream anOut) {
        return new App(anOut);
    }

    public static void main(String[] args) {
        var app = build(System.out);
        app.greetings();
    }
}
