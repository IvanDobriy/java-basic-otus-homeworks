package ru.otus.java.basic.homeworks.lesson6;

public class Plate {
    private final int capacity;
    private int currentAmount;

    public int getCapacity() {
        return capacity;
    }

    public int getCurrentAmount() {
        return currentAmount;
    }

    public Plate(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("capacity < 0");
        }
        this.capacity = capacity;
        this.currentAmount = capacity;
    }

    public void addMeal(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("amount < 0");
        }
        int newAmount = currentAmount + amount;
        currentAmount = Math.min(newAmount, capacity);
    }

    public boolean removeMeal(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("amount < 0");
        }
        final var newAmount = currentAmount - amount;
        if (newAmount < 0) {
            return false;
        }
        currentAmount = newAmount;
        return true;
    }

    @Override
    public String toString() {
        return String.format("Plate{capacity:%d,currentAmount:%d}", capacity, currentAmount);
    }
}
