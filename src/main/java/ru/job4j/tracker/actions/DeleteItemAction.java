package ru.job4j.tracker.actions;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.Tracker;

public class DeleteItemAction implements UserAction {

    @Override
    public String getName() {
        return "Удалить заявку";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        boolean result = false;
        System.out.println("=== Удаление заявки ====");
        int itemId = input.askInt("Введите номер заявки : ");
        if (tracker.delete(itemId)) {
            System.out.println("Заявка успешно удалена.");
            result = true;
        } else {
            System.out.println("Заявка №" + itemId + " не найдена.");
        }
        return result;
    }
}
