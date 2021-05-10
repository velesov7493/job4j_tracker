package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.actions.*;

import static org.junit.Assert.*;

public class StartUITest {

    @Test
    public void whenAddItem() {
        String[] answers = {"Fix PC"};
        Input input = new StubInput(answers);
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        UserAction addItem = new AddItemAction(input, output, tracker);
        addItem.execute();
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
        Output output = new StubOutput();
        UserAction replaceItem = new ReplaceItemAction(input, output, tracker);
        replaceItem.execute();
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
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new AddItemAction(in, output, tracker),
                new ExitAction()
        };
        StartUI ui = new StartUI(in, output, tracker, actions);
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
        Output output = new StubOutput();
        UserAction[] actions = {
                new ReplaceItemAction(in, output, tracker),
                new ExitAction()
        };
        StartUI ui = new StartUI(in, output, tracker, actions);
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
        Output output = new StubOutput();
        UserAction[] actions = {
                new DeleteItemAction(in, output, tracker),
                new ExitAction()
        };
        StartUI ui = new StartUI(in, output, tracker, actions);
        ui.execute();
        Item deleted = tracker.findById(item.getId());
        assertNull(deleted);
    }
}