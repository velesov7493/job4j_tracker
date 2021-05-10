package ru.job4j.tracker.actions;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

public class ReplaceItemAction implements UserAction {

    @Override
    public String getName() {
        return "Редактировать заявку";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Редактирование заявки ====");
        int itemId = input.askInt("Введите номер заявки : ");
        String itemName = input.askStr("Введите новое имя заявки : ");
        Item item = new Item(itemName);
        if (tracker.replace(itemId, item)) {
            System.out.println("Заявка успешно отредактирована.");
        } else {
            System.out.println("Заявка №" + itemId + " не найдена.");
        }
        return false;
    }
}
