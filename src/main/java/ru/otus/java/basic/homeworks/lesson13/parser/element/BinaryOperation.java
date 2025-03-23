package ru.otus.java.basic.homeworks.lesson13.parser.element;

public class BinaryOperation extends Element {
    public Number execute(Number left, Number right) {
        throw new RuntimeException("unsupported operation");
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
