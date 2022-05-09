package ru.job4j.inheritance;

public class PizzaExtraCheeseTomato extends PizzaExtraCheese {

    @Override
    public String getName() {
        return super.getName() + " + extra tomato";
    }
}
