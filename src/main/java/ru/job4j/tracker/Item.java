package ru.job4j.tracker;

public class Item {

    private int id;

    private String name;

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

    public static void main(String[] args) {
        Item item1 = new Item();
        Item item2 = new Item(123);
        Item item3 = new Item("Hello");
        Item item4 = new Item(123,"Hello");
    }
}