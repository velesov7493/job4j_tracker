package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {

    private static StartUI instance;

    private Scanner input;
    private Tracker tracker;

    private StartUI(Scanner scanner, Tracker aTracker) {
        input = scanner;
        tracker = aTracker;
    }

    private void cmdShowMenu() {
        System.out.println("Меню:");
        System.out.println("1. Показать меню");
        System.out.println("2. Добавить заявку");
        System.out.println("3. Показать все заявки");
        System.out.println("4. Редактировать заявку");
        System.out.println("5. Удалить заявку");
        System.out.println("6. Найти заявку по id");
        System.out.println("7. Найти заявки по имени");
        System.out.println("8. Выход");
    }

    private void cmdAddItem() {
        System.out.println("=== Создание новой заявки ====");
        System.out.print("Введите имя заявки : ");
        String name = input.nextLine();
        Item item = new Item(name);
        tracker.add(item);
        System.out.println("Заявка добавлена.");
    }

    private void cmdShowAllItems() {
        System.out.println("=== Все заявки ====");
        Item[] items = tracker.findAll();
        for (Item entry: items) {
            System.out.println(entry.toString());
        }
    }

    private void cmdEditItem() {
        System.out.println("=== Редактирование заявки ====");
        System.out.print("Введите номер заявки : ");
        int itemId = Integer.valueOf(input.nextLine());
        System.out.print("Введите новое имя заявки : ");
        String itemName = input.nextLine();
        Item item = new Item(itemName);
        if (tracker.replace(itemId, item)) {
            System.out.println("Заявка успешно отредактирована.");
        } else {
            System.out.println("Заявка №" + itemId + " не найдена.");
        }
    }

    private void cmdDeleteItem() {
        System.out.println("=== Удаление заявки ====");
        System.out.print("Введите номер заявки : ");
        int itemId = Integer.valueOf(input.nextLine());
        if (tracker.delete(itemId)) {
            System.out.println("Заявка успешно удалена.");
        } else {
            System.out.println("Заявка №" + itemId + " не найдена.");
        }
    }

    private void cmdFindItemById() {
        System.out.println("=== Поиск заявки по номеру (id) ====");
        System.out.print("Введите номер заявки : ");
        int itemId = Integer.valueOf(input.nextLine());
        Item founded = tracker.findById(itemId);
        if (founded != null) {
            System.out.println(founded);
        } else {
            System.out.println("Заявка №" + itemId + " не найдена.");
        }
    }

    private void cmdFindItemByName() {
        System.out.println("=== Поиск заявки по имени ====");
        System.out.print("Введите имя заявки : ");
        String itemName = input.nextLine();
        Item[] items = tracker.findByName(itemName);
        if (items.length == 0) {
            System.out.println("Ничего не найдено.");
            return;
        }
        for (Item entry: items) {
            System.out.println(entry);
        }
    }

    private void processCommand(int cmd) {
        switch (cmd) {
            case 1:
                cmdShowMenu();
                break;
            case 2:
                cmdAddItem();
                break;
            case 3:
                cmdShowAllItems();
                break;
            case 4:
                cmdEditItem();
                break;
            case 5:
                cmdDeleteItem();
                break;
            case 6:
                cmdFindItemById();
                break;
            case 7:
                cmdFindItemByName();
                break;
            case 8:
                System.out.print("Выключаюсь...");
                break;
            default:
                System.out.println("Неизвестная команда.");
        }
    }

    public void execute() {
        int command = 0;
        cmdShowMenu();
        while (command != 8) {
            System.out.print("Ваш выбор: ");
            command = Integer.valueOf(input.nextLine());
            processCommand(command);
        }
    }

    public static void main(String[] args) {
        instance = new StartUI(new Scanner(System.in), new Tracker());
        instance.execute();
    }
}