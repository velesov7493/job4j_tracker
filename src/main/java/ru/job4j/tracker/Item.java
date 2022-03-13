package ru.job4j.tracker;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

@Entity
@Table(name = "tz_items")
public class Item {

    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "itemsIdSeq", sequenceName = "tz_items_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "itemsIdSeq")
    private int id;
    private String name;
    private String description;
    private Timestamp created;

    public Item() {
        created = Timestamp.valueOf(LocalDateTime.now());
    }

    public Item(String aName) {
        name = aName;
        created = Timestamp.valueOf(LocalDateTime.now());
    }

    public Item(int aId, String aName) {
        id = aId;
        name = aName;
        created = Timestamp.valueOf(LocalDateTime.now());
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

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return "Item{"
                + "id=" + id
                + ", name='" + name + '\''
                + ", created=" + created.toLocalDateTime().format(f)
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