package ru.job4j.tracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

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

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    @Override
    public String toString() {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return "Item{"
                + "id=" + id
                + ", name='" + name + '\''
                + ", created=" + created.format(f)
                + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Item item = (Item) o;
        return id == item.id
               && name.equals(item.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}