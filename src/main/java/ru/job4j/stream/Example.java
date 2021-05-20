package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Example {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(
                1, -2, 3, -5, 8, -13, 21, -34
        );
        List<Integer> result = numbers
                .stream()
                .filter(n -> n > 0)
                .collect(Collectors.toList());
        result.forEach(System.out::println);
    }
}
