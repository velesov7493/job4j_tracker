package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.actions.*;
import ru.job4j.tracker.io.Input;
import ru.job4j.tracker.io.Output;
import ru.job4j.tracker.io.StubInput;
import ru.job4j.tracker.io.StubOutput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class StartUITest {

    @Test
    public void whenAddItem() {
        String[] answers = {"Fix PC"};
        Input input = new StubInput(answers);
        Output output = new StubOutput();
        MemTracker tracker = new MemTracker();
        UserAction addItem = new AddItemAction(input, output, tracker);
        addItem.execute();
        Item created = tracker.findAll().get(0);
        String expected = "Fix PC";
        assertEquals(expected, created.getName());
    }

    @Test
    public void whenReplaceItem() {
        MemTracker tracker = new MemTracker();
        Item item = new Item("new item");
        tracker.add(item);
        String expected = "replaced item";
        String[] answers = {
                String.valueOf(item.getId()),
                expected
        };
        Input input = new StubInput(answers);
        Output output = new StubOutput();
        UserAction replaceItem = new ReplaceItemAction(input, output, tracker);
        replaceItem.execute();
        Item replaced = tracker.findById(item.getId());
        assertEquals(expected, replaced.getName());
    }

    @Test
    public void whenDeleteItem() {
        MemTracker tracker = new MemTracker();
        Item item = new Item("new item");
        tracker.add(item);
        String[] answers = {
                String.valueOf(item.getId())
        };
        Input input = new StubInput(answers);
        Output output = new StubOutput();
        UserAction deleteItem = new DeleteItemAction(input, output, tracker);
        deleteItem.execute();
        Item deleted = tracker.findById(item.getId());
        assertNull(deleted);
    }

    @Test
    public void whenUiAddItem() {
        Input in = new StubInput(
                new String[] {"1", "Item name", "2"}
        );
        Output output = new StubOutput();
        MemTracker tracker = new MemTracker();
        List<UserAction> actions = Arrays.asList(
                new AddItemAction(in, output, tracker),
                new ExitAction()
        );
        StartUI ui = new StartUI(in, output, tracker, actions);
        ui.execute();
        List<Item> found = tracker.findAll();
        assertEquals(found.get(0).getName(), "Item name");
    }

    @Test
    public void whenUiReplaceItem() {
        MemTracker tracker = new MemTracker();
        Item item = tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[] {"1", String.valueOf(item.getId()), replacedName, "2"}
        );
        Output output = new StubOutput();
        List<UserAction> actions = Arrays.asList(
                new ReplaceItemAction(in, output, tracker),
                new ExitAction()
        );
        StartUI ui = new StartUI(in, output, tracker, actions);
        ui.execute();
        assertEquals(tracker.findById(item.getId()).getName(), replacedName);
    }

    @Test
    public void whenUiDeleteItem() {
        MemTracker tracker = new MemTracker();
        Item item = tracker.add(new Item("Deleted item"));
        Input in = new StubInput(
                new String[] {"1", String.valueOf(item.getId()), "2"}
        );
        Output output = new StubOutput();
        List<UserAction> actions = Arrays.asList(
                new DeleteItemAction(in, output, tracker),
                new ExitAction()
        );
        StartUI ui = new StartUI(in, output, tracker, actions);
        ui.execute();
        Item deleted = tracker.findById(item.getId());
        assertNull(deleted);
    }

    @Test
    public void whenUiShowAllItems() {
        MemTracker tracker = new MemTracker();
        Item item1 = tracker.add(new Item("Проверка StartUI"));
        Item item2 = tracker.add(new Item("Тест StartUI"));
        Input in = new StubInput(
                new String[] {"1", "2"}
        );
        Output output = new StubOutput();
        List<UserAction> actions = Arrays.asList(
                new ShowAllItemsAction(output, tracker),
                new ExitAction()
        );
        StartUI ui = new StartUI(in, output, tracker, actions);
        ui.execute();
        String expected =
                "Меню:" + System.lineSeparator()
                + "1. Показать все заявки" + System.lineSeparator()
                + "2. Выход" + System.lineSeparator()
                + "=== Все заявки ====" + System.lineSeparator()
                + item1 + System.lineSeparator()
                + item2 + System.lineSeparator()
                + "Выключаюсь..." + System.lineSeparator();
        String out = output.toString();
        assertEquals(expected, out);
    }

    @Test
    public void whenUiFindItemsByName() {
        MemTracker tracker = new MemTracker();
        Item item1 = tracker.add(new Item("Проверка StartUI"));
        tracker.add(new Item("Тест StartUI"));
        Input in = new StubInput(
                new String[] {"1", "Проверка StartUI", "2"}
        );
        Output output = new StubOutput();
        List<UserAction> actions = Arrays.asList(
                new FindItemsByNameAction(in, output, tracker),
                new ExitAction()
        );
        StartUI ui = new StartUI(in, output, tracker, actions);
        ui.execute();
        String expected =
                "Меню:" + System.lineSeparator()
                + "1. Найти заявки по имени" + System.lineSeparator()
                + "2. Выход" + System.lineSeparator()
                + "=== Поиск заявки по имени ====" + System.lineSeparator()
                + item1 + System.lineSeparator()
                + "Выключаюсь..." + System.lineSeparator();
        String out = output.toString();
        assertEquals(expected, out);
    }

    @Test
    public void whenUiFindItemById() {
        MemTracker tracker = new MemTracker();
        tracker.add(new Item("item1"));
        Item item2 = tracker.add(new Item("item2"));
        Input in = new StubInput(
                new String[] {"1", String.valueOf(item2.getId()), "2"}
        );
        Output output = new StubOutput();
        List<UserAction> actions = Arrays.asList(
                new FindItemByIdAction(in, output, tracker),
                new ExitAction()
        );
        StartUI ui = new StartUI(in, output, tracker, actions);
        ui.execute();
        String expected =
                "Меню:" + System.lineSeparator()
                + "1. Найти заявку по ID" + System.lineSeparator()
                + "2. Выход" + System.lineSeparator()
                + "=== Поиск заявки по номеру (id) ====" + System.lineSeparator()
                + item2 + System.lineSeparator()
                + "Выключаюсь..." + System.lineSeparator();
        String out = output.toString();
        assertEquals(expected, out);
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "1"}
        );
        MemTracker tracker = new MemTracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new ExitAction());
        StartUI ui = new StartUI(in, out, tracker, actions);
        ui.execute();
        String ln = System.lineSeparator();
        String expected =
                "Меню:" + ln
                + "1. Выход" + ln
                + "Невыполнимая команда. Допустимый диапазон: 1..1" + ln
                + "Выключаюсь..." + ln;
        String output = out.toString();
        assertEquals(expected, output);
    }
}