package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Matrix {

    public static List<Integer> matrixToList(int[][] matrix) {
        return
                Arrays.stream(matrix)
                        .flatMap(e -> Arrays.stream(e).boxed())
                        .collect(Collectors.toList());
    }
}
