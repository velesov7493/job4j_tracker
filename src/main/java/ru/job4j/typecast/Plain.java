package ru.job4j.typecast;

public class Plain implements Vehicle {

    @Override
    public void move() {
        System.out.println("Летим");
    }

    @Override
    public double fueling(double count) {
        System.out.println("Заправка керосином 46 669 руб. за тонну. " + count + " тонн");
        return 46669 * count;
    }

    @Override
    public String toString() {
        return "Самолет";
    }
}
