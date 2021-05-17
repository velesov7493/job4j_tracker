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

    public static boolean eq(String left, String right) {
        Map<Character, Integer> leftChars = charCounts(left);
        Map<Character, Integer> rightChars = charCounts(right);
        return leftChars.equals(rightChars);
    }
}
