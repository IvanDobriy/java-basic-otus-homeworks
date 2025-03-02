package ru.otus.java.basic.homeworks.lesson8;

import java.util.Arrays;
import java.util.logging.Logger;

public class App {
    public static void main(String[] args) {
        final var logger = Logger.getLogger(App.class.getName());
        final String[][] data = {
                {"1", "2 ", " 3", "  4  "},
                {"1", "2 ", " 3", "  4  "},
                {"1", "2 ", " 3", "  4  "},
                {"1", "2 ", " 3", "  4  "}
        };

        try {
            int result = ArrayUtils.sum(data);
            System.out.println(String.format("input arr: %s, result: %d", ArrayUtils.toString(data), result));
        } catch (Throwable cause) {
            logger.warning(String.format("Unexpected exception: %s, %s", cause, Arrays.toString(cause.getStackTrace())));
        }
    }
}
