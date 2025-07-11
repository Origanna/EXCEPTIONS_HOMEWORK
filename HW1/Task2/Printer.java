package HW1.Task2;

import java.util.Arrays;

class Answer {
    public static int[] mergeAndValidateArrays(int[] a, int[] b) {
        if (a.length != b.length) {
            throw new IllegalArgumentException("Длины массивов не равны");
        }
        int[] mergedArray = new int[a.length + b.length];
        System.arraycopy(a, 0, mergedArray, 0, a.length);
        System.arraycopy(b, 0, mergedArray, a.length, b.length);
        for (int num : mergedArray) {
            if (num < 0) {
                throw new RuntimeException("Обнаружен отрицательный элемент");
            }
        }
        return mergedArray;
    }
}

public class Printer {
    public static void main(String[] args) {
        try {
            int[] a = { 1, 2, 3 };
            int[] b = { 4, 5, 6 };
            int[] result = Answer.mergeAndValidateArrays(a, b);
            System.out.println(Arrays.toString(result));
        } catch (IllegalArgumentException e) {
            System.out.println("Длины массивов не равны");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        try {
            int[] c = { 1, 2 };
            int[] d = { 3, 4, 5 };
            System.out.println(Arrays.toString(Answer.mergeAndValidateArrays(c, d)));
        } catch (IllegalArgumentException e) {
            System.out.println("Длины массивов не равны");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        try {
            int[] e = { -1, 2, 3 };
            int[] f = { 4, 5, 6 };
            System.out.println(Arrays.toString(Answer.mergeAndValidateArrays(e, f)));
        } catch (IllegalArgumentException e) {
            System.out.println("Длины массивов не равны");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
