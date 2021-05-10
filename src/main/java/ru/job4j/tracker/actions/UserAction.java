package ru.job4j.tracker.actions;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.Tracker;

public interface UserAction {

    String getName();

    boolean execute(Input input, Tracker tracker);
}
