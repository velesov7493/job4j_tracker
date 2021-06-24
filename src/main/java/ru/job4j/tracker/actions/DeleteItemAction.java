package ru.job4j.tracker.actions;

import ru.job4j.tracker.io.Input;
import ru.job4j.tracker.io.Output;
import ru.job4j.tracker.Store;

public class DeleteItemAction implements UserAction {

    private Input input;
    private Output output;
    private Store tracker;

    public DeleteItemAction(Input aInput, Output aOutput, Store aTracker) {
        input = aInput;
        output = aOutput;
        tracker = aTracker;
    }

    @Override
    public String getName() {
        return "Удалить заявку";
    }

    @Override
    public boolean execute() {
        output.println("=== Удаление заявки ====");
        int itemId = input.askInt("Введите номер заявки : ");
        if (tracker.delete(itemId)) {
            output.println("Заявка успешно удалена.");
        } else {
            output.println("Заявка №" + itemId + " не найдена.");
        }
        return false;
    }
}
