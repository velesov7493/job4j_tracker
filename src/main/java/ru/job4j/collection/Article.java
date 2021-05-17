package ru.job4j.collection;

import java.util.HashSet;
import java.util.Set;

public class Article {

    /**
     * Очищает текст от знаков препинания, заглавных букв
     * и разбивает его на слова
     * @param text разбиваемый текст
     * @return слова
     */

    private static String[] textWords(String text) {
        String cleanMsg = "";
        String msg = text.toLowerCase();
        char[] excessiveChars = {'.', ',', '!', '?', ':', ';', '-', '(', ')'};
        for (int i = 0; i < msg.length(); i++) {
            char check = msg.charAt(i);
            boolean skip = false;
            for (char excessive : excessiveChars) {
                if (check == excessive) {
                    skip = true;
                    break;
                }
            }
            if (!skip) {
                cleanMsg += check;
            }
        }
        return cleanMsg.split(" ");
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
