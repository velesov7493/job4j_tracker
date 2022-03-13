package ru.job4j.collection;

import java.util.HashSet;
import java.util.Set;

public class Article {

    /**
     * Очищает текст от знаков препинания, заглавных букв
     * и разбивает его на слова
     *
     * @param text разбиваемый текст
     * @return слова
     */
    private static String[] textWords(String text) {
        String msg = text.toLowerCase();
        msg = msg.replaceAll("\\p{P}", "");
        return msg.split(" ");
    }

    public static boolean generateBy(String origin, String line) {
        boolean result = true;
        String[] words = textWords(origin);
        Set<String> originWords = new HashSet<>();
        for (String word : words) {
            originWords.add(word);
        }
        words = textWords(line);
        for (String word : words) {
            if (!originWords.contains(word)) {
                result = false;
                break;
            }
        }
        return result;
    }
}
