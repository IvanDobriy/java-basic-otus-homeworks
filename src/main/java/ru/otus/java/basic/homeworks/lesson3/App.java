package ru.otus.java.basic.homeworks.lesson3;

import java.io.PrintStream;

public class App {
    private final PrintStream out;

    private App() {
        throw new UnsupportedOperationException(String.format("Used unsupported default %s constructor", this.getClass().getName()));
    }

    public App(PrintStream anOut) {
        out = anOut;
    }

    public int sumOfPositiveElements(int[][] elements) {
        int result = 0;
        for (int i = 0; i < elements.length; i++) {
            for (int j = 0; j < elements[i].length; j++) {
                if (elements[i][j] > 0) {
                    result += elements[i][j];
                }
            }
        }
        return result;
    }

    public void printRectangle(int size) {
        if (size < 0) {
            size *= -1;
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {

            }
        }
    }

    public static void main(String[] args) {

    }
}
