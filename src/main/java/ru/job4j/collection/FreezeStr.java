package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class FreezeStr {

    private static Map<Character, Integer> charCounts(String text) {
        HashMap<Character, Integer> result = new HashMap<>();
        for (int i = 0; i < text.length(); i++) {
            char current = text.charAt(i);
            if (result.containsKey(current)) {
                int count = result.get(current) + 1;
                result.put(current, count);
            } else {
                result.put(current, 1);
            }
        }
        return result;
    }

    private static boolean compareCharCounts(String text, Map<Character, Integer> counts) {
        boolean result = true;
        for (int i = 0; i < text.length(); i++) {
            char current = text.charAt(i);
            if (!counts.containsKey(current)) {
                result = false;
                break;
            }
            int count = counts.get(current) - 1;
            if (count == 0) {
                counts.remove(current);
            } else {
                counts.put(current, count);
            }
        }
        result = result && counts.isEmpty();
        return result;
    }

    public static boolean eq(String left, String right) {
        Map<Character, Integer> leftChars = charCounts(left);
        return compareCharCounts(right, leftChars);
    }
}
