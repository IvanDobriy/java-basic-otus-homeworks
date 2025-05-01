package ru.otus.java.basic.homeworks.lesson22;

public class ArrayUtils {
    static int[] lastAfter1(int[] arr) {
        int position = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[arr.length - 1 - i] == 1) {
                position = arr.length - i;
                break;
            }
        }
        if (position < 0 || position == arr.length ) {
            throw new RuntimeException("position not found");
        }

        int[] result = new int[arr.length - position];
        for (int i = 0; i < result.length; i++) {
            result[i] = arr[position + i];
        }
        return result;
    }
}
