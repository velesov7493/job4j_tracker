package ru.job4j.search;

import java.util.HashSet;
import java.util.List;

public class FullSearch {

    public static HashSet<String> extractNumber(List<Task> list) {
        HashSet<String> numbers = new HashSet<>();
        for (Task entry : list) {
            numbers.add(entry.getNumber());
        }
        return numbers;
    }
}
