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
}