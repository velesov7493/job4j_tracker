package ru.job4j.typecast;

public class Test {

    public static void main(String[] args) {
        Vehicle[] vehicles = {new Bus(), new Train(), new Plain()};
        for (Vehicle entry : vehicles) {
            System.out.println(entry);
            double sum = entry.fueling(20);
            System.out.printf("Сумма заправки: %.2f%n", sum);
            entry.move();
            System.out.println();
        }
    }
}
