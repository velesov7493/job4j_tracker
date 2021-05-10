package ru.job4j.tracker.actions;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Output;
import ru.job4j.tracker.Tracker;

public class FindItemsByNameAction implements UserAction {

    private Input input;
    private Output output;
    private Tracker tracker;

    public FindItemsByNameAction(Input aInput, Output aOutput, Tracker aTracker) {
        input = aInput;
        output = aOutput;
        tracker = aTracker;
    }

    @Override
    public String getName() {
        return "Найти заявки по имени";
    }

    @Override
    public boolean execute() {
        output.println("=== Поиск заявки по имени ====");
        String itemName = input.askStr("Введите имя заявки : ");
        Item[] items = tracker.findByName(itemName);
        if (items.length == 0) {
            output.println("Ничего не найдено.");
            return false;
        }
        for (Item entry : items) {
            output.println(entry);
        }
        return false;
    }
}
