package ru.otus.java.basic.homeworks.lesson6;

public class Cat {
    private final String name;
    private final int appetite;
    private boolean isFull;

    public String getName() {
        return name;
    }

    public int getAppetite() {
        return appetite;
    }

    public boolean isFull() {
        return isFull;
    }

    public Cat(String name, int appetite) {
        if (appetite < 0) {
            throw new IllegalArgumentException("appetite < 0");
        }
        this.name = name;
        this.appetite = appetite;
        this.isFull = false;
    }

    public void eat(Plate plate) {
        isFull = plate.removeMeal(appetite);
    }

    @Override
    public String toString() {
        return String.format("Cat{name:%s,appetite:%d,isFull:%b}", name, appetite, isFull);
    }
}
