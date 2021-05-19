package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaUsage {

    private static void echo(List<String> strings) {
        for (String entry : strings) {
            System.out.println(entry);
        }
    }

    public static void main(String[] args) {
        Comparator<String> cmpDescSize = (left, right) -> {
            System.out.println(
                    "Сравнение строк по длине по убыванию - "
                    + left.length() + " : " + right.length()
            );
            return Integer.compare(right.length(), left.length());
        };
        Comparator<String> cmpText = (left, right) -> {
            System.out.println("Обычное сравнение строк: - " + left + " : " + right);
            return left.compareTo(right);
        };
        List<String> names = Arrays.asList(
                "Иванов Иван Иванович",
                "Иванова Анна Ивановна"
        );
        Collections.sort(names, cmpText);
        echo(names);
        Collections.sort(names, cmpDescSize);
        echo(names);
    }
}
