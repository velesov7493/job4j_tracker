package ru.job4j.typecast;

public class Train implements Vehicle {

    @Override
    public void move() {
        System.out.println("Едем по железной дороге");
    }

    @Override
    public double fueling(double count) {
        System.out.println("Заправка соляркой 50.10 руб. за литр. " + count + " литров");
        return 50.1 * count;
    }

    @Override
    public String toString() {
        return "Поезд";
    }
}
