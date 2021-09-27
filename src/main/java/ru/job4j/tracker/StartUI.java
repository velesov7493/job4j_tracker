package ru.job4j.tracker;

import ru.job4j.tracker.actions.*;
import ru.job4j.tracker.io.*;

import java.util.ArrayList;
import java.util.List;

public class StartUI {

    private static StartUI instance;

    private final Input input;
    private final Output output;
    private final Store itemsStore;
    private final List<UserAction> actions;

    public StartUI(Input aInput, Store aStore, List<UserAction> aActions) {
        input = aInput;
        output = new ConsoleOutput();
        itemsStore = aStore;
        if (aActions != null) {
            actions = new ArrayList<>(aActions);
            return;
        }
        actions = new ArrayList<>();
        addDefaultActions();
    }

    public StartUI(Input aInput, Output aOutput, Store aStore, List<UserAction> aActions) {
        input = aInput;
        output = aOutput;
        itemsStore = aStore;
        if (aActions != null) {
            actions = new ArrayList<>(aActions);
            return;
        }
        actions = new ArrayList<>();
        addDefaultActions();
    }

    private void addDefaultActions() {
        actions.add(new AddItemAction(input, output, itemsStore));
        actions.add(new ShowAllItemsAction(output, itemsStore));
        actions.add(new ReplaceItemAction(input, output, itemsStore));
        actions.add(new DeleteItemAction(input, output, itemsStore));
        actions.add(new FindItemByIdAction(input, output, itemsStore));
        actions.add(new FindItemsByNameAction(input, output, itemsStore));
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
                out, new HbmTracker(), null
        );
        instance.execute();
    }
}