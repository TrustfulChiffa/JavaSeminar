package ru.gb.HomeWork;

import java.util.Scanner;

public class Lesson4Ex2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите строку: ");
        String s = scanner.nextLine();

        boolean isValid = isValidParentheses(s);
        System.out.println("Результат: " + isValid);
    }

    public static boolean isValidParentheses(String s) {
        if (s.length() % 2 != 0) {
            return false; // Если длина строки нечетная, то она точно недопустимая
        }

        char[] stack = new char[s.length()]; // Массив для имитации стека
        int top = -1; // Индекс верхнего элемента стека

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack[++top] = c; // Добавляем открывающую скобку в стек
            } else if (c == ')' && (top == -1 || stack[top--] != '(')) {
                return false; // Несоответствие закрывающей скобки
            } else if (c == '}' && (top == -1 || stack[top--] != '{')) {
                return false; // Несоответствие закрывающей скобки
            } else if (c == ']' && (top == -1 || stack[top--] != '[')) {
                return false; // Несоответствие закрывающей скобки
            }
        }

        return top == -1; // Если все открывающие скобки закрыты, стек должен быть пустым
    }
}
