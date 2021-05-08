package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {

    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    private int indexOf(int id) {
        int result = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                result = index;
                break;
            }
        }
        return result;
    }

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item[] findAll() {
        return Arrays.copyOf(items, size);
    }

    public Item[] findByName(String key) {
        Item[] result = new Item[100];
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (key.equals(items[i].getName())) {
                result[count++] = items[i];
            }
        }
        return Arrays.copyOf(result,count);
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index < 0 ? null : items[index];
    }

    public boolean replace(int id, Item toItem) {
        int index = indexOf(id);
        if (index < 0) { return false; }
        toItem.setId(id);
        items[index] = toItem;
        return true;
    }
}