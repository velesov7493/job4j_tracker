package ru.job4j.tracker.actions;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Output;
import ru.job4j.tracker.Tracker;

import java.util.List;

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
        List<Item> items = tracker.findByName(itemName);
        if (items.isEmpty()) {
            output.println("Ничего не найдено.");
            return false;
        }
        for (Item entry : items) {
            output.println(entry);
        }
        return false;
    }
}
