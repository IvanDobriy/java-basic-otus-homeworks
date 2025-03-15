package ru.otus.java.basic.homeworks.lesson12;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class FileHandler {
    private Path rootPath;

    public FileHandler(String uri) {
        Objects.requireNonNull(uri);
        final var path = Paths.get(uri);
        if (!path.toFile().isDirectory()) {
            throw new RuntimeException(String.format("file with uri: %s must be a directory", uri));
        }
        rootPath = path;
    }

    public List<File> getTextFiles() {
        final var file = rootPath.toFile();
        final var content = file.listFiles();
        if (content == null) {
            return List.of();
        }
        final var result = new ArrayList<File>();
        for (File f : content) {
            if (f.isFile() && f.getName().toLowerCase().endsWith(".txt")) {
                result.add(f);
            }
        }
        return result;
    }

    public void printFileList(List<File> files) {
        System.out.println(String.format("%s", "Files:"));
        for (File file : files) {
            System.out.println(String.format("%s", file.getName()));
        }
    }

    public File selectFile(List<File> files) {
        final var scanner = new Scanner(System.in);
        File selectedFile = null;
        do {
            System.out.println(String.format("%s", "Chose file to work:"));
            final var fileName = scanner.next().trim().toLowerCase();
            for (File file : files) {
                if (file.getName().trim().toLowerCase().contains(fileName)) {
                    selectedFile = file;
                    break;
                }
            }
        } while (selectedFile == null);
        return selectedFile;
    }

    public void printFileContent(File file) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
    }

    public void enterText(File file) throws IOException {
        final var scanner = new Scanner(System.in);
        System.out.println("Enter some test: ");
        final var text = scanner.next();
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true)))) {
            writer.write(text);
        }
    }

}
