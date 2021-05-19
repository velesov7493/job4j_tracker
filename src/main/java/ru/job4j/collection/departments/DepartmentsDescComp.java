package ru.job4j.collection.departments;

import java.util.Comparator;

public class DepartmentsDescComp implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        String[] chunks1 = left.split("/", 2);
        String[] chunks2 = right.split("/", 2);
        int result = chunks2[0].compareTo(chunks1[0]);
        if (result != 0) {
            return result;
        }
        result = left.compareTo(right);
        return result;
    }
}
