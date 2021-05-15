package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.sort.SortByNameAsc;
import ru.job4j.tracker.sort.SortByNameDesc;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class ItemsSortingTest {

    @Test
    public void whenAscSort() {
        List<Item> items = Arrays.asList(
                new Item(1, "Проверка"),
                new Item(2, "Аудит"),
                new Item(3, "Тест")
        );
        List<Item> expected = Arrays.asList(
                new Item(2, "Аудит"),
                new Item(1, "Проверка"),
                new Item(3, "Тест")
        );
        Collections.sort(items, new SortByNameAsc());
        boolean result = true;
        for (int i = 0; i < items.size(); i++) {
            if (!items.get(i).equals(expected.get(i))) {
                result = false;
                break;
            }
        }
        assertTrue(result);
    }

    @Test
    public void whenDecSort() {
        List<Item> items = Arrays.asList(
                new Item(1, "Проверка"),
                new Item(2, "Аудит"),
                new Item(3, "Тест")
        );
        List<Item> expected = Arrays.asList(
                new Item(3, "Тест"),
                new Item(1, "Проверка"),
                new Item(2, "Аудит")
        );
        Collections.sort(items, new SortByNameDesc());
        boolean result = true;
        for (int i = 0; i < items.size(); i++) {
            if (!items.get(i).equals(expected.get(i))) {
                result = false;
                break;
            }
        }
        assertTrue(result);
    }
}