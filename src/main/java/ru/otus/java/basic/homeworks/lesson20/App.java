package ru.otus.java.basic.homeworks.lesson20;

import java.nio.file.Paths;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        final var scanner = new Scanner(System.in);
        System.out.println("Enter file path");
        final var filePathName = scanner.next();
        final var path = Paths.get(filePathName);
        System.out.println("Enter char sequence");
        final var sequence = scanner.next();
        final var finder = new Finder();
        int result = finder.count(path, sequence.toCharArray());
        System.out.println(String.format("result: %d", result));
    }
}
