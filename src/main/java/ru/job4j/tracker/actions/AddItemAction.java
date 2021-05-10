package ru.job4j.tracker.actions;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Output;
import ru.job4j.tracker.Tracker;

public class AddItemAction implements UserAction {

    private Input input;
    private Output output;
    private Tracker tracker;

    public AddItemAction(Input aInput, Output aOutput, Tracker aTracker) {
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
