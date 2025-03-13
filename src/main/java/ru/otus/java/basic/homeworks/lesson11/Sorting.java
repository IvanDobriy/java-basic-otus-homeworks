package ru.otus.java.basic.homeworks.lesson11;

public class Sorting {
    public static void bubbleSort(int array[]) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int element = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = element;
                }
            }
        }
    }

    public static void quickSort(int array[]) {

    }
}
