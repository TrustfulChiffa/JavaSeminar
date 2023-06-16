package ru.gb.HomeWork;

public class Lesson2Ex4 {
    public static boolean isValidSudoku(char[][] board) {
        // Проверка строк
        for (int row = 0; row < 9; row++) {
            if (!isRowValid(board, row)) {
                return false;
            }
        }

        // Проверка столбцов
        for (int col = 0; col < 9; col++) {
            if (!isColumnValid(board, col)) {
                return false;
            }
        }

        // Проверка подблоков
        for (int block = 0; block < 9; block++) {
            if (!isBlockValid(board, block)) {
                return false;
            }
        }

        return true;
    }

    private static boolean isRowValid(char[][] board, int row) {
        boolean[] used = new boolean[9];
        for (int col = 0; col < 9; col++) {
            char c = board[row][col];
            if (c != '.') {
                int digit = c - '0';
                if (used[digit - 1]) {
                    return false;
                }
                used[digit - 1] = true;
            }
        }
        return true;
    }

    private static boolean isColumnValid(char[][] board, int col) {
        boolean[] used = new boolean[9];
        for (int row = 0; row < 9; row++) {
            char c = board[row][col];
            if (c != '.') {
                int digit = c - '0';
                if (used[digit - 1]) {
                    return false;
                }
                used[digit - 1] = true;
            }
        }
        return true;
    }

    private static boolean isBlockValid(char[][] board, int block) {
        boolean[] used = new boolean[9];
        int startRow = (block / 3) * 3;
        int startCol = (block % 3) * 3;
        for (int row = startRow; row < startRow + 3; row++) {
            for (int col = startCol; col < startCol + 3; col++) {
                char c = board[row][col];
                if (c != '.') {
                    int digit = c - '0';
                    if (used[digit - 1]) {
                        return false;
                    }
                    used[digit - 1] = true;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        System.out.println("Validate: " + isValidSudoku(board));
    }

}
