package ru.otus.java.basic.homeworks.lesson11;

public class Sorting {
    public static void bubbleSort(int array[]) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j +1);
                }
            }
        }
    }

    private static void swap(int array[], int first, int second) {
        int element = array[first];
        array[first] = array[second];
        array[second] = element;
    }

    private static int handlePart(int arr[], int low, int high) {
        int anchor = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < anchor) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    private static void sort(int arr[], int low, int high) {
        if (low >= high) {
            return;
        }
        int anchor = handlePart(arr, low, high);
        sort(arr, low, anchor - 1);
        sort(arr, anchor + 1, high);
    }

    public static void quickSort(int array[]) {
        sort(array, 0, array.length - 1);
    }
}
