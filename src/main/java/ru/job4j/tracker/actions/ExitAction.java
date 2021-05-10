package ru.job4j.tracker.actions;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.Tracker;

public class ExitAction implements UserAction {

    @Override
    public String getName() {
        return "Выход";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        return true;
    }
}
