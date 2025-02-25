package ru.otus.java.basic.homeworks.lesson8;

public class App {
    public static void main(String[] args) throws AppArrayDataException {
        final String[][] data = {
                {"1", "2 ", " 3", "  4  "},
                {"1", "2 ", " 3", "  4  "},
                {"1", "2 ", " 3", "  4  "},
                {"1", "2 ", " 3", "  4  "}
        };
        int result = ArrayUtils.sum(data);
        System.out.println(String.format("input arr: %s, result: %d", ArrayUtils.toString(data), result));
    }
}
