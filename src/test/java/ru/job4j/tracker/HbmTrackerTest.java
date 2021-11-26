package ru.job4j.tracker;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class HbmTrackerTest {

    @Test
    public void whenAdd() {
        Store s = new HbmTracker();
        Item in = new Item("Тест-заявка");
        s.add(in);
        assertThat(s.findById(1), is(in));
    }

    @Test
    public void whenReplace() {
        Store s = new HbmTracker();
        Item in = new Item("Тест-заявка");
        s.add(in);
        Item rp = new Item(in.getId(), "Замена заявки");
        s.replace(in.getId(), rp);
        assertThat(s.findById(in.getId()), is(rp));
    }

    @Test
    public void whenDelete() {
        Store s = new HbmTracker();
        Item in = new Item("Тест-заявка");
        s.add(in);
        s.delete(in.getId());
        assertNull(s.findById(in.getId()));
    }

    @Test
    public void whenFindAll() {
        Store s = new HbmTracker();
        List<Item> in = List.of(
                new Item("item1"),
                new Item("item2")
        );
        in.forEach(s::add);
        assertThat(s.findAll(), is(in));
    }

    @Test
    public void whenFindByName() {
        Store s = new HbmTracker();
        List<Item> in = List.of(
                new Item("item1"),
                new Item("item2")
        );
        List<Item> expected = List.of(
                new Item(2, "item2")
        );
        in.forEach(s::add);
        assertThat(s.findByName("item2"), is(expected));
    }

    @Test
    public void whenFindById() {
        Store s = new HbmTracker();
        List<Item> in = List.of(
                new Item("item1"),
                new Item("item2")
        );
        in.forEach(s::add);
        assertThat(s.findById(1), is(in.get(0)));
    }
}