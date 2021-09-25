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
    @Column(name = "name")
    private String name;
    @Column(name = "created")
    private Timestamp createdDateTime;
    transient private LocalDateTime created;

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

    public Timestamp getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(Timestamp createdDateTime) {
        this.createdDateTime = createdDateTime;
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