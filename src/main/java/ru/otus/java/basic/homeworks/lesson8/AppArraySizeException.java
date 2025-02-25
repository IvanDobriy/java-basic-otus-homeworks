package ru.otus.java.basic.homeworks.lesson8;

public class AppArraySizeException extends RuntimeException {
    private final String[][] arr;

    public AppArraySizeException(String[][] arr) {
        super("arr must be 4x4");
        this.arr = arr;
    }

    public String[][] getArr() {
        return arr;
    }
}
