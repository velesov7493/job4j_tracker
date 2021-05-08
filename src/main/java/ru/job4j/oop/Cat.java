package ru.job4j.oop;

public class Cat {

    private String name;
    private String food;

    public void show() {
        System.out.println(name + " съел " + food);
    }

    public void eat(String meat) {
        food = meat;
    }

    public void giveNick(String nick) {
        name = nick;
    }

    public static void main(String[] args) {
        System.out.println("Кормим Гава:");
        Cat gav = new Cat();
        gav.giveNick("Гав");
        gav.eat("котлета");
        gav.show();
        System.out.println("Кормим Черныша:");
        Cat black = new Cat();
        black.giveNick("Черныш");
        black.eat("рыба");
        black.show();
    }
}
