package ru.job4j.ex;

public class Fact {

    public static int calc(int n) {
        int result = 1;
        if (n < 0) {
            throw new IllegalArgumentException("N должно быть неотрицательным!");
        } else if (n == 0) {
            return 0;
        }
        for (int index = 1; index <= n; index++) {
            result *= index;
        }
        return result;
    }
}
