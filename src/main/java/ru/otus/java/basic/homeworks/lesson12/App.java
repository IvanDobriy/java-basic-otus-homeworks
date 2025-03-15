package ru.otus.java.basic.homeworks.lesson12;

import java.util.Objects;

public class App {
    private final FileHandler fileHandler;

    public App(FileHandler fileHandler) {
        Objects.requireNonNull(fileHandler);
        this.fileHandler = fileHandler;
    }

    public void run() {
        try {
            do {
                final var files = fileHandler.getTextFiles();
                fileHandler.printFileList(files);
                if (files.isEmpty()) {
                    break;
                }
                final var selectedFile = fileHandler.selectFile(files);
                fileHandler.printFileContent(selectedFile);
                fileHandler.enterText(selectedFile);
            } while (fileHandler.needContinue());
        } catch (Exception exception) {
            exception.getStackTrace();
        }
    }

    public static void main(String[] args) {
        final var handler = new FileHandler("./");
        final var app = new App(handler);
        app.run();
    }
}
