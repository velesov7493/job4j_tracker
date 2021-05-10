package ru.job4j.tracker.actions;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

public class FindItemByIdAction implements UserAction {

    @Override
    public String getName() {
        return "Найти заявку по ID";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Поиск заявки по номеру (id) ====");
        int itemId = input.askInt("Введите номер заявки : ");
        Item founded = tracker.findById(itemId);
        if (founded != null) {
            System.out.println(founded);
        } else {
            System.out.println("Заявка №" + itemId + " не найдена.");
        }
        return false;
    }
}
