package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        int result = Integer.compare(left.length(), right.length());
        if (result > 0) {
            int diff = left.length() - right.length();
            while (diff > 0) {
                right += (char) 0;
                diff--;
            }
        } else if (result < 0) {
            int diff = right.length() - left.length();
            while (diff > 0) {
                left += (char) 0;
                diff--;
            }
        }
        for (int i = 0; i < left.length(); i++) {
            result = Character.compare(left.charAt(i), right.charAt(i));
            if (result != 0) {
                break;
            }
        }
        return result;
    }
}
