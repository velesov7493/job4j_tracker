package ru.job4j.tracker;

import ru.job4j.tracker.actions.*;

public class StartUI {

    private static StartUI instance;

    private Input input;
    private Output output;
    private Tracker tracker;
    private UserAction[] actions;

    public StartUI(Input aInput, Tracker aTracker, UserAction[] aActions) {
        input = aInput;
        output = new ConsoleOutput();
        tracker = aTracker;
        actions = aActions != null ? aActions : new UserAction[] {
            new AddItemAction(input, output, tracker),
            new ShowAllItemsAction(output, tracker),
            new ReplaceItemAction(input, output, tracker),
            new DeleteItemAction(input, output, tracker),
            new FindItemByIdAction(input, output, tracker),
            new FindItemsByNameAction(input, output, tracker),
            new ExitAction()
        };
    }

    public StartUI(Input aInput, Output aOutput, Tracker aTracker, UserAction[] aActions) {
        input = aInput;
        output = aOutput;
        tracker = aTracker;
        actions = aActions != null ? aActions : new UserAction[] {
                new AddItemAction(input, output, tracker),
                new ShowAllItemsAction(output, tracker),
                new ReplaceItemAction(input, output, tracker),
                new DeleteItemAction(input, output, tracker),
                new FindItemByIdAction(input, output, tracker),
                new FindItemsByNameAction(input, output, tracker),
                new ExitAction()
        };
    }

    private void cmdShowMenu() {
        output.println("Меню:");
        for (int i = 0; i < actions.length; i++) {
            output.println((i + 1) + ". " + actions[i].getName());
        }
    }

    private boolean processCommand(int cmd) {
        boolean exit = false;
        if (cmd >= 1 && cmd <= actions.length) {
            exit = actions[cmd - 1].execute();
        } else {
            output.println("Невыполнимая команда. Допустимый диапазон: 1.." + actions.length);
        }
        if (exit) {
            output.println("Выключаюсь...");
        }
        return exit;
    }

    public void execute() {
        int command;
        boolean exit = false;
        cmdShowMenu();
        while (!exit) {
            command = input.askInt("Жду команды: ");
            exit = processCommand(command);
        }
    }

    public static void main(String[] args) {
        Output out = new ConsoleOutput();
        instance = new StartUI(
                new ValidateInput(new ConsoleInput(), out),
                out, new Tracker(), null
        );
        instance.execute();
    }
}