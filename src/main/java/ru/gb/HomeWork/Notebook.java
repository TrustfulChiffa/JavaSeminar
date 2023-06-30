package ru.gb.HomeWork;

import java.util.*;

public class Notebook {
    private String brand;
    private int ram;
    private int storage;
    private String os;
    private String color;

    public Notebook(String brand, int ram, int storage, String os, String color) {
        this.brand = brand;
        this.ram = ram;
        this.storage = storage;
        this.os = os;
        this.color = color;
    }

    // Геттеры для доступа к полям класса

    public String getBrand() {
        return brand;
    }

    public int getRam() {
        return ram;
    }

    public int getStorage() {
        return storage;
    }

    public String getOs() {
        return os;
    }

    public String getColor() {
        return color;
    }

    // Метод для фильтрации ноутбуков

    public static List<Notebook> filterNotebooks(Set<Notebook> notebooks, Map<String, Object> filters) {
        List<Notebook> filteredNotebooks = new ArrayList<>();

        for (Notebook notebook : notebooks) {
            boolean meetsCriteria = true;

            for (Map.Entry<String, Object> entry : filters.entrySet()) {
                String filterKey = entry.getKey();
                Object filterValue = entry.getValue();

                if (filterKey.equals("brand")) {
                    if (!notebook.getBrand().equals(filterValue)) {
                        meetsCriteria = false;
                        break;
                    }
                } else if (filterKey.equals("ram")) {
                    if (notebook.getRam() < (int) filterValue) {
                        meetsCriteria = false;
                        break;
                    }
                } else if (filterKey.equals("storage")) {
                    if (notebook.getStorage() < (int) filterValue) {
                        meetsCriteria = false;
                        break;
                    }
                } else if (filterKey.equals("os")) {
                    if (!notebook.getOs().equals(filterValue)) {
                        meetsCriteria = false;
                        break;
                    }
                } else if (filterKey.equals("color")) {
                    if (!notebook.getColor().equals(filterValue)) {
                        meetsCriteria = false;
                        break;
                    }
                }
            }

            if (meetsCriteria) {
                filteredNotebooks.add(notebook);
            }
        }

        return filteredNotebooks;
    }

    public static void main(String[] args) {
        // Создание множества ноутбуков
        Set<Notebook> notebooks = new HashSet<>();
        notebooks.add(new Notebook("Dell", 8, 256, "Windows 10", "Black"));
        notebooks.add(new Notebook("HP", 16, 512, "Windows 11", "Silver"));
        notebooks.add(new Notebook("Apple", 16, 512, "macOS", "Space Gray"));
        notebooks.add(new Notebook("Lenovo", 12, 256, "Windows 10", "Black"));

        // Запрос критериев фильтрации от пользователя
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите цифру, соответствующую критерию фильтрации:");
        System.out.println("1 - Бренд");
        System.out.println("2 - ОЗУ");
        System.out.println("3 - Объем ЖД");
        System.out.println("4 - Операционная система");
        System.out.println("5 - Цвет");

        int filterCriteria = scanner.nextInt();
        scanner.nextLine();

        Map<String, Object> filters = new HashMap<>();

        switch (filterCriteria) {
            case 1:
                System.out.println("Введите бренд:");
                String brand = scanner.nextLine();
                filters.put("brand", brand);
                break;
            case 2:
                System.out.println("Введите минимальное значение ОЗУ:");
                int minRam = scanner.nextInt();
                filters.put("ram", minRam);
                break;
            case 3:
                System.out.println("Введите минимальное значение объема ЖД:");
                int minStorage = scanner.nextInt();
                filters.put("storage", minStorage);
                break;
            case 4:
                System.out.println("Введите операционную систему:");
                String os = scanner.nextLine();
                filters.put("os", os);
                break;
            case 5:
                System.out.println("Введите цвет:");
                String color = scanner.nextLine();
                filters.put("color", color);
                break;
            default:
                System.out.println("Некорректный выбор критерия фильтрации.");
                return;
        }

        // Фильтрация и вывод результатов
        List<Notebook> filteredNotebooks = filterNotebooks(notebooks, filters);

        if (filteredNotebooks.isEmpty()) {
            System.out.println("Ноутбуки, отвечающие заданным критериям, не найдены.");
        } else {
            System.out.println("Результаты фильтрации:");
            for (Notebook notebook : filteredNotebooks) {
                System.out.println("Бренд: " + notebook.getBrand());
                System.out.println("ОЗУ: " + notebook.getRam() + " ГБ");
                System.out.println("Объем ЖД: " + notebook.getStorage() + " ГБ");
                System.out.println("Операционная система: " + notebook.getOs());
                System.out.println("Цвет: " + notebook.getColor());
                System.out.println();
            }
        }
    }
}
