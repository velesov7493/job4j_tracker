package ru.job4j.tracker;

import java.time.LocalDateTime;

public class Item {

    private int id;
    private String name;
    private LocalDateTime created;

    public Item() {
        created = LocalDateTime.now();
    }

    public Item(String aName) {
        name = aName;
        created = LocalDateTime.now();
    }

    public Item(int aId, String aName) {
        id = aId;
        name = aName;
        created = LocalDateTime.now();
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

    public LocalDateTime getCreated() { return created; }

    public void setCreated(LocalDateTime created) { this.created = created; }
}