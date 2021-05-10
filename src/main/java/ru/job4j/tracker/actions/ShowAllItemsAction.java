package ru.job4j.tracker.actions;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Output;
import ru.job4j.tracker.Tracker;

public class ShowAllItemsAction implements UserAction {

    private Output output;
    private Tracker tracker;

    public ShowAllItemsAction(Output aOutput, Tracker aTracker) {
        output = aOutput;
        tracker = aTracker;
    }

    @Override
    public String getName() {
        return "Показать все заявки";
    }

    @Override
    public boolean execute() {
        output.println("=== Все заявки ====");
        Item[] items = tracker.findAll();
        if (items.length == 0) {
            output.println("Еще нет ни одной заявки.");
            return false;
        }
        for (Item entry : items) {
            output.println(entry);
        }
        return false;
    }
}
