package ru.otus.java.basic.homeworks.lesson9.exceptions;

public class RangeCreationException extends RuntimeException {
    private int min;
    private int max;

    public int getMax() {
        return max;
    }

    public int getMin() {
        return min;
    }

    public RangeCreationException(int min, int max) {
        super(String.format("Can`t create range with current parameters: [min: %d, max: %d]", min, max));
        this.min = min;
        this.max = max;
    }
}
