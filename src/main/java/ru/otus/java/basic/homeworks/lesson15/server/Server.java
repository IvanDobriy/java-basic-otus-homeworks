package ru.otus.java.basic.homeworks.lesson15.server;

import java.io.*;
import java.net.ServerSocket;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.logging.Logger;

public class Server {
    private final Logger logger = Logger.getLogger(this.getClass().getName());
    private final int port;

    interface Callback {
        void call(DataInputStream input, DataOutputStream output) throws IOException;
    }

    public Server(int port) {
        this.port = port;
    }

    private void withErrorHandling(Callback callback) {
        try (final var server = new ServerSocket(port)) {
            while (true) {
                try (final var clientSocket = server.accept();
                     DataInputStream input = new DataInputStream(clientSocket.getInputStream());
                     DataOutputStream output = new DataOutputStream(clientSocket.getOutputStream());
                ) {
                    callback.call(input, output);
                } catch (IOException e) {
                    logger.warning(String.format("message: %s, stackTrace: %s", e.getMessage(), Arrays.toString(e.getStackTrace())));
                }
            }
        } catch (IOException e) {
            logger.warning(String.format("message: %s, stackTrace: %s", e.getMessage(), Arrays.toString(e.getStackTrace())));
        }
    }

    private void sendMsg(DataOutputStream output, String msg) throws IOException {
        output.write(msg.getBytes(StandardCharsets.UTF_8));
    }


    void run() {
        withErrorHandling((input, output) -> {
            sendMsg(output, "hello");
        });
    }
}
