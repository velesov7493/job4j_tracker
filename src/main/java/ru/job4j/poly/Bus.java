package ru.job4j.poly;

public class Bus implements Transport {

    @Override
    public void drive() {
        System.out.println("Еду");
    }

    @Override
    public void passengers(int count) {
        System.out.println("Беру пассажиров в количестве " + count + " человек");
    }

    @Override
    public double fueling(double count) {
        System.out.println(
                "Заправка топливом по цене 3 рубля 50 копеек за литр " + count + " литров"
        );
        return count * 3.5;
    }
}
