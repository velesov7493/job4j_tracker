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
                new FindItemsByNameAction()
        };
    }

    private void cmdShowMenu() {
        System.out.println("Меню:");
        for (int i = 0; i < actions.length; i++) {
            System.out.println((i + 1) + ". " + actions[i].getName());
        }
    }

    private boolean processCommand(int cmd) {
        boolean run = cmd >= 1 && cmd <= actions.length;
        if (run) {
            actions[cmd - 1].execute(input, tracker);
        } else {
            System.out.println("Выключаюсь...");
        }
        return run;
    }

    public void execute() {
        int command;
        boolean loop = true;
        cmdShowMenu();
        while (loop) {
            command = input.askInt("Жду команды: ");
            loop = processCommand(command);
        }
    }

    public static void main(String[] args) {
        instance = new StartUI(new ConsoleInput(), new Tracker());
        instance.execute();
    }
}