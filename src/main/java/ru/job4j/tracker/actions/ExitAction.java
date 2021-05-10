package ru.job4j.tracker.actions;

public class ExitAction implements UserAction {

    @Override
    public String getName() {
        return "Выход";
    }

    @Override
    public boolean execute() {
        return true;
    }
}
