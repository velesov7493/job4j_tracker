package ru.job4j.tracker.actions;

import ru.job4j.tracker.io.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.io.Output;
import ru.job4j.tracker.Tracker;

public class ReplaceItemAction implements UserAction {

    private Input input;
    private Output output;
    private Tracker tracker;

    public ReplaceItemAction(Input aInput, Output aOutput, Tracker aTracker) {
        input = aInput;
        output = aOutput;
        tracker = aTracker;
    }

    @Override
    public String getName() {
        return "Редактировать заявку";
    }

    @Override
    public boolean execute() {
        output.println("=== Редактирование заявки ====");
        int itemId = input.askInt("Введите номер заявки : ");
        String itemName = input.askStr("Введите новое имя заявки : ");
        Item item = new Item(itemName);
        if (tracker.replace(itemId, item)) {
            output.println("Заявка успешно отредактирована.");
        } else {
            output.println("Заявка №" + itemId + " не найдена.");
        }
        return false;
    }
}
