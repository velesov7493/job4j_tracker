package ru.job4j.tracker;

public class StartUI {

    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        tracker.add(new Item("Тестовая заявка"));
        Item founded = tracker.findById(1);
        System.out.println("Найдена заявка: " + founded.toString());
    }
}
