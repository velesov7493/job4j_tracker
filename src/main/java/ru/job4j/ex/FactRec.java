package ru.job4j.ex;

public class FactRec {

    public static int calc(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("N должно быть неотрицательным!");
        }
        return switch (n) {
            case 0 -> 0;
            case 1 -> 1;
            default -> calc(n - 1) * n;
        };
    }

    public static void main(String[] args) {
        int rsl = calc(3);
        System.out.println(rsl);
    }
}
