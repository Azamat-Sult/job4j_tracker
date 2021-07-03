package ru.job4j.sqltracker;

import java.util.Comparator;

public class DownSortItemByName implements Comparator<Item> {
    @Override
    public int compare(Item first, Item second) {
        return second.getName().compareTo(first.getName());
    }
}
