package ru.otus.java.basic.homeworks.lesson22;

import java.util.Set;

public class ArrayUtils {
    static int[] lastAfter1(int[] arr) {
        int position = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[arr.length - 1 - i] == 1) {
                position = arr.length - i;
                break;
            }
        }
        if (position < 0 || position == arr.length) {
            throw new RuntimeException("position not found");
        }

        int[] result = new int[arr.length - position];
        for (int i = 0; i < result.length; i++) {
            result[i] = arr[position + i];
        }
        return result;
    }

    static boolean checkIn(Set<Integer> set, int[] arr) {
        if(arr.length < set.size()){
            throw new IllegalArgumentException("arr.length < set.size");
        }
        int result = set.size();
        for (int i = 0; i < arr.length; i++) {
            if (set.contains(arr[i])) {
                result--;
            }
            if (result == 0) {
                return true;
            }
        }
        return result == 0;
    }
}
