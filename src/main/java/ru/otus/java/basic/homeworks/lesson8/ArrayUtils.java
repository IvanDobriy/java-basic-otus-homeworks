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

    public static String toString(String[][] arr) {
        final var result = new StringBuilder();
        result.append("[");
        for (int i = 0; i < arr.length; i++) {
            result.append("[");
            for (int j = 0; j < arr[i].length; j++) {
                result.append(String.format("'%s'", arr[i][j]));
                if(j < arr[i].length - 1){
                    result.append(", ");
                }
            }
            result.append("]");
            if(i < arr.length - 1){
                result.append(", ");
            }
        }
        result.append("]");
        return result.toString();
    }
}
