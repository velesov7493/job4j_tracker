package ru.job4j.ex;

public class Fact {

    public static int calc(int n) {
        int result = n > 0 ? 1 : 0;
        if (n < 0) {
            throw new IllegalArgumentException("N должно быть неотрицательным!");
        }
        for (int index = 1; index <= n; index++) {
            result *= index;
        }
        return result;
    }
}
