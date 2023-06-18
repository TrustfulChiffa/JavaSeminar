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
            System.arraycopy(currentPermutation, 0, permutations[permutationIndex], 0, input.length);
            permutationIndex++;  // Увеличение индекса текущей перестановки
            return;
        }

        for (int element : input) {
            if (!used[element - 1]) {
                used[element - 1] = true;
                currentPermutation[depth] = element;
                generatePermutations(input, permutations, used, currentPermutation, depth + 1);
                used[element - 1] = false;
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
        for (int[] permutation : permutations) {
            for (int element : permutation) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}
