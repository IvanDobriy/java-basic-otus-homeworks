package ru.otus.java.basic.homeworks.lesson6;

public class Cat {
    private String name;
    private int appetite;

    public String getName() {
        return name;
    }

    public int getAppetite() {
        return appetite;
    }

    public boolean isFull() {
        return appetite == 0;
    }

    public Cat(String name, int appetite) {
        if (appetite < 0) {
            throw new IllegalArgumentException("appetite < 0");
        }
        this.name = name;
        this.appetite = appetite;
    }

    public void eat(Plate plate) {
        appetite -= plate.removeContent(appetite);
    }

    @Override
    public String toString(){
        return String.format("Cat{name:%s,appetite:%d}", name, appetite);
    }
}
