package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.actions.DeleteItemAction;
import ru.job4j.tracker.actions.FindItemByIdAction;
import ru.job4j.tracker.actions.FindItemsByNameAction;
import ru.job4j.tracker.actions.ReplaceItemAction;
import ru.job4j.tracker.io.Input;
import ru.job4j.tracker.io.Output;
import ru.job4j.tracker.io.StubOutput;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ActionsTest {

    @Test
    public void whenMockInputReplace() {
        String replacedName = "New item name";
        Output out = new StubOutput();
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(1);
        when(input.askStr(any(String.class))).thenReturn(replacedName);
        MemTracker tracker = new MemTracker();
        tracker.add(new Item("Replaced item"));
        ReplaceItemAction rep = new ReplaceItemAction(input, out, tracker);
        rep.execute();

        String ln = System.lineSeparator();
        String expected =
                "=== Редактирование заявки ===="
                        + ln + "Заявка успешно отредактирована." + ln;

        assertThat(out.toString(), is(expected));
        assertThat(tracker.findAll().get(0).getName(), is(replacedName));
    }

    @Test
    public void whenMockInputDelete() {
        MemTracker tracker = new MemTracker();
        tracker.add(new Item("Deleted item"));
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(1);
        Output out = new StubOutput();
        DeleteItemAction del = new DeleteItemAction(input, out, tracker);
        del.execute();

        String ln = System.lineSeparator();
        String expected =
                "=== Удаление заявки ===="
                        + ln + "Заявка успешно удалена." + ln;

        assertThat(out.toString(), is(expected));
        assertThat(tracker.findAll().isEmpty(), is(true));
    }

    @Test
    public void whenMockInputFindById() {
        MemTracker tracker = new MemTracker();
        Item item = new Item("Target item");
        tracker.add(item);
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(1);
        Output out = new StubOutput();
        FindItemByIdAction find = new FindItemByIdAction(input, out, tracker);
        find.execute();

        String ln = System.lineSeparator();
        String expected =
                "=== Поиск заявки по номеру (id) ===="
                        + ln + item.toString() + ln;

        assertThat(out.toString(), is(expected));
        assertThat(item.getId(), is(1));
    }

    @Test
    public void whenMockInputFindByName() {
        MemTracker tracker = new MemTracker();
        Item item = new Item("Target item");
        tracker.add(item);
        Input input = mock(Input.class);
        when(input.askStr(any(String.class))).thenReturn(item.getName());
        Output out = new StubOutput();
        FindItemsByNameAction find = new FindItemsByNameAction(input, out, tracker);
        find.execute();

        String ln = System.lineSeparator();
        String expected =
                "=== Поиск заявки по имени ===="
                        + ln + item.toString() + ln;

        assertThat(out.toString(), is(expected));
    }
}
