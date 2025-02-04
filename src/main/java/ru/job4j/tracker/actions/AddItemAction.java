package ru.job4j.tracker.actions;

import ru.job4j.tracker.Store;
import ru.job4j.tracker.io.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.io.Output;
import ru.job4j.tracker.Store;

public class AddItemAction implements UserAction {

    private Input input;
    private Output output;
    private Store tracker;

    public AddItemAction(Input aInput, Output aOutput, Store aTracker) {
        input = aInput;
        output = aOutput;
        tracker = aTracker;
    }

    @Override
    public String getName() {
        return "Добавить заявку";
    }

    @Override
    public boolean execute() {
        output.println("=== Создание новой заявки ====");
        String name = input.askStr("Введите имя заявки : ");
        Item item = new Item(name);
        item = tracker.add(item);
        output.println("Добавленная заявка: " + item);
        return false;
    }
}
