package ru.job4j.tracker;

public class StartUI {

    private static StartUI instance;

    private Input input;
    private Tracker tracker;

    private StartUI(Input aInput, Tracker aTracker) {
        input = aInput;
        tracker = aTracker;
    }

    private void cmdShowMenu() {
        String[] menu = {
                "Показать меню", "Добавить заявку",
                "Показать все заявки", "Редактировать заявку",
                "Удалить заявку", "Найти заявку по id",
                "Найти заявки по имени", "Выход"
        };
        System.out.println("Меню:");
        for (int i = 0; i < menu.length; i++) {
            System.out.println((i + 1) + ". " + menu[i]);
        }
    }

    private void cmdAddItem() {
        System.out.println("=== Создание новой заявки ====");
        String name = input.askStr("Введите имя заявки : ");
        Item item = new Item(name);
        item = tracker.add(item);
        System.out.println("Добавленная заявка: " + item);
    }

    private void cmdShowAllItems() {
        System.out.println("=== Все заявки ====");
        Item[] items = tracker.findAll();
        if (items.length == 0) {
            System.out.println("Еще нет ни одной заявки.");
            return;
        }
        for (Item entry : items) {
            System.out.println(entry);
        }
    }

    private void cmdEditItem() {
        System.out.println("=== Редактирование заявки ====");
        int itemId = input.askInt("Введите номер заявки : ");
        String itemName = input.askStr("Введите новое имя заявки : ");
        Item item = new Item(itemName);
        if (tracker.replace(itemId, item)) {
            System.out.println("Заявка успешно отредактирована.");
        } else {
            System.out.println("Заявка №" + itemId + " не найдена.");
        }
    }

    private void cmdDeleteItem() {
        System.out.println("=== Удаление заявки ====");
        int itemId = input.askInt("Введите номер заявки : ");
        if (tracker.delete(itemId)) {
            System.out.println("Заявка успешно удалена.");
        } else {
            System.out.println("Заявка №" + itemId + " не найдена.");
        }
    }

    private void cmdFindItemById() {
        System.out.println("=== Поиск заявки по номеру (id) ====");
        int itemId = input.askInt("Введите номер заявки : ");
        Item founded = tracker.findById(itemId);
        if (founded != null) {
            System.out.println(founded);
        } else {
            System.out.println("Заявка №" + itemId + " не найдена.");
        }
    }

    private void cmdFindItemByName() {
        System.out.println("=== Поиск заявки по имени ====");
        String itemName = input.askStr("Введите имя заявки : ");
        Item[] items = tracker.findByName(itemName);
        if (items.length == 0) {
            System.out.println("Ничего не найдено.");
            return;
        }
        for (Item entry : items) {
            System.out.println(entry);
        }
    }

    private void processCommand(int cmd) {
        switch (cmd) {
            case 1 -> cmdShowMenu();
            case 2 -> cmdAddItem();
            case 3 -> cmdShowAllItems();
            case 4 -> cmdEditItem();
            case 5 -> cmdDeleteItem();
            case 6 -> cmdFindItemById();
            case 7 -> cmdFindItemByName();
            case 8 -> System.out.print("Выключаюсь...");
            default -> System.out.println("Неизвестная команда.");
        }
    }

    public void execute() {
        int command = 0;
        cmdShowMenu();
        while (command != 8) {
            command = input.askInt("Жду команды: ");
            processCommand(command);
        }
    }

    public static void main(String[] args) {
        instance = new StartUI(new ConsoleInput(), new Tracker());
        instance.execute();
    }
}