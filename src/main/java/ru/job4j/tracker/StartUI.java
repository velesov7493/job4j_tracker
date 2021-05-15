package ru.job4j.tracker;

import ru.job4j.tracker.actions.*;

import java.util.ArrayList;
import java.util.List;

public class StartUI {

    private static StartUI instance;

    private Input input;
    private Output output;
    private Tracker tracker;
    private List<UserAction> actions;

    public StartUI(Input aInput, Tracker aTracker, UserAction[] aActions) {
        input = aInput;
        output = new ConsoleOutput();
        tracker = aTracker;
        actions = new ArrayList<>();
        if (aActions != null) {
            for (UserAction element : aActions) {
                actions.add(element);
            }
            return;
        }
        addDefaultActions();
    }

    public StartUI(Input aInput, Output aOutput, Tracker aTracker, UserAction[] aActions) {
        input = aInput;
        output = aOutput;
        tracker = aTracker;
        actions = new ArrayList<>();
        if (aActions != null) {
            for (UserAction element : aActions) {
                actions.add(element);
            }
            return;
        }
        addDefaultActions();
    }

    private void addDefaultActions() {
        actions.add(new AddItemAction(input, output, tracker));
        actions.add(new ShowAllItemsAction(output, tracker));
        actions.add(new ReplaceItemAction(input, output, tracker));
        actions.add(new DeleteItemAction(input, output, tracker));
        actions.add(new FindItemByIdAction(input, output, tracker));
        actions.add(new FindItemsByNameAction(input, output, tracker));
        actions.add(new ExitAction());
    }

    private void cmdShowMenu() {
        output.println("Меню:");
        int i = 1;
        for (UserAction entry : actions) {
            output.println(i + ". " + entry.getName());
            i++;
        }
    }

    private boolean processCommand(int cmd) {
        boolean exit = false;
        if (cmd >= 1 && cmd <= actions.size()) {
            exit = actions.get(cmd - 1).execute();
        } else {
            output.println("Невыполнимая команда. Допустимый диапазон: 1.." + actions.size());
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