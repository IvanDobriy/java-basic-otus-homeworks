package ru.otus.java.basic.homeworks.lesson15.client;

import java.io.*;
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
        void call(DataInputStream reader, DataOutputStream writer) throws IOException;
    }

    private void connect(Callback callback) {
        try (final var socket = new Socket(host, port);
             final var reader = new DataInputStream(socket.getInputStream());
             final var writer = new DataOutputStream(socket.getOutputStream());
        ) {
            callback.call(reader, writer);
        } catch (IOException e) {
            logger.warning(String.format("msg: %s, stackTrace: %s", e.getMessage(), Arrays.toString(e.getStackTrace())));
        }
    }

    private void readServerMsg(DataInputStream reader) throws IOException {
        for (int i = 0; i < 3; i++) {
            final var msg = reader.readUTF();
            System.out.println(msg);
        }
    }

    private void writeExpression(DataOutputStream writer, Scanner scanner) throws IOException {
        final var expression = scanner.nextLine();
        writer.writeUTF(expression + "\n");
        writer.flush();
    }

    private void readResult(DataInputStream reader) throws IOException {
        final var result = reader.readUTF();
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
