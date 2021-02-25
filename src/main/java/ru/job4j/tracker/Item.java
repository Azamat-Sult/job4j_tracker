package ru.job4j.tracker;

import java.time.LocalDateTime;

public class Item {

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

    public static void main(String[] args) {
        Item item1 = new Item();
        Item item2 = new Item(123);
        Item item3 = new Item("Hello");
        Item item4 = new Item(123,"Hello");
    }
}
