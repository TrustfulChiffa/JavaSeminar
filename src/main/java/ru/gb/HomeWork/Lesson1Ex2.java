package ru.gb.HomeWork;

import java.util.Scanner;

public class Lesson1Ex2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        int prevNumber = scanner.nextInt();

        while (prevNumber != 0) {
            int currentNumber = scanner.nextInt();
            if (prevNumber > 0 && currentNumber < 0) {
                sum += prevNumber;
            }
            prevNumber = currentNumber;
        }

        System.out.println("Сумма: " + sum);
    }

}
