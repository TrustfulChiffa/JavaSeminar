package ru.gb.HomeWork;

public class Lesson3Ex3 {
    public static void main(String[] args) {
        // Заданный массив записей о книгах
        String[][] books = {
                {"Книга 1", "Иванов", "100", "2009", "101"},
                {"Книга 2", "Сидоров", "200", "2010", "103"},
                {"Книга 3", "Иванов", "300", "2011", "111"},
                {"Книга 4", "Иванов", "400", "2012", "109"},
                {"Книга 5", "Иванов", "500", "2013", "137"},
        };

        // Перебор книг и поиск соответствующих условиям
        for (String[] book : books) {
            String title = book[0];
            String author = book[1];
            int price = Integer.parseInt(book[2]);
            int year = Integer.parseInt(book[3]);
            int pageCount = Integer.parseInt(book[4]);

            boolean isPrimePageCount = isPrime(pageCount);
            boolean hasLetterA = author.contains("А") || author.contains("а") ||
                    author.contains("A") || author.contains("a"); // На случай, если автор будет написал кирилицей или латиницей
            boolean isAfter2010 = year >= 2010;

            if (isPrimePageCount && hasLetterA && isAfter2010) {
                System.out.println("Название: " + title);
            }
        }
    }

    // Метод для проверки, является ли число простым
    private static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
