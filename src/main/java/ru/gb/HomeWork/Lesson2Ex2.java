package ru.gb.HomeWork;

public class Lesson2Ex2 {
    public static boolean isIncreasingSequence(int[] sequence) {
        for (int i = 1; i < sequence.length; i++) {
            if (sequence[i] <= sequence[i - 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] sequence = {1, 2, 5, 6, 9};

        boolean isIncreasing = isIncreasingSequence(sequence);
        if (isIncreasing) {
            System.out.println("Последовательность является возрастающей");
        } else {
            System.out.println("Последовательность не является возрастающей");
        }
    }

}
