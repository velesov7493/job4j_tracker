package ru.job4j.tracker.actions;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.io.Output;
import ru.job4j.tracker.Store;

import java.util.List;

public class ShowAllItemsAction implements UserAction {

    private Output output;
    private Store tracker;

    public ShowAllItemsAction(Output aOutput, Store aTracker) {
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
        tracker.findAllReact(output::println);
        return false;
    }
}
