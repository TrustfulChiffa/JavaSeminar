package ru.gb.HomeWork;


public class Lesson3Ex2 {
    public static void main(String[] args) {
        // Заданный массив записей
        String[][] products = {
                {"Товар 1", "Россия", "500 г", "100", "1-й сорт"},
                {"Товар 2", "США", "1 кг", "200", "2-й сорт"},
                {"Товар 3", "Германия", "750 г", "300", "1-й сорт"},
                {"Товар 4", "Франция", "500 г", "400", "2-й сорт"},
                {"Товар 5", "Италия", "1 кг", "500", "1-й сорт"},
        };

        // Заданный сорт товара
        String desiredSort = "2-й сорт";

        // Переменные для хранения наименьшей цены и соответствующего наименования товара
        int minPrice = Integer.MAX_VALUE;
        String name = "";

        // Поиск наименьшей цены среди товаров заданного сорта
        for (String[] product : products) {
            String productName = product[0];
            String sort = product[4];
            int price = Integer.parseInt(product[3]);

            if (sort.equals(desiredSort) && price < minPrice) {
                minPrice = price;
                name = productName;
            }
        }

        // Вывод результата
        if (!name.isEmpty()) {
            System.out.println("Наименование товара заданного сорта с наименьшей ценой:");
            System.out.println("Наименование: " + name);
            System.out.println("Цена: " + minPrice);
        } else {
            System.out.println("Товары заданного сорта не найдены.");
        }
    }
}
