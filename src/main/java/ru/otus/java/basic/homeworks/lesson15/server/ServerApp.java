package ru.otus.java.basic.homeworks.lesson15.server;

public class ServerApp {
    public static void main(String[] args){
        final var serve = new Server(8080);
        serve.run();
    }
}
