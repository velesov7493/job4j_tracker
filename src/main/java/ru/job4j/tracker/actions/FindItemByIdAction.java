package ru.job4j.tracker.actions;

import ru.job4j.tracker.io.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.io.Output;
import ru.job4j.tracker.Store;

public class FindItemByIdAction implements UserAction {

    private Input input;
    private Output output;
    private Store tracker;

    public FindItemByIdAction(Input aInput, Output aOutput, Store aTracker) {
        input = aInput;
        output = aOutput;
        tracker = aTracker;
    }

    @Override
    public String getName() {
        return "Найти заявку по ID";
    }

    @Override
    public boolean execute() {
        output.println("=== Поиск заявки по номеру (id) ====");
        int itemId = input.askInt("Введите номер заявки : ");
        Item founded = tracker.findById(itemId);
        if (founded != null) {
            output.println(founded);
        } else {
            output.println("Заявка №" + itemId + " не найдена.");
        }
        return false;
    }
}
