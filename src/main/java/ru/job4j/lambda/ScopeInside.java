package ru.job4j.lambda;

import java.util.function.Supplier;

public class ScopeInside {

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3};
        Supplier<Integer> sum = () -> {
            int total = 0;
            for (int val : numbers) {
                total += val;
            }
            return total;
        };
        System.out.println(sum.get());
    }
}
