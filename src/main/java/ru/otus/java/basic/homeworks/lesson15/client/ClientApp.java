package ru.otus.java.basic.homeworks.lesson15.client;

import ru.otus.java.basic.homeworks.lesson13.client.Client;

public class ClientApp {
    public static void main(String[] args) throws InterruptedException {
        final var client = new Client("localhost", 8080);
        client.run();
    }
}
