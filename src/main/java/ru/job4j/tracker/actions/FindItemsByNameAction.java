package ru.job4j.tracker.actions;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

public class FindItemsByNameAction implements UserAction {

    @Override
    public String getName() {
        return "Найти заявки по имени";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Поиск заявки по имени ====");
        String itemName = input.askStr("Введите имя заявки : ");
        Item[] items = tracker.findByName(itemName);
        if (items.length == 0) {
            System.out.println("Ничего не найдено.");
            return false;
        }
        for (Item entry : items) {
            System.out.println(entry);
        }
        return false;
    }
}
