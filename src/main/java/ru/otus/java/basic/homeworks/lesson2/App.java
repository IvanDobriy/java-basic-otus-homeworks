package ru.otus.java.basic.homeworks.lesson2;

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

    void sum(int[] elements) {
        var result = 0;
        for (int i = 0; i < elements.length; i++) {
            var element = elements[i];
            if (element > 5) {
                result += element;
            }
        }
        out.println(result);
    }

    void fill(int value, int[] elements) {
        for (int i = 0; i < elements.length; i++) {
            elements[i] = value;
        }
    }

    void add(int value, int[] elements) {
        for (int i = 0; i < elements.length; i++) {
            elements[i] += value;
        }
    }

    void largestPartSum(int[] elements) {
        if (elements.length < 2) {
            out.println();
            return;
        }

        int firstHalfEnd = 0;
        int secondHalfBegin = 0;

        if (elements.length % 2 == 0) {
            firstHalfEnd = secondHalfBegin = elements.length / 2;
        } else {
            firstHalfEnd = elements.length / 2;
            secondHalfBegin = firstHalfEnd + 1;
        }

        int firstHalfSum = 0;
        for (int i = 0; i < firstHalfEnd; i++) {
            firstHalfSum += elements[i];
        }

        int secondHalfSum = 0;
        for (int i = secondHalfBegin; i < elements.length; i++) {
            secondHalfSum += elements[i];
        }

        if (firstHalfSum > secondHalfSum) {
            out.println(firstHalfSum);
            return;
        }
        out.println(secondHalfSum);
    }

    public static void main(String[] args) {

    }
}