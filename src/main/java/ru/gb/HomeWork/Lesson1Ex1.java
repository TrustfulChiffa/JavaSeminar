package ru.gb.HomeWork;

import java.util.Scanner;
public class Lesson1Ex1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строку: ");
        String s = scanner.nextLine();
        String reversedWords = reverseWords(s);
        System.out.println("Перевернутая строка: " + reversedWords);
    }

    public static String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
        StringBuilder reversed = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            reversed.append(words[i]);
            if (i > 0) {
                reversed.append(" ");
            }
        }

        return reversed.toString();
    }
}
