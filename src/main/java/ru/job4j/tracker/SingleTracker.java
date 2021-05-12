package ru.job4j.tracker;

public class SingleTracker {

    private static SingleTracker instance = null;

    private Tracker tracker;

    private SingleTracker() {
        tracker = new Tracker();
    }

    public static SingleTracker getInstance() {
        if (instance == null) {
            instance = new SingleTracker();
        }
        return instance;
    }

    public Item add(Item item) {
        return tracker.add(item);
    }

    public Item[] findAll() {
        return tracker.findAll();
    }

    public Item[] findByName(String key) {
        return tracker.findByName(key);
    }

    public Item findById(int id) {
        return tracker.findById(id);
    }

    public boolean replace(int id, Item toItem) {
        return tracker.replace(id, toItem);
    }

    public boolean delete(int id) {
        return tracker.delete(id);
    }
}