package ru.otus.java.basic.homeworks.lesson8;

public class ArrayUtils {
    public static int sum(String[][] arr) throws AppArrayDataException {
        if (arr.length != 4) {
            throw new AppArraySizeException(arr);
        }
        int result = 0;
        for (int row = 0; row < arr.length; row++) {
            String[] subArr = arr[row];
            if (subArr.length != 4) {
                throw new AppArraySizeException(arr);
            }
            for (int col = 0; col < subArr.length; col++) {
                String el = subArr[col].trim();
                try {
                    result += Integer.parseInt(el);
                } catch (NumberFormatException e) {
                    throw new AppArrayDataException(arr, el, row, col, e);
                }
            }
        }
        return result;
    }
}
