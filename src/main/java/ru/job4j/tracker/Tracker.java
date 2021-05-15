package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class Tracker {

    private final List<Item> items;
    private int ids = 1;

    public Tracker() {
        items = new ArrayList<>();
    }

    private int indexOf(int id) {
        int result = -1;
        for (int i = 0; i < items.size(); i++) {
            Item entry = items.get(i);
            if (entry.getId() == id) {
                result = i;
                break;
            }
        }
        return result;
    }

    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    public List<Item> findAll() {
        return new ArrayList<>(items);
    }

    public List<Item> findByName(String key) {
        ArrayList<Item> result = new ArrayList<>();
        for (Item entry : items) {
            if (key.equals(entry.getName())) {
                result.add(entry);
            }
        }
        return result;
    }

    public Item findById(int id) {
        int i = indexOf(id);
        return i >= 0 ? items.get(i) : null;
    }

    public boolean replace(int id, Item toItem) {
        int i = indexOf(id);
        if (i < 0) {
            return false;
        }
        toItem.setId(id);
        items.set(i, toItem);
        return true;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        if (index < 0) {
            return false;
        }
        items.remove(index);
        return true;
    }
}