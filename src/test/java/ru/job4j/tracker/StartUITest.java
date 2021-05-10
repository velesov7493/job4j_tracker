package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.actions.*;

import static org.junit.Assert.*;

public class StartUITest {

    @Test
    public void whenAddItem() {
        String[] answers = {"Fix PC"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        UserAction addItem = new AddItemAction();
        addItem.execute(input, tracker);
        Item created = tracker.findAll()[0];
        String expected = "Fix PC";
        assertEquals(expected, created.getName());
    }

    @Test
    public void whenReplaceItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("new item");
        tracker.add(item);
        String expected = "replaced item";
        String[] answers = {
                String.valueOf(item.getId()),
                expected
        };
        Input input = new StubInput(answers);
        UserAction replaceItem = new ReplaceItemAction();
        replaceItem.execute(input, tracker);
        Item replaced = tracker.findById(item.getId());
        assertEquals(expected, replaced.getName());
    }

    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("new item");
        tracker.add(item);
        String[] answers = {
                String.valueOf(item.getId())
        };
        Input input = new StubInput(answers);
        UserAction deleteItem = new DeleteItemAction();
        deleteItem.execute(input, tracker);
        Item deleted = tracker.findById(item.getId());
        assertNull(deleted);
    }

    @Test
    public void whenUiAddItem() {
        Input in = new StubInput(
                new String[] {"1", "Item name", "2"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new AddItemAction(),
                new ExitAction()
        };
        StartUI ui = new StartUI(in, tracker, actions);
        ui.execute();
        Item[] found = tracker.findAll();
        assertEquals(found[0].getName(), "Item name");
    }

    @Test
    public void whenUiReplaceItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[] {"1", String.valueOf(item.getId()), replacedName, "2"}
        );
        UserAction[] actions = {
                new ReplaceItemAction(),
                new ExitAction()
        };
        StartUI ui = new StartUI(in, tracker, actions);
        ui.execute();
        assertEquals(tracker.findById(item.getId()).getName(), replacedName);
    }

    @Test
    public void whenUiDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted item"));
        Input in = new StubInput(
                new String[] {"1", String.valueOf(item.getId()), "2"}
        );
        UserAction[] actions = {
                new DeleteItemAction(),
                new ExitAction()
        };
        StartUI ui = new StartUI(in, tracker, actions);
        ui.execute();
        Item deleted = tracker.findById(item.getId());
        assertNull(deleted);
    }
}