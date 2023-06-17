package ru.gb.HomeWork;

public class Lesson3Ex1 {
    public static void main(String[] args) {
        // Заданный массив записей
        String[][] products = {
                {"Товар 1", "100", "1-й сорт"},
                {"Товар 2", "200", "2-й сорт"},
                {"Товар 3 высший", "300", "1-й сорт"},
                {"Товар 4 высший", "400", "2-й сорт"},
                {"Товар 5", "500", "1-й сорт"},
                {"Товар 6 высший", "800", "3-й сорт"},
        };

        // Переменные для хранения максимальной цены и соответствующего наименования товара
        int maxPrice = 0;
        String name = "";

        // Поиск максимальной цены среди товаров с указанными условиями
        for (String[] product : products) {
            String productName = product[0];
            int price = Integer.parseInt(product[1]);
            String grade = product[2];

            if ((grade.equals("1-й сорт") || grade.equals("2-й сорт")) && productName.contains("высший")) {
                if (price > maxPrice) {
                    maxPrice = price;
                    name = productName;
                }
            }
        }

        // Вывод результата
        if (maxPrice > 0) {
            System.out.println("Наибольшая цена товаров 1-го или 2-го сорта среди товаров, название которых содержит 'высший':");
            System.out.println("Наименование: " + name);
            System.out.println("Цена: " + maxPrice);
        } else {
            System.out.println("Товары не найдены.");
        }
    }
}
