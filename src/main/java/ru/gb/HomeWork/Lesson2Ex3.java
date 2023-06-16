package ru.gb.HomeWork;

import java.util.Arrays;

public class Lesson2Ex3 {
    public static void replaceNegativeElements(int[] array) {
        int sumOfIndexes = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] >= 10 && array[i] <= 99) {
                sumOfIndexes += i;
            }
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0) {
                array[i] = sumOfIndexes;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 100, 33, 44, 9, -5, -3, 23, -7};

        replaceNegativeElements(array);

        System.out.println(Arrays.toString(array));
    }

}
