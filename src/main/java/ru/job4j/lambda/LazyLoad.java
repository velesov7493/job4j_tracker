package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;

public class LazyLoad {

    public static void main(String[] args) {
        String[] names = {
                "Elena",
                "Alexandr",
        };
        Comparator<String> lengthCmp = (left, right) -> {
            System.out.println("Выполнение сравнения");
            return left.length() - right.length();
        };
        Arrays.sort(names, lengthCmp);
        for (String name : names) {
            System.out.println(name);
        }
    }
}
