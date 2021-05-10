package ru.job4j.tracker.actions;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

public class AddItemAction implements UserAction {

    @Override
    public String getName() {
        return "Добавить заявку";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Создание новой заявки ====");
        String name = input.askStr("Введите имя заявки : ");
        Item item = new Item(name);
        item = tracker.add(item);
        System.out.println("Добавленная заявка: " + item);
        return false;
    }
}
