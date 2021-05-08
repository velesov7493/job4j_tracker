package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;

public class StartUI {

    public static void main(String[] args) {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        Tracker tracker = new Tracker();
        tracker.add(new Item("Тестовая заявка"));
        Item founded = tracker.findById(1);
        System.out.println("Найдена заявка: \""+founded.getName()+"\" от "+founded.getCreated().format(f));
    }
}
