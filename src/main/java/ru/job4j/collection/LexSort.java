package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        int result;
        String[] slicesLeft = left.split(". ");
        String[] slicesRight = right.split(". ");
        int nLeft = Integer.parseInt(slicesLeft[0]);
        int nRight = Integer.parseInt(slicesRight[0]);
        result = Integer.compare(nLeft, nRight);
        return result;
    }
}
