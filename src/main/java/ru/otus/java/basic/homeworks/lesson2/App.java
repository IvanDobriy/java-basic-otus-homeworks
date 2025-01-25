package ru.otus.java.basic.homeworks.lesson2;

import java.io.InputStream;
import java.io.PrintStream;

public class App {
    private App() {
        throw new UnsupportedOperationException(String.format("Used unsupported default %s constructor", this.getClass().getName()));
    }

    public static App build(PrintStream anOut) {
        return new App(anOut);
    }

    private final PrintStream out;

    private App(PrintStream anOut) {
        out = anOut;
    }

    void printString(int times, String string) {
        for (int i = 0; i < times; i++) {
            out.print(string);
        }
        out.println();
    }

    public static void main(String[] args) {

    }
}