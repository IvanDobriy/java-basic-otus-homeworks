package ru.otus.java.basic.homeworks.lesson21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {
    private final ExecutorService executorService = Executors.newFixedThreadPool(3);
    private final Object monitor = new Object();
    private char currentCharacter = ' ';

    private void printAToConsole() {
        synchronized (monitor) {
            try {
                while (currentCharacter != ' ') {
                    monitor.wait();
                }
                System.out.print('A');
                currentCharacter = 'A';
                monitor.notifyAll();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void printBToConsole() {
        synchronized (monitor) {
            try {
                while (currentCharacter != 'A') {
                    monitor.wait();
                }
                System.out.print('B');
                currentCharacter = 'B';
                monitor.notifyAll();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }

    }

    private void printCToConsole() {
        synchronized (monitor) {
            try {
                while (currentCharacter != 'B') {
                    monitor.wait();
                }
                System.out.print('C');
                currentCharacter = ' ';
                monitor.notifyAll();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void printMsg() {
        for (int i = 0; i < 3; i++) {
            executorService.execute(this::printAToConsole);
            executorService.execute(this::printBToConsole);
            executorService.execute(this::printCToConsole);
        }
        executorService.shutdown();
    }

    public static void main(String[] args) {
        final var app = new App();
        app.printMsg();
    }
}
