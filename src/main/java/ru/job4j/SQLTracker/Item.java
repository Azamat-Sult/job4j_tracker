package ru.job4j.SQLTracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Item {

    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    private int id;

    private String name;

    private LocalDateTime created = LocalDateTime.now();

    public Item() {
    }

    public Item(int id) {
        this.id = id;
    }

    public Item(String name) {
        this.name = name;
    }

    public Item(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Item(int id, String name, LocalDateTime ldt) {
        this.id = id;
        this.name = name;
        this.created = ldt;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCurrentDateTime() {
        return created;
    }

    public void setCurrentDateTime(LocalDateTime ldt) {
        this.created = ldt;
    }

    @Override
    public String toString() {
        return "Item {"
                + "id = " + id
                + ", name = " + name
                + ", created = " + FORMATTER.format(created)
                + '}';
    }
}
