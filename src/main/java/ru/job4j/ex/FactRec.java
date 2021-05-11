package ru.job4j.ex;

public class FactRec {

    public static int calc(int n) {
        int result = 0;
        if (n == 1) {
            result = 1;
        } else if (n > 1) {
            result = calc(n - 1) * n;
        }
        return result;
    }

    public static void main(String[] args) {
        int rsl = calc(3);
        System.out.println(rsl);
    }
}
