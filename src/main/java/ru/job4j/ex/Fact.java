package ru.job4j.ex;

public class Fact {

    public static int calc(int n) {
        int result = 0;
        if (n > 0) {
            result = 1;
            for (int index = 1; index <= n; index++) {
                result *= index;
            }
        } else if (n < 0) {
            throw new IllegalArgumentException("N должно быть неотрицательным!");
        }
        return result;
    }
}
