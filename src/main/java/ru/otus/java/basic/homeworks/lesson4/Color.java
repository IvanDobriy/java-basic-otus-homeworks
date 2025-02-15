package ru.otus.java.basic.homeworks.lesson4;

public enum Color {
    BLACK(0, "Black"),
    WHITE(1, "White");

    private int code;
    private String name;

    Color(int aCode, String aName) {
        code = aCode;
        name = aName;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("color name: %s, code: %d", name, code);
    }
}
