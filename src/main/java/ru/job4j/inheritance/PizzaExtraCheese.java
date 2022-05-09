package ru.job4j.inheritance;

public class PizzaExtraCheese extends Pizza {

    @Override
    public String getName() {
        return super.getName() + " + extra cheese";
    }
}
