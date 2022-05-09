package ru.job4j.inheritance;

public class PizzaShop {

    public static void main(String[] args) {
        Pizza pizza1 = new Pizza();
        PizzaExtraCheese pizza2 = new PizzaExtraCheese();
        PizzaExtraCheeseTomato pizza3 = new PizzaExtraCheeseTomato();
        System.out.println(pizza1.getName());
        System.out.println(pizza2.getName());
        System.out.println(pizza3.getName());
    }
}
