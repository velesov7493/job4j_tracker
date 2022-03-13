package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public static int minus(int y) {
        return y - x;
    }

    public double divide(int y) {
        return (double) y / x;
    }

    public int multiply(int y) {
        return x * y;
    }

    public double sumAllOperations(int y) {
        return
                sum(y) + multiply(y)
                        + minus(y) + divide(y);
    }

    public static void main(String[] args) {
        Calculator c = new Calculator();
        System.out.println("sum(7) = " + Calculator.sum(7));
        System.out.println("minus(7) = " + Calculator.minus(7));
        System.out.println("multiply(7) = " + c.multiply(7));
        System.out.println("divide(7) = " + c.divide(7));
        System.out.println("sumAllOperations(7) = " + c.sumAllOperations(7));
    }
}
