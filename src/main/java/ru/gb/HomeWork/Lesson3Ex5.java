package ru.gb.HomeWork;

public class Lesson3Ex5 {
    private static int permutationIndex = 0;  // Переменная для отслеживания индекса текущей перестановки

    public static void main(String[] args) {
        int[] input = {1, 2, 3};
        int[][] permutations = generatePermutations(input);
        printPermutations(permutations);
    }

    public static int[][] generatePermutations(int[] input) {
        int totalPermutations = factorial(input.length);
        int[][] permutations = new int[totalPermutations][input.length];
        boolean[] used = new boolean[input.length];
        int[] currentPermutation = new int[input.length];
        permutationIndex = 0;  // Сброс индекса перед генерацией перестановок
        generatePermutations(input, permutations, used, currentPermutation, 0);
        return permutations;
    }

    private static void generatePermutations(int[] input, int[][] permutations, boolean[] used,
                                             int[] currentPermutation, int depth) {
        if (depth == input.length) {
            // Копирование текущей перестановки в массив перестановок
            for (int i = 0; i < input.length; i++) {
                permutations[permutationIndex][i] = currentPermutation[i];
            }
            permutationIndex++;  // Увеличение индекса текущей перестановки
            return;
        }

        for (int i = 0; i < input.length; i++) {
            if (!used[i]) {
                used[i] = true;
                currentPermutation[depth] = input[i];
                generatePermutations(input, permutations, used, currentPermutation, depth + 1);
                used[i] = false;
            }
        }
    }

    private static int factorial(int n) {
        // Рекурсивная функция для вычисления факториала числа
        if (n <= 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    private static void printPermutations(int[][] permutations) {
        // Вывод перестановок на экран
        for (int i = 0; i < permutations.length; i++) {
            System.out.print("Permutation " + (i + 1) + ": ");
            for (int j = 0; j < permutations[i].length; j++) {
                System.out.print(permutations[i][j] + " ");
            }
            System.out.println();
        }
    }
}