package ru.otus.java.basic.homeworks.lesson12;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        final var handler = new FileHandler("./");
        while (true){
            final var files = handler.getTextFiles();
            handler.printFileList(files);
            if(files.isEmpty()){
                break;
            }
            final var selectedFile = handler.selectFile(files);
            handler.printFileContent(selectedFile);
            handler.enterText(selectedFile);
        }
    }
}
