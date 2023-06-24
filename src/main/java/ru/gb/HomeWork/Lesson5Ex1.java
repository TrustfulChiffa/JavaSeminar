package ru.gb.HomeWork;

import java.util.HashMap;
import java.util.Map;

public class Lesson5Ex1 {
    public static void main(String[] args) {
        String text = "Россия идет вперед всей планеты. Планета — это не Россия.";
        String wordToCount = "Россия";

        // Удаление пунктуации и приведение к нижнему регистру
        text = text.replaceAll("\\p{Punct}", "").toLowerCase();

        // Разделение текста на отдельные слова
        String[] words = text.split("\\s+");

        // Создание Map для подсчета количества слов
        Map<String, Integer> wordCountMap = new HashMap<>();

        // Подсчет количества слов
        for (String word : words) {
            if (wordCountMap.containsKey(word)) {
                // Если слово уже есть в Map, увеличиваем счетчик
                int count = wordCountMap.get(word);
                wordCountMap.put(word, count + 1);
            } else {
                // Если слова нет в Map, добавляем его со значением 1
                wordCountMap.put(word, 1);
            }
        }

        // Получение количества искомого слова
        int count = wordCountMap.getOrDefault(wordToCount.toLowerCase(), 0);

        // Вывод результата
        System.out.println(wordToCount + " - " + count);
    }
}
