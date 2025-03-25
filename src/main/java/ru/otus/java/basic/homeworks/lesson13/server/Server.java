package ru.otus.java.basic.homeworks.lesson13.server;

import ru.otus.java.basic.homeworks.lesson13.calculator.MathCalculator;
import ru.otus.java.basic.homeworks.lesson13.parser.MathConverter;
import ru.otus.java.basic.homeworks.lesson13.parser.RpnConverter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.util.Arrays;
import java.util.Objects;
import java.util.logging.Logger;

public class Server {
    private final Logger logger = Logger.getLogger(this.getClass().getName());
    private final MathCalculator calculator;
    private final String INVITATION = "Supported operations: +,-,*,/\n" +
            "Example: 1.2 + 12*(33.55-6.6)/2\n" +
            "Enter math expression:\n";

    private final int port;

    interface Callback {
        void call(BufferedReader input, OutputStreamWriter output) throws IOException;
    }

    public Server(MathCalculator calculator, int port) {
        Objects.requireNonNull(calculator);
        this.calculator = calculator;
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

    private void handleExpression(OutputStreamWriter output, String expression) throws IOException {
        try {
            final var result = calculator.calculate(expression);
            sendMsg(output, String.format("result: %s\n", result.toString()));
        } catch (RuntimeException e) {
            sendMsg(output, String.format("result: %s\n", e.getMessage()));
        }
    }

    void run() {
        withErrorHandling((input, output) -> {
            sendMsg(output, INVITATION);
            final var expression = receiveMathExpression(input);
            handleExpression(output, expression);
        });
    }

    public static void main(String[] args) {
        final var calculator = new MathCalculator(new MathConverter(), new RpnConverter());
        final var server = new Server(calculator, 8080);
        server.run();
    }
}
