package ru.otus.java.basic.homeworks.lesson8;

public class AppArrayDataException extends Exception {
    private final String value;
    private final int row;
    private final int col;
    private final String[][] arr;

    public AppArrayDataException(String[][] arr, String value, int row, int col, Throwable cause) {
        super(String.format("Can`t parse el:%s to int for [%d, %d] element", value, row, col), cause);
        this.arr = arr;
        this.value = value;
        this.row = row;
        this.col = col;
    }

    public String getValue() {
        return value;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

}
