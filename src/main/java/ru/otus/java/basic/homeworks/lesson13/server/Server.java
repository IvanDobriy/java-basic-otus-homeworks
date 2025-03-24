package ru.otus.java.basic.homeworks.lesson13.server;

import ru.otus.java.basic.homeworks.lesson13.calculator.MathCalculator;
import ru.otus.java.basic.homeworks.lesson13.parser.MathConverter;
import ru.otus.java.basic.homeworks.lesson13.parser.RpnConverter;

import java.io.*;
import java.net.ServerSocket;
import java.util.Arrays;
import java.util.Objects;
import java.util.logging.Logger;

public class Server {
    private final Logger logger = Logger.getLogger(this.getClass().getName());
    private final MathCalculator calculator;

    public Server(MathCalculator calculator) {
        Objects.requireNonNull(calculator);
        this.calculator = calculator;
    }

    void run() {
        try (final var server = new ServerSocket(8080)) {
            while (true) {
                try (final var clientSocket = server.accept();
                     BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                     OutputStreamWriter output = new OutputStreamWriter(clientSocket.getOutputStream());
                ) {
                    output.write("Enter math expression:\n");
                    final var expression = input.readLine();
                    try {
                        final var result = calculator.calculate(expression);
                        output.write(String.format("\nresult: %s\n", result.toString()));
                    } catch (RuntimeException e) {
                        output.write(String.format("\nresult: %s\n", e.getMessage()));
                    }
                } catch (IOException e) {
                    logger.warning(String.format("message: %s, stackTrace: %s", e.getMessage(), Arrays.toString(e.getStackTrace())));
                }
            }
        } catch (IOException e) {
            logger.warning(String.format("message: %s, stackTrace: %s", e.getMessage(), Arrays.toString(e.getStackTrace())));
        }
    }

    public static void main(String[] args) {
        final var server = new Server(new MathCalculator(new MathConverter(), new RpnConverter()));
        server.run();
    }
}
