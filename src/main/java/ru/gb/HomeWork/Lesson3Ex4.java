package ru.gb.HomeWork;

public class Lesson3Ex4 {
    public static void main(String[] args) {
        int[] list = {5, 2, 9, 1, 7};

        int min = list[0];
        int max = list[0];
        int sum = list[0];

        for (int i = 1; i < list.length; i++) {
            if (list[i] < min) {
                min = list[i];
            }
            if (list[i] > max) {
                max = list[i];
            }
            sum += list[i];
        }

        double average = (double) sum / list.length;

        System.out.println("Минимальное: " + min);
        System.out.println("Максимальное: " + max);
        System.out.println("Среднее: " + average);
    }
}
