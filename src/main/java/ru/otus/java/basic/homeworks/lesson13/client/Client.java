package ru.otus.java.basic.homeworks.lesson13.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Logger;

public class Client {
    private final Logger logger = Logger.getLogger(this.getClass().getName());

    void run() {
        final var scanner = new Scanner(System.in);
        try (final var socket = new Socket("localhost", 8080);
             final var reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             final var writer = new OutputStreamWriter(socket.getOutputStream());
        ) {
            final var msg = reader.readLine();
            System.out.println(msg);
            final var expression = scanner.nextLine();
            writer.write(expression + "\n");
            writer.flush();
            final var result = reader.readLine();
            System.out.println(result);
        } catch (IOException e) {
            logger.warning(String.format("msg: %s, stackTrace: %s", e.getMessage(), Arrays.toString(e.getStackTrace())));
        }
    }

    static public void main(String[] args) {
        final var client = new Client();
        client.run();
    }
}
