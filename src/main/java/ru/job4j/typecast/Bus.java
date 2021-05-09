package ru.job4j.typecast;

public class Bus implements Vehicle {

    @Override
    public void move() {
        System.out.println("Едем по автостраде");
    }

    @Override
    public double fueling(double count) {
        System.out.println("Заправка бензином 49.76 руб. за литр. " + count + " литров");
        return 49.76 * count;
    }

    @Override
    public String toString() {
        return "Автобус";
    }
}
