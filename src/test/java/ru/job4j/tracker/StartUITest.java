package ru.job4j.tracker;

import org.junit.Test;

import static org.junit.Assert.*;

public class StartUITest {

    @Test
    public void whenAddItem() {
        String[] answers = {"Fix PC"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        StartUI ui = new StartUI(input, tracker);
        ui.cmdAddItem();
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
        StartUI ui = new StartUI(new StubInput(answers), tracker);
        ui.cmdEditItem();
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
        StartUI ui = new StartUI(new StubInput(answers), tracker);
        ui.cmdDeleteItem();
        Item deleted = tracker.findById(item.getId());
        assertNull(deleted);
    }
}