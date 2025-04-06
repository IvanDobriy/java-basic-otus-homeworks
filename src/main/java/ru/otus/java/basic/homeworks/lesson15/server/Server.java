package ru.otus.java.basic.homeworks.lesson15.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.util.Arrays;
import java.util.logging.Logger;

public class Server {
    private final Logger logger = Logger.getLogger(this.getClass().getName());
    private final int port;

    interface Callback {
        void call(BufferedReader input, OutputStreamWriter output) throws IOException;
    }

    public Server(int port) {
        this.port = port;
    }

    private void withErrorHandling(Callback callback) {
        try (final var server = new ServerSocket(port)) {
            while (true) {
                try (final var clientSocket = server.accept();
                     BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                     OutputStreamWriter output = new OutputStreamWriter(clientSocket.getOutputStream());
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

    private void sendMsg(OutputStreamWriter output, String msg) throws IOException {
        output.write(msg);
        output.flush();
    }

    private String receiveMathExpression(BufferedReader input) throws IOException {
        return input.readLine();
    }


    void run() {
        withErrorHandling((input, output) -> {
            sendMsg(output, "hello");
        });
    }

}
