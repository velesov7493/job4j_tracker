package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.actions.AddItemAction;
import ru.job4j.tracker.actions.DeleteItemAction;
import ru.job4j.tracker.actions.ReplaceItemAction;
import ru.job4j.tracker.actions.UserAction;

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
}