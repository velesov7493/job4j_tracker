package ru.job4j.tracker.actions;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

public class ShowAllItemsAction implements UserAction {

    @Override
    public String getName() {
        return "Показать все заявки";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Все заявки ====");
        Item[] items = tracker.findAll();
        if (items.length == 0) {
            System.out.println("Еще нет ни одной заявки.");
            return false;
        }
        for (Item entry : items) {
            System.out.println(entry);
        }
        return true;
    }
}
