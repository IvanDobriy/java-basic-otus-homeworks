package ru.otus.java.basic.homeworks.lesson14;

public class App {
    public static void main(String[] args) throws InterruptedException {
        var executionTime = ArrayUtils.getExecutionTime(ArrayUtils::createArray);
        System.out.println(String.format("execution time[ms]: %d", executionTime));
        executionTime = ArrayUtils.getExecutionTime(ArrayUtils::createArrayParallel);
        System.out.println(String.format("execution time[ms]: %d", executionTime));
    }
}
