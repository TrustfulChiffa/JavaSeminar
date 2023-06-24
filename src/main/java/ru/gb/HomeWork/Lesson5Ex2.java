package ru.gb.HomeWork;

import java.util.*;

public class Lesson5Ex2 {
    public static void main(String[] args) {
        List<String> employees = Arrays.asList(
                "Иван Иванов",
                "Светлана Петрова",
                "Кристина Белова",
                "Анна Мусина",
                "Анна Крутова",
                "Иван Юрин",
                "Петр Лыков",
                "Павел Чернов",
                "Петр Чернышов",
                "Мария Федорова",
                "Марина Светлова",
                "Мария Савина",
                "Мария Рыкова",
                "Марина Лугова",
                "Анна Владимирова",
                "Иван Мечников",
                "Петр Петин",
                "Иван Ежов"
        );

        // Создание Map для подсчета количества повторений имен
        Map<String, Integer> nameCountMap = new HashMap<>();

        // Подсчет количества повторений имен
        for (String employee : employees) {
            String name = employee.split(" ")[0]; // Получение имени из строки сотрудника
            nameCountMap.put(name, nameCountMap.getOrDefault(name, 0) + 1);
        }

        // Сортировка Map по убыванию значения (количества повторений)
        List<Map.Entry<String, Integer>> sortedEntries = new ArrayList<>(nameCountMap.entrySet());
        sortedEntries.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        // Вывод повторяющихся имен с количеством повторений
        for (Map.Entry<String, Integer> entry : sortedEntries) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey() + " - " + entry.getValue());
            }
        }
    }
}
