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
                out.print('*');
            }
            out.println();
        }
    }

    public void eye(int[][] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            arr[i][i] = value;
        }
    }

    public int findMax(int[][] arr) {
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                var el = arr[i][j];
                if (result < el) {
                    result = el;
                }
            }
        }
        return result;
    }

    public int lineSum(int[][] arr, int pos, boolean isRow) {
        if (pos < 0) {
            pos *= -1;
        }
        if (arr.length == 0) {
            return -1;
        }
        if (isRow && arr.length <= pos) {
            return -1;
        }
        int result = 0;
        if (isRow) {
            for (int i = 0; i < arr[pos].length; i++) {
                result += arr[pos][i];
            }
            return result;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length <= pos) {
                return -1;
            }
            result += arr[i][pos];
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
