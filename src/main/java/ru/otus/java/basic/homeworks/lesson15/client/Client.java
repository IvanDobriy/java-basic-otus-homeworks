package ru.otus.java.basic.homeworks.lesson15.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
import java.util.logging.Logger;

public class Client {
    private final Logger logger = Logger.getLogger(this.getClass().getName());
    private final String host;
    private final int port;

    public Client(String host, int port) {
        Objects.requireNonNull(host);
        this.host = host;
        this.port = port;
    }

    interface Callback {
        void call(BufferedReader reader, OutputStreamWriter writer) throws IOException;
    }

    private void connect(Callback callback) {
        try (final var socket = new Socket(host, port);
             final var reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             final var writer = new OutputStreamWriter(socket.getOutputStream());
        ) {
            callback.call(reader, writer);
        } catch (IOException e) {
            logger.warning(String.format("msg: %s, stackTrace: %s", e.getMessage(), Arrays.toString(e.getStackTrace())));
        }
    }

    private void readServerMsg(BufferedReader reader) throws IOException {
        for (int i = 0; i < 3; i++) {
            final var msg = reader.readLine();
            System.out.println(msg);
        }
    }

    private void writeExpression(OutputStreamWriter writer, Scanner scanner) throws IOException {
        final var expression = scanner.nextLine();
        writer.write(expression + "\n");
        writer.flush();
    }

    private void readResult(BufferedReader reader) throws IOException {
        final var result = reader.readLine();
        System.out.println(result);
    }

    void run() {
        final var scanner = new Scanner(System.in);
        connect((reader, writer) -> {
            readServerMsg(reader);
            writeExpression(writer, scanner);
            readResult(reader);
        });
    }

}
