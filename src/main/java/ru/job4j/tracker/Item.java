package ru.job4j.tracker;

public class Item {
    private int id;
    private String name;

    public Item() {}

    public Item(String aName) {
        name = aName;
    }

    public Item(int aId, String aName) {
        id = aId;
        name = aName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}