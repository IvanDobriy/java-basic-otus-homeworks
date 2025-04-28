package ru.otus.java.basic.homeworks.lesson20;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Objects;

public class Finder {
    int count(Path path, char[] sequence) {
        Objects.requireNonNull(sequence);
        if (sequence.length == 0) {
            return 0;
        }
        int counter = 0;
        try (final var reader = new FileReader(path.toFile())) {
            int character;
            while (true) {
                boolean exists = true;
                for (char el : sequence) {
                    if ((character = reader.read()) == -1) {
                        return counter;
                    }
                    if (el != (char) character) {
                        exists = false;
                        break;
                    }
                }
                if (exists) {
                    counter++;
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
