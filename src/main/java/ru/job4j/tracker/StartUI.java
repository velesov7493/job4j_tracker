package ru.job4j.tracker;

import ru.job4j.tracker.actions.*;

public class StartUI {

    private static StartUI instance;

    private Input input;
    private Tracker tracker;
    private UserAction[] actions;

    public StartUI(Input aInput, Tracker aTracker) {
        input = aInput;
        tracker = aTracker;
        actions = new UserAction[] {
                new AddItemAction(),
                new ShowAllItemsAction(),
                new ReplaceItemAction(),
                new DeleteItemAction(),
                new FindItemByIdAction(),
                new FindItemsByNameAction(),
                new ExitAction()
        };
    }

    private void cmdShowMenu() {
        System.out.println("Меню:");
        for (int i = 0; i < actions.length; i++) {
            System.out.println((i + 1) + ". " + actions[i].getName());
        }
    }

    private boolean processCommand(int cmd) {
        boolean exit = false;
        if (cmd >= 1 && cmd <= actions.length) {
            exit = actions[cmd - 1].execute(input, tracker);
        } else {
            System.out.println("Невыполнимая команда");
        }
        if (exit) {
            System.out.println("Выключаюсь...");
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
        instance = new StartUI(new ConsoleInput(), new Tracker());
        instance.execute();
    }
}